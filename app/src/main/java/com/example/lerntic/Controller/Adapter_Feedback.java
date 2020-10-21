package com.example.lerntic.Controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lerntic.R;

import java.util.ArrayList;

public class Adapter_Feedback extends  RecyclerView.Adapter<Adapter_Feedback.ViewHolderDatos> {
    ArrayList<String> DataList;

    public Adapter_Feedback(ArrayList<String> dataList) {
        DataList = dataList;
    }

    @NonNull
    @Override
    public Adapter_Feedback.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feedback, null,false);
        return new Adapter_Feedback.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Feedback.ViewHolderDatos holder, int position) {
        holder.asignarDatos(DataList.get(position));
    }

    @Override
    public int getItemCount() {
        return DataList.size();
    }
    public class ViewHolderDatos extends RecyclerView.ViewHolder{

        TextView description;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.txt_description_feedback);
        }

        public void asignarDatos(String names) {
            description.setText(names);
        }
    }
}
