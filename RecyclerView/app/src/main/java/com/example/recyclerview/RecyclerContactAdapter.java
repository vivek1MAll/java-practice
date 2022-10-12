package com.example.recyclerview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    Context context;
ArrayList<ContactModel> arrContacts;
    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContacts){
       this.context=context;
       this.arrContacts=arrContacts;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.contact_card,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.img.setImageResource(arrContacts.get(position).img);
        holder.text1.setText(arrContacts.get(position).name);
        holder.text2.setText(arrContacts.get(position).number);

    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
TextView text2,text1;
ImageView img;
        public ViewHolder( View itemView) {
            super(itemView);
            text1=itemView.findViewById(R.id.text1);
            text2=itemView.findViewById(R.id.text2);
            img=itemView.findViewById(R.id.img);

        }
    }


}
