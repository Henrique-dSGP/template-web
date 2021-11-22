package com.hdsgp.webshowplantemplate.services;

import com.hdsgp.webshowplantemplate.exceptions.CidadeNotFoundException;
import com.hdsgp.webshowplantemplate.exceptions.LocalNotFoundException;
import com.hdsgp.webshowplantemplate.model.Cidade;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.model.Local;
import com.hdsgp.webshowplantemplate.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalService {

    LocalRepository localRepository;

    @Autowired
    public LocalService(LocalRepository localRepository){
        this.localRepository = localRepository;
    }

    public MessageResponseDTO createLocal(Local local){
        Local savedLocal = localRepository.save(local);
        return createMessageResponse(savedLocal.getId(), "Created local with ID: ");
    }

    public Local findById(Long id)throws LocalNotFoundException{
        return verifyIfExists(id);
    }
    public MessageResponseDTO updateById(Long id, Local local) throws LocalNotFoundException {
        verifyIfExists(id);

        Local savedLocal = localRepository.save(local);
        return createMessageResponse(savedLocal.getId(), "Updated local with ID: ");
    }

    public Local findByCity(String cidadeString){
        List<Local> localList = new ArrayList<>();
        localList = localRepository.findAll().stream().filter(local -> local.getCidade().getNome().equals(cidadeString)).collect(Collectors.toList());
        return localList.get(0);
    }

    public List<Local> findall(){

        return localRepository.findAll();
    }

    public void delete(Long id) throws LocalNotFoundException{
        verifyIfExists(id);
        localRepository.deleteById(id);
    }


    private MessageResponseDTO createMessageResponse(Long id, String s) {
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
        messageResponseDTO.setMessage(s + id);
        return messageResponseDTO;
    }

    private Local verifyIfExists(Long id) throws  LocalNotFoundException {
        return localRepository.findById(id).orElseThrow(()-> new LocalNotFoundException(id));
    }
}
