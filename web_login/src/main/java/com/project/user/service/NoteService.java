package com.project.user.service;

import com.project.user.entity.TakeNotesEntity;
import com.project.user.entity.User;

public interface NoteService {

    TakeNotesEntity postNote(TakeNotesEntity takeNotesEntity, User user);
}
