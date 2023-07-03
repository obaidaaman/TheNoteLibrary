package com.example.thenotelibrary.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thenotelibrary.Activity.Adapter.NotesAdapter;
import com.example.thenotelibrary.NotesViewModel.NotesViewModel;
import com.example.thenotelibrary.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView notesRecycler;
    FloatingActionButton btnAddNotes;
    NotesViewModel notesViewModel;
    NotesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddNotes = findViewById(R.id.addNotesBtn);

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);

        notesRecycler = findViewById(R.id.notesRecycler);


        btnAddNotes.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), InsertNoteActivity.class)));


        notesViewModel.getAllNotes.observe(this, notes -> {

            notesRecycler.setLayoutManager(new GridLayoutManager(this, 2));

             adapter = new NotesAdapter(MainActivity.this, notes);

            notesRecycler.setAdapter(adapter);
        });
    }
}