package com.example.thenotelibrary.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thenotelibrary.NotesEntity.Notes;
import com.example.thenotelibrary.NotesViewModel.NotesViewModel;
import com.example.thenotelibrary.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;

import java.text.DateFormat;
import java.util.Date;

public class UpdateNotesActivity extends AppCompatActivity {

    EditText title, subtitle, notes;
    FloatingActionButton btnUpdate;
    String stitle,ssubtitle,snotes;
    int sid;
    NotesViewModel notesViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_notes);

        notesViewModel= ViewModelProviders.of(this).get(NotesViewModel.class);



        title=findViewById(R.id.uptitle);
        subtitle=findViewById(R.id.upsubtitle);
        notes=findViewById(R.id.upnotes);
        btnUpdate=findViewById(R.id.btnUpdate);

        title.setText(stitle);
        subtitle.setText(ssubtitle);
        notes.setText(snotes);

        sid=getIntent().getIntExtra("id",0);
        stitle=getIntent().getStringExtra("title");
        ssubtitle=getIntent().getStringExtra("Subtitle");
        snotes=getIntent().getStringExtra("NotesData");


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title1= title.getText().toString();
                String subtitle1= subtitle.getText().toString();
                String notes1= notes.getText().toString();
            }
        });

        UpdateNotes(stitle,ssubtitle,snotes);


    }

    private void UpdateNotes(String  title, String subtitle, String  notes) {
        if (title.isEmpty()){
            Toast.makeText(this, "Title Cannot be emptl", Toast.LENGTH_SHORT).show();

            return;

        } else if (subtitle.isEmpty() && notes.isEmpty()) {
            Toast.makeText(this, "Note cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        Date date= new Date();
        CharSequence sequence= DateFormat.getDateInstance().format(date.getTime());


        Notes updateNote= new Notes();

        updateNote.id=sid;
        updateNote.NotesTitle=title;
        updateNote.NotesSubtitle=subtitle;
        updateNote.Notes=notes;
        updateNote.NotesDate=sequence.toString();
        notesViewModel.updateNotes(updateNote);


        Toast.makeText(this, "Notes Updated Successfully", Toast.LENGTH_SHORT).show();

        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.delete_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.delete){
            BottomSheetDialog bottomSheetDialog= new BottomSheetDialog(UpdateNotesActivity.this);
            View view= LayoutInflater.from(UpdateNotesActivity.this)
                    .inflate(R.layout.delete_bottom_sheet,(LinearLayout)findViewById(R.id.bottomSheet));

            TextView yes,no;
            yes=view.findViewById(R.id.deleteYes);
            no=view.findViewById(R.id.deleteNo);

            yes.setOnClickListener(v -> {
                notesViewModel.deleteNotes(sid);
                finish();
            });
            no.setOnClickListener(v -> {
                bottomSheetDialog.dismiss();
            });
            bottomSheetDialog.setContentView(view);
            bottomSheetDialog.show();
        }

        return true;
    }
}