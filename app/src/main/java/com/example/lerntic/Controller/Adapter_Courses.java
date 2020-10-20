package com.example.lerntic.Controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lerntic.R;

import java.util.ArrayList;

public class Adapter_Courses extends RecyclerView.Adapter<Adapter_Courses.ViewHolderDatos> {

    ArrayList<String> DataList;

    public Adapter_Courses(ArrayList<String> dataList) {
        DataList = dataList;
    }

    @NonNull
    @Override
    public Adapter_Courses.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Courses.ViewHolderDatos holder, int position) {
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

            name = itemView.findViewById(R.id.txt_name_course);
        }

        public void asignarDatos(String names) {
            name.setText(names);
        }
    }
}
