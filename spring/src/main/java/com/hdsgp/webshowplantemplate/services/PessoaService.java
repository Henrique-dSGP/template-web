package com.hdsgp.webshowplantemplate.services;

import com.hdsgp.webshowplantemplate.exceptions.PessoaNotFoundException;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.model.Pessoa;
import com.hdsgp.webshowplantemplate.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public MessageResponseDTO createPessoa(Pessoa pessoa){
        Pessoa savedPessoa = pessoaRepository.save(pessoa);
        return createMessageResponse(savedPessoa.getId(), "Created pessoa with ID: ");
    }
    public MessageResponseDTO updateById(Long id, Pessoa pessoa) throws PessoaNotFoundException{
        verifyIfExists(id);

        Pessoa savedPessoa = pessoaRepository.save(pessoa);
        return createMessageResponse(savedPessoa.getId(), "Updated pessoa with ID: ");
    }

    public Pessoa findById(Long id)throws PessoaNotFoundException{
        return verifyIfExists(id);
    }

    public List<Pessoa> findall(){

        return pessoaRepository.findAll();
    }

    public void delete(Long id) throws PessoaNotFoundException{
        verifyIfExists(id);
        pessoaRepository.deleteById(id);
    }


    private MessageResponseDTO createMessageResponse(Long id, String s) {
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
        messageResponseDTO.setMessage(s + id);
        return messageResponseDTO;
    }

    private Pessoa verifyIfExists(Long id) throws  PessoaNotFoundException {
        return pessoaRepository.findById(id).orElseThrow(()-> new PessoaNotFoundException(id));
    }
}
