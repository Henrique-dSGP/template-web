package com.hdsgp.webshowplantemplate.controller;

import com.hdsgp.webshowplantemplate.model.Cidade;
import com.hdsgp.webshowplantemplate.model.Plano;
import com.hdsgp.webshowplantemplate.model.UF;
import com.hdsgp.webshowplantemplate.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/planos")
public class ShowRoomController {

    @Autowired
    PlanoService planoService;
    @Autowired
    LocalService localService;
    @Autowired
    CidadeService cidadeService;
    @Autowired
    CidadeAtuacaoService cidadeAtuacaoService;
    @Autowired
    UFService ufService;

    @GetMapping
    @RequestMapping("/{ufString}")
    public List<Cidade> getCidadeList(@PathVariable("ufString") String ufString){
        UF uf = new UF();
        uf = ufService.verifyIfIsNameOrAbbAndCallMethod(ufString);
        UF finalUf = uf;
        return cidadeService.findall().stream().filter(c -> c.getUf() == finalUf).collect(Collectors.toList());
    }

    @GetMapping("/{cityName}")
    public List<Plano> getPlanoList(@PathVariable("cityName") String cityName){
        String cID = cidadeAtuacaoService.getByName(cityName).getId() + "";
        System.out.println(cID);
        return planoService.findByCidadeId(cID);
    }

    /*@GetMapping
    @RequestMapping("/cidade/{cidadeString}")
    public List<Plano> getPlanoList(@PathVariable("cidadeString") String cidadeString){
        Local local = localService.findByCity(cidadeString);
        return planoService.findByLocal(local);

    }*/

}
