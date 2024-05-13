package com.example.asl_project.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asl_project.MainActivity2;
import com.example.asl_project.MainActivity3;
import com.example.asl_project.Model.AslModel;
import com.example.asl_project.R;

import java.util.ArrayList;

public class List_Adapter extends ArrayAdapter<ASL_RecyclerView_Adapter> {
    Context context;
    MainActivity3 mainActivity3;
    ArrayList<AslModel> aslModelArrayList;
    public List_Adapter(Context context1, ArrayList<ASL_RecyclerView_Adapter> recyclerView_adapters){
        super(context1, R.layout.activity_main3,recyclerView_adapters);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ASL_RecyclerView_Adapter adapters = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main3,parent,false);
        }
        RecyclerView recyclerView;
        recyclerView = convertView.findViewById(R.id.recyclerView_main_3);

        recyclerView.setAdapter(adapters);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        return super.getView(position, convertView, parent);
    }
}
