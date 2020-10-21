package com.example.lerntic.Controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lerntic.R;

import java.util.ArrayList;

public class Adapter_temario extends  RecyclerView.Adapter<Adapter_temario.ViewHolderDatos>{
    ArrayList<String> DataList;

    public Adapter_temario(ArrayList<String> dataList) {
        DataList = dataList;
    }

    @NonNull
    @Override
    public Adapter_temario.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_temario, null,false);
        return new Adapter_temario.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_temario.ViewHolderDatos holder, int position) {
        holder.asignarDatos(DataList.get(position));
    }

    @Override
    public int getItemCount() {
        return DataList.size();
    }
    public class ViewHolderDatos extends RecyclerView.ViewHolder{

        TextView name;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txt_name_temario);
        }

        public void asignarDatos(String names) {
            name.setText(names);
        }
    }
}
