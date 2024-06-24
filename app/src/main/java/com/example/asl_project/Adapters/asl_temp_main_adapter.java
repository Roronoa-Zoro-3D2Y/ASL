package com.example.asl_project.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asl_project.ASLMainInterface;
import com.example.asl_project.ASLRecyclerViewInterface;
import com.example.asl_project.MainActivity2;
import com.example.asl_project.Model.AslModel;
import com.example.asl_project.Model.ChildRecyclerView;
import com.example.asl_project.R;

import java.util.ArrayList;

public class asl_temp_main_adapter extends RecyclerView.Adapter<asl_temp_main_adapter.MyViewHolder> {
    Context context;
    static Context context2;
    MainActivity2 mainActivity2;
    View view2;
    public static int childPosition;
    int positionRecyclerChildView;
    ArrayList<ASL_RecyclerView_Adapter> asl_recyclerView_adapters;
    ArrayList<ArrayList<AslModel>> searchedWordsList;
    static ArrayList<ASL_RecyclerView_Adapter> asl_recyclerView_adapters2;
    ArrayList<ChildRecyclerView> recyclerViewArrayList = new ArrayList<>();

    public final ASLRecyclerViewInterface aslRecyclerViewInterface;
//    public final ASLMainInterface aslMainInterface;

    public asl_temp_main_adapter(Context context, ArrayList<ArrayList<AslModel>> aslModelArrayList1,ASLRecyclerViewInterface aslRecyclerViewInterface) {
        this.context = context;
        this.context2 = context;
        this.searchedWordsList = aslModelArrayList1;
//        this.asl_recyclerView_adapters2 = aslModelArrayList1;
        this.aslRecyclerViewInterface= aslRecyclerViewInterface;

    }

    @NonNull
    @Override
    public asl_temp_main_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.simple_recycler_view,parent,false);
        view2 = inflater.inflate(R.layout.simple_recycler_view,parent,false);
        return new MyViewHolder(view,this.aslRecyclerViewInterface,this.searchedWordsList);
    }

    @Override
    public void onBindViewHolder(@NonNull asl_temp_main_adapter.MyViewHolder holder, int position) {
//        ASL_RecyclerView_Adapter adapter;
//        adapter = new ASL_RecyclerView_Adapter(this.context,searchedWordsList.get(position),aslRecyclerViewInterface);
        ASL_RecyclerView_Word_Adapter adapter;
        adapter = new ASL_RecyclerView_Word_Adapter(this.context,searchedWordsList.get(position),aslRecyclerViewInterface,position);
        holder.recyclerViewChild.setAdapter(adapter);
//        holder.recyclerViewChild.setAdapter(asl_recyclerView_adapters.get(position));
        holder.recyclerViewChild.setLayoutManager(new GridLayoutManager(context,2));
        if(position == 0)
            holder.separator.setVisibility(View.INVISIBLE);
        childPosition = holder.childPosition2;
    }

    @Override
    public int getItemCount() {
        return searchedWordsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        RecyclerView recyclerViewChild;
        View separator;
        RecyclerView.LayoutManager layoutManager;
        AppCompatButton buttonGetPos;
        int childPosition2;
        public MyViewHolder(View view){
            super(view);

        }
        public MyViewHolder(@NonNull View itemView, ASLRecyclerViewInterface aslRecyclerViewInterface,ArrayList<ArrayList<AslModel>> ListOfLists) {
            super(itemView);
            recyclerViewChild = itemView.findViewById(R.id.recyclerView_main_3);
            separator = itemView.findViewById(R.id.separator);
//            buttonGetPos = itemView.findViewById(R.id.getRecyclerViewPos);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(aslRecyclerViewInterface != null){
                        int pos = getLayoutPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            aslRecyclerViewInterface.OnItemClick(ListOfLists.get(pos),pos);
                            Log.d("Inside temp main adapter", " "+pos);
                        }
                    }
                }
            });

        }

        public int setChildRecyclerViewPos(){
            return childPosition2;
        }

    }
    public void setQueryRecyclerViews(ArrayList<ArrayList<AslModel>> aslModelArrayList1){
//        this.asl_recyclerView_adapters = aslModelArrayList1;
        this.searchedWordsList = aslModelArrayList1;
        this.notifyDataSetChanged();
    }

    public int sendMainAdapterPos(){
        MyViewHolder myViewHolder = new MyViewHolder(view2);
        return myViewHolder.setChildRecyclerViewPos();
    }

}
