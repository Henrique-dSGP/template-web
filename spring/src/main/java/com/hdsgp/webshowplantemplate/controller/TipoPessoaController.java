package com.hdsgp.webshowplantemplate.controller;

import com.hdsgp.webshowplantemplate.exceptions.TipoPessoaNotFoundException;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.model.TipoPessoa;
import com.hdsgp.webshowplantemplate.services.TipoPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-pessoa")
public class TipoPessoaController {

    @Autowired
    TipoPessoaService tipoPessoaS;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createTipoPessoa(@RequestBody TipoPessoa tipoTipoPessoa){
        return tipoPessoaS.createTipoPessoa(tipoTipoPessoa);
    }

    @GetMapping
    public List<TipoPessoa> getTipoPessoaList(){
        return tipoPessoaS.findall();
    }

    @GetMapping("/{idTipoPessoa}")
    public ResponseEntity<TipoPessoa> getTipoPessoaById(@PathVariable("idTipoPessoa") Long idTipoPessoa) throws Exception{
        return ResponseEntity.ok(tipoPessoaS.findById(idTipoPessoa));
    }

    @PutMapping("/{idTipoPessoa}")
    public MessageResponseDTO updateTipoPessoa(@PathVariable Long idTipoPessoa, @RequestBody TipoPessoa tipoTipoPessoa) throws TipoPessoaNotFoundException {
        return tipoPessoaS.updateById(idTipoPessoa, tipoTipoPessoa);
    }

    @DeleteMapping("/{idTipoPessoa}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long idTipoPessoa) throws TipoPessoaNotFoundException{
        tipoPessoaS.delete(idTipoPessoa);
    }
}
