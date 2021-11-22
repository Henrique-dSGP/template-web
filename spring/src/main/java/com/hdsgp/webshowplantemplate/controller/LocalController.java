package com.hdsgp.webshowplantemplate.controller;

import com.hdsgp.webshowplantemplate.exceptions.LocalNotFoundException;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.model.Local;
import com.hdsgp.webshowplantemplate.services.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/local")
public class LocalController {

    @Autowired
    LocalService localService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createLocal(@RequestBody Local local){
        return localService.createLocal(local);
    }

    @GetMapping
    public List<Local> getLocalList(){
        return localService.findall();
    }

    @GetMapping("/{idLocal}")
    public ResponseEntity<Local> getLocalById(@PathVariable("idLocal") Long idLocal) throws Exception{
        return ResponseEntity.ok(localService.findById(idLocal));
    }

    @PutMapping("/{idLocal}")
    public MessageResponseDTO updateLocal(@PathVariable Long idLocal, @RequestBody Local local) throws LocalNotFoundException {
        return localService.updateById(idLocal, local);
    }

    @DeleteMapping("/{idLocal}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long idLocal) throws LocalNotFoundException{
        localService.delete(idLocal);
    }
}
