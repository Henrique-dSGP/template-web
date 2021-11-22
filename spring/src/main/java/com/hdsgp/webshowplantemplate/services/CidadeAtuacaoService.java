package com.hdsgp.webshowplantemplate.services;

import com.hdsgp.webshowplantemplate.exceptions.CidadeAtuacaoNotFoundException;
import com.hdsgp.webshowplantemplate.model.CidadeAtuacao;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.model.UF;
import com.hdsgp.webshowplantemplate.repository.CidadeAtuacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeAtuacaoService {

    CidadeAtuacaoRepository cidadeAtuacaoRepository;

    @Autowired
    public CidadeAtuacaoService(CidadeAtuacaoRepository cidadeAtuacaoRepository) {
        this.cidadeAtuacaoRepository = cidadeAtuacaoRepository;
    }

    public CidadeAtuacao findById(Long id) throws CidadeAtuacaoNotFoundException{
        return verifyIfExists(id);
    }

    public List<CidadeAtuacao> getListByUF(UF uf){
        return cidadeAtuacaoRepository.findAll()
                .stream()
                .filter(u -> u.getUf() == uf)
                .collect(Collectors.toList());
    }
    public List<CidadeAtuacao> getListByUFId(Long ufId){
        return cidadeAtuacaoRepository.findAll()
                .stream()
                .filter(u -> u.getUf().getId() == ufId)
                .collect(Collectors.toList());
    }

    public List<UF> getListUFByCityActuation(){
        List<UF> ufList = new ArrayList<>();
        cidadeAtuacaoRepository.findAll().forEach(f -> ufList.add(f.getUf()));
        return ufList.stream().distinct().collect(Collectors.toList());
    }

    public CidadeAtuacao getByName(String cidadeAtuacaoName){
        String cidadeAtuacaoNomeCorrigido = cidadeAtuacaoName.replace("-", " ");
        return cidadeAtuacaoRepository.findAll().stream().filter(c -> c.getNome().equals(cidadeAtuacaoName)).collect(Collectors.toList()).get(0);
    }

    public List<CidadeAtuacao> findall(){
        return cidadeAtuacaoRepository.findAll();
    }

    public void delete(Long id) throws CidadeAtuacaoNotFoundException{
        verifyIfExists(id);
        cidadeAtuacaoRepository.deleteById(id);
    }
    public MessageResponseDTO updateById(Long id, CidadeAtuacao cidadeAtuacao) throws CidadeAtuacaoNotFoundException {
        verifyIfExists(id);

        CidadeAtuacao savedCidadeAtuacao = cidadeAtuacaoRepository.save(cidadeAtuacao);
        return createMessageResponse(savedCidadeAtuacao.getId(), "Updated cidadeAtuacao with ID: ");
    }

    private CidadeAtuacao verifyIfExists(Long id)  throws CidadeAtuacaoNotFoundException{
        return cidadeAtuacaoRepository.findById(id).orElseThrow(() -> new CidadeAtuacaoNotFoundException(id));
    }

    public MessageResponseDTO createCidadeAtuacao(CidadeAtuacao cidadeAtuacao){
        CidadeAtuacao savedCidadeAtuacao = cidadeAtuacaoRepository.save(cidadeAtuacao);
        return createMessageResponse(savedCidadeAtuacao.getId(), "Created cidadeAtuacao with ID ");
    }

    private MessageResponseDTO createMessageResponse(Long id, String s) {
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
        messageResponseDTO.setMessage(s + id);
        return messageResponseDTO;
    }
}
