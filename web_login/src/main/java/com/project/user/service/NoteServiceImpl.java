package com.project.user.service;

import com.project.user.dao.NoteRepository;
import com.project.user.entity.TakeNotesEntity;
import com.project.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;


    @Override
    public TakeNotesEntity postNote(TakeNotesEntity takeNotesEntity, User user) {
        takeNotesEntity.setDateCreate(LocalDateTime.now());
        takeNotesEntity.setUser(user);
        noteRepository.save(takeNotesEntity);
        return takeNotesEntity;
    }
}
