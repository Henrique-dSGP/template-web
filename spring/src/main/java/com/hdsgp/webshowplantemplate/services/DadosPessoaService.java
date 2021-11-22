package com.hdsgp.webshowplantemplate.services;

import com.hdsgp.webshowplantemplate.exceptions.CidadeNotFoundException;
import com.hdsgp.webshowplantemplate.exceptions.DadosPessoaNotFoundException;
import com.hdsgp.webshowplantemplate.model.Cidade;
import com.hdsgp.webshowplantemplate.model.DadosPessoa;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.repository.DadosPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosPessoaService {

    DadosPessoaRepository dadosPessoaRepository;

    @Autowired
    public DadosPessoaService(DadosPessoaRepository dadosPessoaRepository){
        this.dadosPessoaRepository = dadosPessoaRepository;
    }

    public MessageResponseDTO createDadosPessoa(DadosPessoa dadosPessoa){
        DadosPessoa savedDadosPessoa = dadosPessoaRepository.save(dadosPessoa);
        return createMessageResponse(savedDadosPessoa.getId(), "Created with ID ");
    }

    public DadosPessoa findById(Long id) throws DadosPessoaNotFoundException{
        return verifyIfExists(id);
    }
    public MessageResponseDTO updateById(Long id, DadosPessoa dadosPessoa) throws DadosPessoaNotFoundException {
        verifyIfExists(id);

        DadosPessoa savedDadosPessoa = dadosPessoaRepository.save(dadosPessoa);
        return createMessageResponse(savedDadosPessoa.getId(), "Updated cidade with ID: ");
    }

    public List<DadosPessoa> findall(){
        return dadosPessoaRepository.findAll();
    }

    public void delete(Long id) throws DadosPessoaNotFoundException {
        verifyIfExists(id);
        dadosPessoaRepository.deleteById(id);
    }

    private DadosPessoa verifyIfExists(Long id) throws DadosPessoaNotFoundException{
        return dadosPessoaRepository.findById(id).orElseThrow(() -> new DadosPessoaNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String s) {
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
        messageResponseDTO.setMessage(s + id);
        return messageResponseDTO;
    }


}
