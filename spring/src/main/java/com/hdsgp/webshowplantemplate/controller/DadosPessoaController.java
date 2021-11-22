package com.hdsgp.webshowplantemplate.controller;

import com.hdsgp.webshowplantemplate.exceptions.DadosPessoaNotFoundException;
import com.hdsgp.webshowplantemplate.model.DadosPessoa;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.services.DadosPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dadosPessoa")
public class DadosPessoaController {

    @Autowired
    DadosPessoaService dadosPessoaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createDadosPessoa(@RequestBody DadosPessoa dadosPessoa){
        return dadosPessoaService.createDadosPessoa(dadosPessoa);
    }

    @GetMapping
    public List<DadosPessoa> getDadosPessoaList(){
        return dadosPessoaService.findall();
    }

    @GetMapping("/{idDadosPessoa}")
    public ResponseEntity<DadosPessoa> getDadosPessoaById(@PathVariable("idDadosPessoa") Long idDadosPessoa) throws Exception{
        return ResponseEntity.ok(dadosPessoaService.findById(idDadosPessoa));
    }

    @PutMapping("/{idDadosPessoa}")
    public MessageResponseDTO updateDadosPessoa(@PathVariable Long idDadosPessoa, @RequestBody DadosPessoa dadosPessoa) throws DadosPessoaNotFoundException {
        return dadosPessoaService.updateById(idDadosPessoa, dadosPessoa);
    }

    @DeleteMapping("/{idDadosPessoa}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long idDadosPessoa) throws DadosPessoaNotFoundException{
        dadosPessoaService.delete(idDadosPessoa);
    }
}
