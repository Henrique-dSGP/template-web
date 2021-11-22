package com.hdsgp.webshowplantemplate.controller;

import com.hdsgp.webshowplantemplate.exceptions.PlanoNotFoundException;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.model.Pessoa;
import com.hdsgp.webshowplantemplate.model.Plano;
import com.hdsgp.webshowplantemplate.services.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/admin/plano")
public class PlanoController {

    @Autowired
    PlanoService planoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPlano(@RequestBody Plano plano){
        return planoService.createPlano(plano);
    }

    @GetMapping
    public List<Plano> getPlanoList(){return planoService.findall();}

    @GetMapping("/{idPlano}")
    public ResponseEntity<Plano> getPlanoById(@PathVariable("idPlano") Long idPlano) throws PlanoNotFoundException {
        return ResponseEntity.ok(planoService.findById(idPlano));
    }
    @GetMapping("/cidade/{idCidade}")
    public List<Plano> getPlanoByCity(@PathVariable("idCidade") String idCidade){return planoService.findByCidadeId(idCidade);}

    @PutMapping("/{idPlano}")
    public MessageResponseDTO updatePlano(@PathVariable Long idPlano, @RequestBody Plano plano) throws PlanoNotFoundException{
        return planoService.updateById(idPlano, plano);
    }

    @DeleteMapping("/{idPlano}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long idPlano) throws PlanoNotFoundException{
        planoService.delete(idPlano);
    }
}
