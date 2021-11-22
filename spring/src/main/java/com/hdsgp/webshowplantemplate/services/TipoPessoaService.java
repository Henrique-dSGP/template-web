package com.hdsgp.webshowplantemplate.services;

import com.hdsgp.webshowplantemplate.exceptions.CidadeNotFoundException;
import com.hdsgp.webshowplantemplate.exceptions.TipoPessoaNotFoundException;
import com.hdsgp.webshowplantemplate.model.Cidade;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.model.TipoPessoa;
import com.hdsgp.webshowplantemplate.repository.TipoPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Replaced
@Service
public class TipoPessoaService {

    TipoPessoaRepository tipoPessoaRepository;

    @Autowired
    public TipoPessoaService(TipoPessoaRepository tipoPessoaRepository){
        this.tipoPessoaRepository = tipoPessoaRepository;
    }

    public MessageResponseDTO createTipoPessoa(TipoPessoa tipoPessoa){
        TipoPessoa savedTipoPessoa = tipoPessoaRepository.save(tipoPessoa);
        return createMessageResponse(savedTipoPessoa.getId(), "Created tipo pessoa with ID: ");
    }

    public TipoPessoa findById(Long id)throws TipoPessoaNotFoundException{
        return verifyIfExists(id);
    }
    public MessageResponseDTO updateById(Long id, TipoPessoa tipoPessoa) throws TipoPessoaNotFoundException {
        verifyIfExists(id);

        TipoPessoa  savedTipoPessoa = tipoPessoaRepository.save(tipoPessoa);
        return createMessageResponse(savedTipoPessoa.getId(), "Updated tipo pessoa with ID: ");
    }

    public List<TipoPessoa> findall(){

        return tipoPessoaRepository.findAll();
    }

    public void delete(Long id) throws TipoPessoaNotFoundException{
        verifyIfExists(id);
        tipoPessoaRepository.deleteById(id);
    }


    private MessageResponseDTO createMessageResponse(Long id, String s) {
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
        messageResponseDTO.setMessage(s + id);
        return messageResponseDTO;
    }

    private TipoPessoa verifyIfExists(Long id) throws  TipoPessoaNotFoundException {
        return tipoPessoaRepository.findById(id).orElseThrow(()-> new TipoPessoaNotFoundException(id));
    }
}
