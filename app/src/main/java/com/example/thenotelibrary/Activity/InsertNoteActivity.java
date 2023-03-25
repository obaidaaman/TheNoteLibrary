package com.example.thenotelibrary.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Database;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.thenotelibrary.NotesEntity.Notes;
import com.example.thenotelibrary.NotesViewModel.NotesViewModel;
import com.example.thenotelibrary.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.util.Date;

public class InsertNoteActivity extends AppCompatActivity {

    public String title1, subtitle1, notes1;
    NotesViewModel notesViewModel;

    FloatingActionButton btnCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_note);

        notesViewModel= ViewModelProviders.of(this).get(NotesViewModel.class);

        ImageView imageBack= findViewById(R.id.imageBack);
        imageBack.setOnClickListener(v -> onBackPressed());

        EditText title = findViewById(R.id.title);
        EditText subtitle = findViewById(R.id.subtitle);
        EditText notes = findViewById(R.id.notes);
        btnCreate=findViewById(R.id.btnCreate);



        title1= title.getText().toString();

        subtitle1= subtitle.getText().toString();

        notes1= notes.getText().toString();


        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNotes(title1,subtitle1,notes1);
            }
        });





    }

    private void saveNotes(String title,String subtitle, String  notes){
        if (title.isEmpty()){
            Toast.makeText(this, "Title Cannot be emptl", Toast.LENGTH_SHORT).show();

            return;

        } else if (subtitle.isEmpty() && notes.isEmpty()) {
            Toast.makeText(this, "Note cannot be empty", Toast.LENGTH_SHORT).show();
        return;
        }

        Date date= new Date();
        CharSequence sequence= DateFormat.getDateInstance().format(date.getTime());
        Notes note= new Notes();

        note.NotesTitle=title;
        note.NotesSubtitle=subtitle;
        note.Notes=notes;
        note.NotesDate=sequence.toString();

        notesViewModel.insertNote(note);

        Toast.makeText(this, "Notes Created", Toast.LENGTH_SHORT).show();

finish();
    }
}