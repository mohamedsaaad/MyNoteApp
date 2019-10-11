package com.example.noteapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.noteapp.database.daos.NotesDao;
import com.example.noteapp.database.model.Note;

@Database(entities = {Note.class},version = 1,exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {
    private static MyDataBase  dataBase;
    public abstract NotesDao notesDao();
    private final static String DATABASE_NAME="notesdatabase";

    public static MyDataBase getInstance(Context context){
        if(dataBase==null){
            dataBase= Room.
                    databaseBuilder(context,MyDataBase.class,DATABASE_NAME).
                    fallbackToDestructiveMigration().
                    allowMainThreadQueries().build();
        }
        return dataBase;
    }
}

