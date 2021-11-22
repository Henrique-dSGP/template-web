package com.hdsgp.webshowplantemplate;

import com.google.gson.Gson;
import com.hdsgp.webshowplantemplate.model.Cidade;
import com.hdsgp.webshowplantemplate.model.UF;
import com.hdsgp.webshowplantemplate.utils.Util;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Slameo {
    public static void main(String[] args) {


        try {
            JSONObject jsonObject = new JSONObject();
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = new JSONArray();
            ArrayList<JSONObject> jsonObjects = new ArrayList<>();
            URL url = new URL("https://servicodados.ibge.gov.br/api/v1/localidades/estados/35/municipios");
            URL urlEstados = new URL("https://servicodados.ibge.gov.br/api/v1/localidades/estados/");
            HttpURLConnection conn = (HttpURLConnection)urlEstados.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if(responseCode == 200) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );
                String jsonEmString = Util.converteJsonEmString(reader);

                Gson gson = new Gson();
                int i =1;
                //com o retorno de uma lista de jsons, é necessario passar para uma lista do tipo.
                UF[] uf = gson.fromJson(jsonEmString.replace("\\[", ""), UF[].class);
                for (UF u :
                        uf) {
                    URL url2 = new URL("http://localhost:8082/uf");
                    HttpURLConnection conPost = (HttpURLConnection) url2.openConnection();
                    conPost.setRequestMethod("POST");
                    conPost.setRequestProperty("Content-Type", "application/json; utf-8");
                    conPost.setDoOutput(true);
                    OutputStream os = conPost.getOutputStream();
                    byte[] input = gson.toJson(u).getBytes(StandardCharsets.UTF_8);
                    System.out.println(gson.toJson(u));
                    os.write(input, 0, input.length);
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(conPost.getInputStream(), StandardCharsets.UTF_8));
                    StringBuilder response = new StringBuilder();
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    System.out.println(response.toString());

                    System.out.println(u + " " +i);
                    //pegar cidades por UF
                    URL urlCidade = new URL("https://servicodados.ibge.gov.br/api/v1/localidades/estados/"+ u.getId() +"/municipios");
                    HttpURLConnection conCity = (HttpURLConnection) urlCidade.openConnection();
                    conCity.setRequestMethod("GET");
                    conCity.connect();
                    int responseCodeCity = conCity.getResponseCode();
                    if (responseCodeCity == 200){
                        BufferedReader reader1 = new BufferedReader(
                                new InputStreamReader(conCity.getInputStream())
                        );
                        String cidadeJsonEmString = Util.converteJsonEmString(reader1);

                        Gson gson1 = new Gson();
                        int j=1;

                        Cidade[] cidades = gson.fromJson(cidadeJsonEmString.replace("\\[", ""), Cidade[].class);
                        for(Cidade c : cidades){
                            c.setUf(u);
                            System.out.println("\ngsdfgsdfg sdfgs" + c);
                            URL url3 = new URL("http://localhost:8082/cidade");
                            HttpURLConnection conPostCity = (HttpURLConnection) url3.openConnection();
                            conPostCity.setRequestMethod("POST");
                            conPostCity.setRequestProperty("Content-Type", "application/json; utf-8");
                            conPostCity.setDoOutput(true);
                            OutputStream outputStream = conPostCity.getOutputStream();
                            byte[] input2 = gson.toJson(c).getBytes(StandardCharsets.UTF_8);
                            System.out.println(gson.toJson(c));
                            outputStream.write(input2, 0, input2.length);
                            BufferedReader br2 = new BufferedReader(
                                    new InputStreamReader(conPostCity.getInputStream(), StandardCharsets.UTF_8)
                            );
                            StringBuilder response2 = new StringBuilder();
                            String responseLine2 = null;
                            while((responseLine2 = br.readLine()) !=null){
                                response2.append(responseLine2.trim());
                            }
                            System.out.println(response2.toString());
                            System.out.println(c + " " + i);
                        }
                    }

                    i++;
                }
                //System.out.println(uf);

                String inputLine;
                String response = "";
                while((inputLine = reader.readLine()) != null){
                    response = inputLine;
                    //jsonObjects.add(new JSONObject(response.toString().replaceFirst("\\[", "")));

                }
                //System.out.println(response);
                reader.close();
                //System.out.println(response.toString());
                //jsonObject = new JSONObject(response.toString().replaceFirst("\\[", ""));
                //JSONArray jsonArray = jsonObject.getJSONArray("nome");
                //System.out.println(response);
               // System.out.println(jsonObjects.get(5));
                //System.out.println(jsonObjects);
                //System.out.println(response);
                //System.out.println(jsonArray);
                /*Scanner scan = new Scanner(url.openStream());
                while(scan.hasNext()) {
                    String temp = scan.nextLine();
                    jsonObject = new JSONObject(temp);
                    System.out.println(jsonObject);
                    //parse json here
                }*/
            }
            } catch (IOException e) {
            e.printStackTrace();
            }



            /*while ((output = br.readLine()) != null) {

                System.out.println(output);
            }*/
            //con.disconnect();
/*
            int responsecode = con.getResponseCode();

            if (responsecode!= 200){
                throw new RuntimeException("HttpResponseCode: "+ responsecode);
            }else{
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                while(scanner.hasNext()){
                    inline += (scanner.nextLine());
                }

                scanner.close();

                JSONParser parser = new JSONParser();

                JSONObject jsonObject = (JSONObject) parser.parse(inline.toString());
                System.out.println(jsonObject);
            }*/
    }
}
