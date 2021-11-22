package com.hdsgp.webshowplantemplate.services;

import com.hdsgp.webshowplantemplate.exceptions.TipoServicoNotFoundException;
import com.hdsgp.webshowplantemplate.model.MessageResponseDTO;
import com.hdsgp.webshowplantemplate.model.TipoServico;
import com.hdsgp.webshowplantemplate.repository.TipoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoServicoService {

    TipoServicoRepository tipoServicoRepository;

    @Autowired
    public TipoServicoService(TipoServicoRepository tipoServicoRepository){
        this.tipoServicoRepository = tipoServicoRepository;
    }

    public MessageResponseDTO createTipoServico(TipoServico tipoServico){
        TipoServico savedTipoServico = tipoServicoRepository.save(tipoServico);
        return createMessageResponse(savedTipoServico.getId(), "Created tipoServico with ID: ");
    }
    public MessageResponseDTO updateById(Long id, TipoServico tipoServico) throws TipoServicoNotFoundException{
        verifyIfExists(id);

        TipoServico savedTipoServico = tipoServicoRepository.save(tipoServico);
        return createMessageResponse(savedTipoServico.getId(), "Updated tipoServico with ID: ");
    }

    public TipoServico findById(Long id)throws TipoServicoNotFoundException{
        return verifyIfExists(id);
    }

    public List<TipoServico> findall(){

        return tipoServicoRepository.findAll();
    }

    public void delete(Long id) throws TipoServicoNotFoundException{
        verifyIfExists(id);
        tipoServicoRepository.deleteById(id);
    }


    private MessageResponseDTO createMessageResponse(Long id, String s) {
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
        messageResponseDTO.setMessage(s + id);
        return messageResponseDTO;
    }

    private TipoServico verifyIfExists(Long id) throws  TipoServicoNotFoundException {
        return tipoServicoRepository.findById(id).orElseThrow(()-> new TipoServicoNotFoundException(id));
    }
}
