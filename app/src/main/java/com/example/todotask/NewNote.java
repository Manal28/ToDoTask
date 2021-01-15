package com.example.todotask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todotask.mydataBase.EntityClass;
import com.example.todotask.mydataBase.NewNoteViewModel;

import java.util.Date;

public class NewNote extends AppCompatActivity {

    EditText myNote ;
     public String note ,date ;
     private NewNoteViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        myNote= (EditText)findViewById(R.id.your_note);
        note=myNote.getText().toString().trim();
        date=getDate().trim();

        mViewModel= new ViewModelProvider (this).get(NewNoteViewModel.class);


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.note_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case (R.id.save):{
                saveData();
                Intent intent= new Intent(NewNote.this,MainActivity.class);
                startActivity(intent);}

                default:
                    return super.onOptionsItemSelected(item);

        }

    }

    public String  getDate (){

      Date mdate = new Date();
      date= mdate.toString();

      return date;

    }

    public void saveData(){

   mViewModel.insert(new EntityClass(note,date));
   finish();


    }
}
