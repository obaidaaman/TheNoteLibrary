package com.example.thenotelibrary.NotesDao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.thenotelibrary.NotesEntity.Notes;

import java.util.List;


@Dao
public interface NotesDao {


    @Query(" SELECT * FROM notesDatabase  ")
    LiveData<List<Notes>> getAllNotes();


    @Insert
    void  InsertNotes(Notes notes);

    @Query("DELETE FROM notesDatabase WHERE id=:id")
    void DeleteNotes(int id);

    @Update
    void UpdateNotes(Notes notes);


}

