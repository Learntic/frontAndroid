package com.example.lerntic.Controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lerntic.Model.Objects.People;
import com.example.lerntic.Model.Objects.friend;
import com.example.lerntic.R;

import java.util.ArrayList;

public class Adapter_people extends  RecyclerView.Adapter<Adapter_people.ViewHolderDatos> implements View.OnClickListener{
    ArrayList<People> DataList;
    private View.OnClickListener listener;

    public Adapter_people(ArrayList<People> dataList) {
        DataList = dataList;
    }

    @NonNull
    @Override
    public Adapter_people.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_people, null,false);
        view.setOnClickListener(this);
        return new Adapter_people.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_people.ViewHolderDatos holder, int position) {
        holder.asignarDatos(DataList.get(position));
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    @Override
    public int getItemCount() {
        return DataList.size();
    }
    public class ViewHolderDatos extends RecyclerView.ViewHolder{

        TextView name;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txt_name_friend);
        }

        public void asignarDatos(People people) {
            name.setText(people.getFullname());
        }
    }
}
