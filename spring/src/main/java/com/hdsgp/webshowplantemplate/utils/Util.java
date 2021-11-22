package com.hdsgp.webshowplantemplate.utils;

import com.hdsgp.webshowplantemplate.model.UF;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Util {
    public static String converteJsonEmString(BufferedReader bufferedReader) throws IOException{
        String resposta, jsonEmString = "";
        while((resposta = bufferedReader.readLine()) != null){
            jsonEmString += resposta;
        }
        return jsonEmString;
    }

}
