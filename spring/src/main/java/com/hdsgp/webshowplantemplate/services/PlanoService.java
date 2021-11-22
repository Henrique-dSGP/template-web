package com.hdsgp.webshowplantemplate.services;

import com.hdsgp.webshowplantemplate.exceptions.PlanoNotFoundException;
import com.hdsgp.webshowplantemplate.model.Cidade;
import com.hdsgp.webshowplantemplate.model.Local;
import com.hdsgp.webshowplantemplate.model.Plano;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanoService {

    PlanoRepository planoRepository;

    @Autowired
    public PlanoService(PlanoRepository planoRepository){
        this.planoRepository = planoRepository;
    }

    public MessageResponseDTO createPlano(Plano plano){
        Plano savedPlano = planoRepository.save(plano);
        return createMessageResponse(savedPlano.getId(), "Created plano with ID: ");
    }

    public Plano findById(Long id)throws PlanoNotFoundException{
        return verifyIfExists(id);
    }
    public MessageResponseDTO updateById(Long id, Plano plano) throws PlanoNotFoundException {
        verifyIfExists(id);

        Plano savedPlano = planoRepository.save(plano);
        return createMessageResponse(savedPlano.getId(), "Updated plano with ID: ");
    }

    public List<Plano> findByCidadeId(String cidade){
        return planoRepository.findAll().stream().filter(plano -> idToString(plano.getCidadeAtuacao().getId()).equals(cidade)).collect(Collectors.toList());
    }
    public String idToString(Long id){
        return "" + id;
    }

    public List<Plano> findall(){

        return planoRepository.findAll();
    }

    public void delete(Long id) throws PlanoNotFoundException{
        verifyIfExists(id);
        planoRepository.deleteById(id);
    }


    private MessageResponseDTO createMessageResponse(Long id, String s) {
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
        messageResponseDTO.setMessage(s + id);
        return messageResponseDTO;
    }

    private Plano verifyIfExists(Long id) throws  PlanoNotFoundException {
        return planoRepository.findById(id).orElseThrow(()-> new PlanoNotFoundException(id));
    }
}
