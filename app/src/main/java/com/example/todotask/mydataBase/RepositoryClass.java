package com.example.todotask.mydataBase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;

import java.util.List;

public class RepositoryClass {

  private MyDao mDao ;
  private LiveData<List<EntityClass>> getAllNotes ;
  public RepositoryClass (Application app){

    NoteRoomDb db = NoteRoomDb.getInstance(app);
    mDao=db.noteDao();
    getAllNotes=mDao.getAllNotes();

  }


  //Insert

  public void insert (EntityClass entity){

    new InsertAsyncTask(mDao).execute(entity);

  }
  //delete
    public void delete(EntityClass entity){

    new DeleteAsyncTask(mDao).execute(entity);

  }
  //update
  public void update (EntityClass entity){

    new UpdateAsyncTask(mDao).execute(entity);
    }

    //deletallNotes
    public void deleteAllNote (){

    new DeleteAllAsyncTask(mDao).execute();

    }

    //getA;llNotes

    public LiveData<List<EntityClass>> getAllNotes (){

      return getAllNotes;
    }



    private static class InsertAsyncTask extends AsyncTask<EntityClass,Void,Void>{

    private MyDao noteDao;
    public InsertAsyncTask (MyDao noteDao){

      this.noteDao=noteDao;
    }

    @Override
    protected Void doInBackground(EntityClass... entityClasses) {

      noteDao.insert(entityClasses[0]);
      return null;
    }
  }
  private static class DeleteAsyncTask extends AsyncTask<EntityClass,Void,Void>{

    private MyDao noteDao;
    public DeleteAsyncTask (MyDao noteDao){

      this.noteDao=noteDao;
    }

    @Override
    protected Void doInBackground(EntityClass... entityClasses) {

      noteDao.delete(entityClasses[0]);
      return null;
    }
  }

  private static class UpdateAsyncTask extends AsyncTask<EntityClass,Void,Void>{

    private MyDao noteDao;
    public UpdateAsyncTask (MyDao noteDao){

      this.noteDao=noteDao;
    }

    @Override
    protected Void doInBackground(EntityClass... entityClasses) {

      noteDao.update(entityClasses[0]);
      return null;
    }
  }

  private static class DeleteAllAsyncTask extends AsyncTask<EntityClass,Void,Void>{

    private MyDao noteDao;
    public DeleteAllAsyncTask (MyDao noteDao){

      this.noteDao=noteDao;
    }

    @Override
    protected Void doInBackground(EntityClass... entityClasses) {

      noteDao.deleteAllNotes();
      return null;
    }
  }
}
