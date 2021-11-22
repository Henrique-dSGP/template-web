package com.hdsgp.webshowplantemplate.services;

import com.hdsgp.webshowplantemplate.exceptions.ServicoNotFoundException;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.model.Servico;
import com.hdsgp.webshowplantemplate.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    ServicoRepository servicoRepository;

    @Autowired
    public ServicoService(ServicoRepository servicoRepository){
        this.servicoRepository = servicoRepository;
    }

    public MessageResponseDTO createServico(Servico servico){
        Servico savedServico = servicoRepository.save(servico);
        return createMessageResponse(savedServico.getId(), "Created servico with ID: ");
    }
    public MessageResponseDTO updateById(Long id, Servico servico) throws ServicoNotFoundException{
        verifyIfExists(id);

        Servico savedServico = servicoRepository.save(servico);
        return createMessageResponse(savedServico.getId(), "Updated servico with ID: ");
    }

    public Servico findById(Long id)throws ServicoNotFoundException{
        return verifyIfExists(id);
    }

    public List<Servico> findall(){

        return servicoRepository.findAll();
    }

    public void delete(Long id) throws ServicoNotFoundException{
        verifyIfExists(id);
        servicoRepository.deleteById(id);
    }


    private MessageResponseDTO createMessageResponse(Long id, String s) {
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
        messageResponseDTO.setMessage(s + id);
        return messageResponseDTO;
    }

    private Servico verifyIfExists(Long id) throws  ServicoNotFoundException {
        return servicoRepository.findById(id).orElseThrow(()-> new ServicoNotFoundException(id));
    }
}
