package com.example.lerntic.Controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lerntic.Model.Objects.feedback;
import com.example.lerntic.R;

import java.util.ArrayList;

public class Adapter_Feedback extends  RecyclerView.Adapter<Adapter_Feedback.ViewHolderDatos> {
    ArrayList<feedback> DataList;

    public Adapter_Feedback(ArrayList<feedback> dataList) {
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
        TextView score;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.txt_description_feedback);
            score = itemView.findViewById(R.id.txt_feedback_number);
        }

        public void asignarDatos(feedback feedback) {
            description.setText(feedback.getOpinion());
            score.setText(String.valueOf(feedback.getNota()));
        }
    }
}
