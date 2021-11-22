package com.hdsgp.webshowplantemplate.services;

import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.model.Pessoa;
import com.hdsgp.webshowplantemplate.model.UF;
import com.hdsgp.webshowplantemplate.repository.UFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UFService {

    UFRepository ufRepository;

    @Autowired
    public UFService(UFRepository ufRepository){
        this.ufRepository = ufRepository;
    }

    public List<UF> findall(){
        return ufRepository.findAll();
    }

    public UF getUFByName(String ufString){
        List<UF> uFList = new ArrayList<>();
        uFList = ufRepository.findAll().stream().filter(uf -> uf.getNome().equals(ufString)).collect(Collectors.toList());
        return uFList.get(0);
    }

    public UF getUFByAbb(String ufString){
        List<UF> uFList = new ArrayList<>();
        uFList = ufRepository.findAll().stream().filter(uf -> uf.getSigla().equals(ufString)).collect(Collectors.toList());
        return uFList.get(0);
    }

    public UF verifyIfIsNameOrAbbAndCallMethod(String ufString) {
        if (ufString.length()>2){
            return getUFByName(ufString);
        }else{
            return getUFByAbb(ufString);
        }

    }

    public Optional<UF> getById(Long idUF){
        return ufRepository.findById(idUF);
    }

    public UF updateUF(UF uf){
        return ufRepository.save(uf);
    }

    public MessageResponseDTO createUF(UF uf){
        UF savedUF = ufRepository.save(uf);
        return createMessageResponse(savedUF.getId(), "Created UF with ID: ");
    }
    private MessageResponseDTO createMessageResponse(Long id, String s) {
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
        messageResponseDTO.setMessage(s + id);
        return messageResponseDTO;
    }
}
