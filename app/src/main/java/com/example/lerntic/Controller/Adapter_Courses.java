package com.example.lerntic.Controller;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.R;
import com.example.lerntic.View.Course_detail;
import com.example.lerntic.View.OwnCourses;

import java.util.ArrayList;

public class Adapter_Courses extends RecyclerView.Adapter<Adapter_Courses.ViewHolderDatos> implements View.OnClickListener{

    ArrayList<String> DataList;
    private View.OnClickListener listener;
    user User;

    public Adapter_Courses(ArrayList<String> dataList, user User) {
        DataList = dataList;
        this.User = User;
    }

    @NonNull
    @Override
    public Adapter_Courses.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, null,false);
        view.setOnClickListener(this);
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

    public void SetOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{
        TextView name;
        //TextView description;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_name_course);
            //description = itemView.findViewById(R.id.txt_description_course);
        }
        public void asignarDatos(String names) {
            name.setText(names);
            //description.setText(names);
        }
    }
}
