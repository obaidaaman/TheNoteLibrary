package com.example.thenotelibrary.NotesViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.thenotelibrary.NotesEntity.Notes;
import com.example.thenotelibrary.Repository.NotesRepository;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {
    public NotesRepository repository;
    public LiveData<List<Notes>> getAllNotes;
    public NotesViewModel(@NonNull Application application) {
        super(application);
        repository= new NotesRepository(application);

        getAllNotes= repository.getAllNotes;
    }

    public   void insertNote(Notes notes){

        repository.insertNotes(notes);
    }
    public  void deleteNotes(int id){
        repository.DeleteNotes(id);
    }
    public  void updateNotes(Notes notes){
        repository.UpdateNotes(notes);
    }
}
