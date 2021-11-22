package com.hdsgp.webshowplantemplate.controller;

import com.hdsgp.webshowplantemplate.exceptions.CidadeAtuacaoNotFoundException;
import com.hdsgp.webshowplantemplate.model.CidadeAtuacao;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.model.UF;
import com.hdsgp.webshowplantemplate.services.CidadeAtuacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cidades-disponiveis")
public class CidadeAtuacaoController {

    @Autowired
    CidadeAtuacaoService cidadeAtuacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createCidadeAtuacao(@RequestBody CidadeAtuacao cidadeAtuacao){
        return cidadeAtuacaoService.createCidadeAtuacao(cidadeAtuacao);
    }

    @GetMapping
    public List<CidadeAtuacao> getCidadeAtuacaoList(){
        return cidadeAtuacaoService.findall();
    }

    @GetMapping("/{idCidadeAtuacao}")
    public ResponseEntity<CidadeAtuacao> getCidadeAtuacaoById(@PathVariable("idCidadeAtuacao") Long idCidadeAtuacao) throws Exception{
        return ResponseEntity.ok(cidadeAtuacaoService.findById(idCidadeAtuacao));
    }
    @GetMapping("/nome/{nomeCidadeAtuacao}")
    public ResponseEntity<CidadeAtuacao> getCidadeAtuacaoByName(@PathVariable("nomeCidadeAtuacao") String nomeCidadeAtuacao) throws Exception{
        return ResponseEntity.ok(cidadeAtuacaoService.getByName(nomeCidadeAtuacao));
    }
    @GetMapping("/ufs")
    public List<UF> getUFsByCity(){
        System.out.println(cidadeAtuacaoService.getListUFByCityActuation());
        return cidadeAtuacaoService.getListUFByCityActuation();
    }

    @GetMapping("/byUf/{ufId}")
    public List<CidadeAtuacao> getCityActuationByUFId(@PathVariable("ufId") Long ufId){
        return cidadeAtuacaoService.getListByUFId(ufId);
    }
    @PutMapping("/{idCidadeAtuacao}")
    public MessageResponseDTO updateCidadeAtuacao(@PathVariable("idCidadeAtuacao") Long idCidadeAtuacao, @RequestBody CidadeAtuacao cidadeAtuacao) throws CidadeAtuacaoNotFoundException {
        return cidadeAtuacaoService.updateById(idCidadeAtuacao, cidadeAtuacao);
    }

    @DeleteMapping("/{idCidadeAtuacao}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long idCidadeAtuacao) throws CidadeAtuacaoNotFoundException{
        cidadeAtuacaoService.delete(idCidadeAtuacao);
    }
}
