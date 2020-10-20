package com.example.lerntic.Controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lerntic.R;

import java.util.ArrayList;

public class Adapter_achievements  extends RecyclerView.Adapter<Adapter_achievements.ViewHolderDatos> {
    ArrayList<String> DataList;

    public Adapter_achievements(ArrayList<String> dataList) {
        DataList = dataList;
    }

    @NonNull
    @Override
    public Adapter_achievements.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_achaivements, null,false);
        return new Adapter_achievements.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_achievements.ViewHolderDatos holder, int position) {
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

            name = itemView.findViewById(R.id.txt_name_achievements);
        }

        public void asignarDatos(String names) {
            name.setText(names);
        }
    }
}
