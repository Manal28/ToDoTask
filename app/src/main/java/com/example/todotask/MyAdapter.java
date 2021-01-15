package com.example.todotask;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todotask.mydataBase.EntityClass;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolderAdapter>{

    public ArrayList<EntityClass> notes = new ArrayList() ;
    Context context;

    public MyAdapter(Context context){
        this.context=context;

    }

    public MyAdapter(){

    }

    @NonNull
    @Override
    public ViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.card,null,false)) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapter holder, int position) {

        if (notes != null) {
            EntityClass note = notes.get(position);
            holder.card_name.setText(note.get_NOTE());
            holder.date.setText(note.get_DATE());
        }

        else {

            holder.card_name.setText("No Notes");
        }
    }
    @Override
    public int getItemCount() {
        return  notes.size();
    }


    public class ViewHolderAdapter extends RecyclerView.ViewHolder {

        TextView card_name;
        TextView date;
        ImageView delete,edit;

        public ViewHolderAdapter(@NonNull View itemView) {

            super(itemView);
            card_name = itemView.findViewById(R.id.card_name);
            date = itemView.findViewById(R.id.card_date);
            delete=itemView.findViewById(R.id.card_del);
            edit=itemView.findViewById(R.id.card_edt);

        }

        public void setListeners (View v){

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context,NewNote.class);

                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });
        }

    }

    public  void setNotes (ArrayList<EntityClass> mnotes){

       notes=mnotes;
       notifyDataSetChanged();

    }
    }
