package com.example.todotask.mydataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;


public class MainViewModelClass extends AndroidViewModel {

    private RepositoryClass mReposoitory;
    private LiveData<List<EntityClass>> allNotes;

    public MainViewModelClass(@NonNull Application application) {
        super(application);
        mReposoitory=new RepositoryClass(application);
        allNotes=mReposoitory.getAllNotes();

    }

    public void insert (EntityClass notes){

        mReposoitory.insert(notes);

    }

    public void delete (EntityClass notes){

        mReposoitory.delete(notes);

    }

    public void deleteAll (){

        mReposoitory.deleteAllNote();

    }

    public LiveData<List<EntityClass>> getAll(){

        return allNotes;

    }
    public void update(EntityClass notes){

        mReposoitory.update(notes);

    }

}
