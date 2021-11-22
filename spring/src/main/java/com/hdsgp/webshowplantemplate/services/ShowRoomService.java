package com.hdsgp.webshowplantemplate.services;

import com.hdsgp.webshowplantemplate.repository.DisponibilidadeRepository;
import com.hdsgp.webshowplantemplate.repository.LocalRepository;
import com.hdsgp.webshowplantemplate.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowRoomService {

    PlanoRepository planoRepository;
    LocalRepository localRepository;
    DisponibilidadeRepository disponibilidadeRepository;

    @Autowired
    public ShowRoomService(PlanoRepository planoRepository,
                           LocalRepository localRepository,
                           DisponibilidadeRepository disponibilidadeRepository){
        this.planoRepository = planoRepository;
        this.localRepository = localRepository;
        this.disponibilidadeRepository = disponibilidadeRepository;
    }
}
