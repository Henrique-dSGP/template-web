package com.hdsgp.webshowplantemplate.controller;

import com.hdsgp.webshowplantemplate.exceptions.CidadeNotFoundException;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.model.Cidade;
import com.hdsgp.webshowplantemplate.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    CidadeService cidadeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createCidade(@RequestBody Cidade cidade){
        return cidadeService.createCidade(cidade);
    }

    @GetMapping
    public List<Cidade> getCidadeList(){
        return cidadeService.findall();
    }

    @GetMapping("/{idCidade}")
    public ResponseEntity<Cidade> getCidadeById(@PathVariable("idCidade") Long idCidade) throws Exception{
        return ResponseEntity.ok(cidadeService.findById(idCidade));
    }
    @GetMapping("/nome/{nomeCidade}")
    public ResponseEntity<Cidade> getCidadeByName(@PathVariable("nomeCidade") String nomeCidade) throws Exception{
        return ResponseEntity.ok(cidadeService.getByName(nomeCidade));
    }


    @PutMapping("/{idCidade}")
    public MessageResponseDTO updateCidade(@PathVariable Long idCidade, @RequestBody Cidade cidade) throws CidadeNotFoundException {
        return cidadeService.updateById(idCidade, cidade);
    }

    @DeleteMapping("/{idCidade}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long idCidade) throws CidadeNotFoundException{
        cidadeService.delete(idCidade);
    }
}
