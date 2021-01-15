package com.example.todotask.mydataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    void insert (EntityClass note);
    @Delete
    void delete (EntityClass note);
    @Update
    void update (EntityClass note);

    @Query("DELETE From NotesTable")
    void deleteAllNotes();

    @Query("SELECT * From NotesTable")
    LiveData <List<EntityClass>> getAllNotes();


}
