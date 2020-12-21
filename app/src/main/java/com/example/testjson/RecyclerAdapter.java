package com.example.testjson;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    ArrayList<Data> arrayList = new ArrayList<>();


    public RecyclerAdapter (ArrayList<Data>arrayList){

        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder( view );

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.ID.setText( arrayList.get( position ).getID() );
        holder.Value.setText( arrayList.get( position ).getValue() );

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView ID,Value;

        public MyViewHolder(@NonNull View itemView) {
            super( itemView );

            ID = (TextView) itemView.findViewById(R.id.id);
            Value = (TextView) itemView.findViewById(R.id.value);
        }
    }
}
