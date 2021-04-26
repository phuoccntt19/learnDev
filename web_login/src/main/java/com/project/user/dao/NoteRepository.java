package com.project.user.dao;

import com.project.user.entity.TakeNotesEntity;
import com.project.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<TakeNotesEntity, Long> {
    List<TakeNotesEntity> findByUser(User user);
}
