package com.hdsgp.webshowplantemplate.services;

import com.hdsgp.webshowplantemplate.exceptions.CidadeNotFoundException;
import com.hdsgp.webshowplantemplate.exceptions.DisponibilidadeNotFoundException;
import com.hdsgp.webshowplantemplate.model.Cidade;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.model.Disponibilidade;
import com.hdsgp.webshowplantemplate.repository.DisponibilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisponibilidadeService {

    DisponibilidadeRepository disponibilidadeRepository;

    @Autowired
    public DisponibilidadeService(DisponibilidadeRepository disponibilidadeRepository){
        this.disponibilidadeRepository = disponibilidadeRepository;
    }

    public MessageResponseDTO createDisponibilidade(Disponibilidade disponibilidade){
        Disponibilidade savedDisponibilidade = disponibilidadeRepository.save(disponibilidade);
        return createMessageResponse(savedDisponibilidade.getId(), "Created disponibilidade with ID: ");
    }

    public Disponibilidade findById(Long id)throws DisponibilidadeNotFoundException{
        return verifyIfExists(id);
    }

    public MessageResponseDTO updateById(Long id, Disponibilidade disponibilidade) throws DisponibilidadeNotFoundException {
        verifyIfExists(id);

        Disponibilidade savedDisponibilidade = disponibilidadeRepository.save(disponibilidade);
        return createMessageResponse(savedDisponibilidade.getId(), "Updated disponibilidade with ID: ");
    }

    public List<Disponibilidade> findall(){

        return disponibilidadeRepository.findAll();
    }

    public void delete(Long id) throws DisponibilidadeNotFoundException{
        verifyIfExists(id);
        disponibilidadeRepository.deleteById(id);
    }


    private MessageResponseDTO createMessageResponse(Long id, String s) {
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
        messageResponseDTO.setMessage(s + id);
        return messageResponseDTO;
    }

    private Disponibilidade verifyIfExists(Long id) throws  DisponibilidadeNotFoundException {
        return disponibilidadeRepository.findById(id).orElseThrow(()-> new DisponibilidadeNotFoundException(id));
    }
}
