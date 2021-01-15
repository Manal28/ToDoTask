package com.example.todotask.mydataBase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.todotask.MyAdapter;
import com.example.todotask.NewNote;

@Database(entities=EntityClass.class,version = 1,exportSchema = false)

public abstract class NoteRoomDb extends RoomDatabase {

    private static NoteRoomDb instance;

    public abstract MyDao noteDao();

    // Singlton(not to repeat more than one version from the same Db)
    public static synchronized NoteRoomDb getInstance(Context context) {

        if (instance == null) {

            instance = Room.databaseBuilder(context.getApplicationContext(), NoteRoomDb.class, "NOTE_DATABASE")
                    .addCallback(roomCallBack)
                    .fallbackToDestructiveMigration().build();

        }
        return instance;
    }
// callback roomDb

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDataAsyncTask(instance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }

    };

    private static class PopulateDataAsyncTask extends AsyncTask<Void,Void,Void>{

        private MyDao myNoteDao;

        PopulateDataAsyncTask(NoteRoomDb db){

            myNoteDao =db.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {


            myNoteDao.insert(new EntityClass("Note","Date"));

            return null;
        }
    }
}



