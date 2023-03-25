package com.example.thenotelibrary.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.thenotelibrary.NotesDao.NotesDao;
import com.example.thenotelibrary.NotesEntity.Notes;

@Database(entities = {Notes.class},exportSchema = false,version = 1)
public abstract class NotesDatabase extends RoomDatabase {

    //call the Dao interface class by abstract
    public abstract NotesDao notesDao();

    //this variable is instance
    public static NotesDatabase INSTANCE;

    //to check if instance is created or not if not we should create the instance by calling the room database and context .
    //It asks for Database where the instance is to be created and name of the database which is given in the entity.
    public static NotesDatabase getDatabaseInstance(Context context){

        if (INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),NotesDatabase.class,"Notes_Database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }

        return  INSTANCE;
    }

}