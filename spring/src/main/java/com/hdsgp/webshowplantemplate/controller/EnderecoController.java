package com.hdsgp.webshowplantemplate.controller;

import com.hdsgp.webshowplantemplate.exceptions.EnderecoNotFoundException;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.model.Endereco;
import com.hdsgp.webshowplantemplate.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createEndereco(@RequestBody Endereco endereco){
        return enderecoService.createEndereco(endereco);
    }

    @GetMapping
    public List<Endereco> getEnderecoList(){
        return enderecoService.findAll();
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable("idEndereco") Long idEndereco) throws Exception{
        return ResponseEntity.ok(enderecoService.findById(idEndereco));
    }

    @PutMapping("/{idEndereco}")
    public MessageResponseDTO updateEndereco(@PathVariable Long idEndereco, @RequestBody Endereco endereco) throws EnderecoNotFoundException {
        return enderecoService.updateById(idEndereco, endereco);
    }

    @DeleteMapping("/{idEndereco}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long idEndereco) throws EnderecoNotFoundException{
        enderecoService.delete(idEndereco);
    }
}
