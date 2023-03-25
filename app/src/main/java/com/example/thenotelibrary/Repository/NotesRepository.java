package com.example.thenotelibrary.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.thenotelibrary.Database.NotesDatabase;
import com.example.thenotelibrary.NotesDao.NotesDao;
import com.example.thenotelibrary.NotesEntity.Notes;

import java.util.List;

public class NotesRepository {

    public NotesDao notesDao;
    public LiveData<List<Notes>> getAllNotes;


    public NotesRepository(Application application){
        NotesDatabase database= NotesDatabase.getDatabaseInstance(application);
        notesDao= database.notesDao();

        getAllNotes=notesDao.getAllNotes();

    }

    public void insertNotes(Notes notes){

        notesDao.InsertNotes(notes);
    }

    public void DeleteNotes(int id){

        notesDao.DeleteNotes(id);
    }

    public void UpdateNotes(Notes notes){

        notesDao.UpdateNotes(notes);
    }
}