package com.example.todotask.mydataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NewNoteViewModel extends AndroidViewModel {

    private RepositoryClass mReposoitory;


    public NewNoteViewModel(@NonNull Application application) {
        super(application);
        mReposoitory = new RepositoryClass(application);


    }

    public void insert(EntityClass notes) {

        mReposoitory.insert(notes);

    }

    public void delete(EntityClass notes) {

        mReposoitory.delete(notes);

    }


    public void update(EntityClass notes) {

        mReposoitory.update(notes);

    }
}