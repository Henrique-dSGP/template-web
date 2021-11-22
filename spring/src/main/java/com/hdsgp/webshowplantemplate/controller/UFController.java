package com.hdsgp.webshowplantemplate.controller;

import com.hdsgp.webshowplantemplate.model.Cidade;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.model.UF;
import com.hdsgp.webshowplantemplate.services.CidadeAtuacaoService;
import com.hdsgp.webshowplantemplate.services.UFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
@RequestMapping("/uf")
public class UFController {

    @Autowired
    UFService ufService;
    @Autowired
    CidadeAtuacaoService cidadeAtuacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createUF(@RequestBody UF uf){
        return ufService.createUF(uf);
    }

    @GetMapping
    public List<UF> getUFList(){
        return ufService.findall();
    }

    @GetMapping("/{idUF}")
    public ResponseEntity<UF> getUFById(@PathVariable("idUF") Long idUF) throws Exception{
        return ResponseEntity.ok(ufService.getById(idUF).orElseThrow(() -> new NoSuchElementException("Not Found!")));
    }
    @PutMapping
    public UF updateUF(@RequestBody UF uf){
        return ufService.updateUF(uf);
    }
}
