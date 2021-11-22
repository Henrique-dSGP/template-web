package com.hdsgp.webshowplantemplate.services;

import com.hdsgp.webshowplantemplate.exceptions.CidadeNotFoundException;
import com.hdsgp.webshowplantemplate.exceptions.EnderecoNotFoundException;
import com.hdsgp.webshowplantemplate.exceptions.LocalNotFoundException;
import com.hdsgp.webshowplantemplate.model.Cidade;
import com.hdsgp.webshowplantemplate.model.Endereco;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    public MessageResponseDTO createEndereco(Endereco endereco){
        Endereco savedEndereco = enderecoRepository.save(endereco);
        return createMessageResponse(savedEndereco.getId(), "Created endereco with ID ");
    }

    public Endereco findById(Long id) throws EnderecoNotFoundException{
        return verifyIfExists(id);
    }
    public MessageResponseDTO updateById(Long id, Endereco endereco) throws EnderecoNotFoundException {
        verifyIfExists(id);

        Endereco savedEndereco = enderecoRepository.save(endereco);
        return createMessageResponse(savedEndereco.getId(), "Updated endereco with ID: ");
    }

    public List<Endereco> findAll(){
        return enderecoRepository.findAll();
    }

    public void delete(Long id) throws EnderecoNotFoundException {
        verifyIfExists(id);
        enderecoRepository.deleteById(id);
    }

    private Endereco verifyIfExists(Long id) throws EnderecoNotFoundException{
        return enderecoRepository.findById(id).orElseThrow(()-> new EnderecoNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String s) {
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
        messageResponseDTO.setMessage(s + id);
        return messageResponseDTO;
    }
}
