package com.hdsgp.webshowplantemplate.controller;

import com.hdsgp.webshowplantemplate.exceptions.DisponibilidadeNotFoundException;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.model.Disponibilidade;
import com.hdsgp.webshowplantemplate.services.DisponibilidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disponibilidade")
public class DisponibilidadeController {

    @Autowired
    DisponibilidadeService disponibilidadeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createDisponibilidade(@RequestBody Disponibilidade disponibilidade){
        return disponibilidadeService.createDisponibilidade(disponibilidade);
    }

    @GetMapping
    public List<Disponibilidade> getDisponibilidadeList(){
        return disponibilidadeService.findall();
    }

    @GetMapping("/{idDisponibilidade}")
    public ResponseEntity<Disponibilidade> getDisponibilidadeById(@PathVariable("idDisponibilidade") Long idDisponibilidade) throws Exception{
        return ResponseEntity.ok(disponibilidadeService.findById(idDisponibilidade));
    }

    @PutMapping("/{idDisponibilidade}")
    public MessageResponseDTO updateDisponibilidade(@PathVariable Long idDisponibilidade, @RequestBody Disponibilidade disponibilidade) throws DisponibilidadeNotFoundException {
        return disponibilidadeService.updateById(idDisponibilidade, disponibilidade);
    }

    @DeleteMapping("/{idDisponibilidade}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long idDisponibilidade) throws DisponibilidadeNotFoundException{
        disponibilidadeService.delete(idDisponibilidade);
    }
}
