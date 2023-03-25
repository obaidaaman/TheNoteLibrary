package com.example.thenotelibrary.NotesEntity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notesDatabase")
public class Notes {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "notes_Title")
    public    String NotesTitle;

    @ColumnInfo(name = "notes_SubTitle")
    public   String NotesSubtitle;

    @ColumnInfo(name = "notes_Dates")
    public   String NotesDate;

    @ColumnInfo(name = "notes")
    public   String Notes;

    @ColumnInfo(name = "notes_Priority")
    public   String NotesPriority;



}
