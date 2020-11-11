package com.example.lerntic.Controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lerntic.R;

import java.util.ArrayList;

public class Adapter_AllActivities extends RecyclerView.Adapter<Adapter_AllActivities.ViewHolderDatos> implements View.OnClickListener{
    ArrayList<String> DataList;
    private View.OnClickListener listener;

    public Adapter_AllActivities(ArrayList<String> dataList) {
        DataList = dataList;
    }

    @NonNull
    @Override
    public Adapter_AllActivities.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, null,false);
        return new Adapter_AllActivities.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_AllActivities.ViewHolderDatos holder, int position) {
        holder.asignarDatos(DataList.get(position));
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
