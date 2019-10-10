package com.example.noteapp.database.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.noteapp.database.model.Note;

import java.util.List;

@Dao
public interface NotesDao {
    @Insert
    void addNote(Note note);
    @Delete
    void DeleteNote(Note note);
    @Update
    Void update(Note note);
    @Query("select * from Note")
    List<Note> getAllNote();

    @Query("select * from Note where id=:id")
    Note searchById(int id);
}
