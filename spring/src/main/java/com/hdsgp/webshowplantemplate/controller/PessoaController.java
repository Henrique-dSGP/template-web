package com.hdsgp.webshowplantemplate.controller;

import com.hdsgp.webshowplantemplate.exceptions.PessoaNotFoundException;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.model.Pessoa;
import com.hdsgp.webshowplantemplate.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.createPessoa(pessoa);
    }

    @GetMapping
    public List<Pessoa> getPessoaList(){
        return pessoaService.findall();
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable("idPessoa") Long idPessoa) throws Exception{
        return ResponseEntity.ok(pessoaService.findById(idPessoa));
    }

    @PutMapping("/{idPessoa}")
    public MessageResponseDTO updatePessoa(@PathVariable Long idPessoa, @RequestBody Pessoa pessoa) throws PessoaNotFoundException {
        return pessoaService.updateById(idPessoa, pessoa);
    }

    @DeleteMapping("/{idPessoa}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long idPessoa) throws PessoaNotFoundException{
        pessoaService.delete(idPessoa);
    }
}
