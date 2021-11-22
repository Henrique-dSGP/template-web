package com.hdsgp.webshowplantemplate.services;

import com.hdsgp.webshowplantemplate.exceptions.CidadeNotFoundException;
import com.hdsgp.webshowplantemplate.model.Cidade;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.model.Pessoa;
import com.hdsgp.webshowplantemplate.model.UF;
import com.hdsgp.webshowplantemplate.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeService {

    CidadeRepository cidadeRepository;

    @Autowired
    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public Cidade findById(Long id) throws CidadeNotFoundException{
        return verifyIfExists(id);
    }

    public List<Cidade> getListByUF(UF uf){
        return cidadeRepository.findAll()
                .stream()
                .filter(u -> u.getUf() == uf)
                .collect(Collectors.toList());
    }

    public Cidade getByName(String cidadeName){
        String cidadeNomeCorrigido = cidadeName.replace("-", " ");
        return cidadeRepository.findAll().stream().filter(c -> c.getNome().equals(cidadeName)).collect(Collectors.toList()).get(0);
    }

    public List<Cidade> findall(){
        return cidadeRepository.findAll();
    }

    public void delete(Long id) throws CidadeNotFoundException{
        verifyIfExists(id);
        cidadeRepository.deleteById(id);
    }
    public MessageResponseDTO updateById(Long id, Cidade cidade) throws CidadeNotFoundException {
        verifyIfExists(id);

        Cidade savedCidade = cidadeRepository.save(cidade);
        return createMessageResponse(savedCidade.getId(), "Updated cidade with ID: ");
    }

    private Cidade verifyIfExists(Long id)  throws CidadeNotFoundException{
        return cidadeRepository.findById(id).orElseThrow(() -> new CidadeNotFoundException(id));
    }

    public MessageResponseDTO createCidade(Cidade cidade){
        Cidade savedCidade = cidadeRepository.save(cidade);
        return createMessageResponse(savedCidade.getId(), "Created cidade with ID ");
    }

    private MessageResponseDTO createMessageResponse(Long id, String s) {
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
        messageResponseDTO.setMessage(s + id);
        return messageResponseDTO;
    }
}
