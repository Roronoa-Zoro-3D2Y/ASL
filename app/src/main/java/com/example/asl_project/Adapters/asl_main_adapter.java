package com.example.asl_project.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asl_project.Model.AslModel;
import com.example.asl_project.R;

import java.util.ArrayList;

public class asl_main_adapter extends RecyclerView.Adapter<asl_main_adapter.MyViewHolder> {
    Context context;
    ArrayList<ASL_RecyclerView_Adapter> asl_recyclerView_adapters;

    public asl_main_adapter(Context context, ArrayList<ASL_RecyclerView_Adapter> aslModelArrayList1) {
        this.context = context;
        this.asl_recyclerView_adapters = aslModelArrayList1;
    }

    @NonNull
    @Override
    public asl_main_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_main3,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull asl_main_adapter.MyViewHolder holder, int position) {
        holder.recyclerViewChild.setAdapter(asl_recyclerView_adapters.get(position));
        holder.recyclerViewChild.setLayoutManager(new GridLayoutManager(context,2));
        if(position == 0)
            holder.separator.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return asl_recyclerView_adapters.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerViewChild;
        View separator;
        RecyclerView.LayoutManager layoutManager;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerViewChild = itemView.findViewById(R.id.recyclerView_main_3);
            separator = itemView.findViewById(R.id.separator);
        }
    }
}
