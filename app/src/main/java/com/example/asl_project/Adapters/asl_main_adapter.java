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
import com.example.asl_project.R;

import java.util.ArrayList;

public class asl_main_adapter extends RecyclerView.Adapter<asl_main_adapter.MyViewHolder> {
    Context context;
    static Context context2;
    MainActivity2 mainActivity2;
    View view2;
    public static int childPosition;
    int positionRecyclerChildView;
    ArrayList<ASL_RecyclerView_Adapter> asl_recyclerView_adapters;
     static ArrayList<ASL_RecyclerView_Adapter> asl_recyclerView_adapters2;

    public final ASLRecyclerViewInterface aslRecyclerViewInterface;
//    public final ASLMainInterface aslMainInterface;

    public asl_main_adapter(Context context, ArrayList<ASL_RecyclerView_Adapter> aslModelArrayList1,ASLRecyclerViewInterface aslRecyclerViewInterface) {
        this.context = context;
        this.context2 = context;
        this.asl_recyclerView_adapters = aslModelArrayList1;
        this.asl_recyclerView_adapters2 = aslModelArrayList1;
        this.aslRecyclerViewInterface= aslRecyclerViewInterface;
    }

    @NonNull
    @Override
    public asl_main_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_main3,parent,false);
        view2 = inflater.inflate(R.layout.activity_main3,parent,false);
        return new MyViewHolder(view,this.aslRecyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull asl_main_adapter.MyViewHolder holder, int position) {
        holder.recyclerViewChild.setAdapter(asl_recyclerView_adapters.get(position));
        holder.recyclerViewChild.setLayoutManager(new GridLayoutManager(context,2));
        if(position == 0)
            holder.separator.setVisibility(View.INVISIBLE);
        childPosition = holder.childPosition2;
    }

    @Override
    public int getItemCount() {
        return asl_recyclerView_adapters.size();
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
        public MyViewHolder(@NonNull View itemView, ASLRecyclerViewInterface aslRecyclerViewInterface) {
            super(itemView);
            recyclerViewChild = itemView.findViewById(R.id.recyclerView_main_3);
            separator = itemView.findViewById(R.id.separator);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("TAG22", getLayoutPosition()+" ");
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(aslRecyclerViewInterface != null) {
                        int pos = getAdapterPosition();
                         childPosition2 = getLayoutPosition();
                        if (pos != RecyclerView.NO_POSITION) {
                            aslRecyclerViewInterface.OnItemClick(asl_recyclerView_adapters2.get(pos).aslModelArrayList,pos);
//                              aslRecyclerViewInterface.OnRecyclerViewClick(pos);
                            Log.d("mainAdapter", " position "+pos);
//                            Toast.makeText(context2,"Posion"+pos,Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
/*            recyclerViewChild.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("mainAdapterMiracle", getLayoutPosition()+" ");
                }
            });
            buttonGetPos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    childPosition2 = getLayoutPosition();
//                    aslRecyclerViewInterface.OnItemClick(asl_recyclerView_adapters2.get(childPosition2).aslModelArrayList.get(childPosition2),childPosition2);
                    aslRecyclerViewInterface.OnRecyclerViewClick(childPosition2);

                    Log.d("mainAdapter2", ""+childPosition2);
                }
            });
//            childPosition2 = getLayoutPosition();*/
        }

        public int setChildRecyclerViewPos(){
            return childPosition2;
        }

    }
    public void setQueryRecyclerViews(ArrayList<ASL_RecyclerView_Adapter> aslModelArrayList1){
        this.asl_recyclerView_adapters = aslModelArrayList1;
        this.notifyDataSetChanged();
    }

    public int sendMainAdapterPos(){
        MyViewHolder myViewHolder = new MyViewHolder(view2);
        return myViewHolder.setChildRecyclerViewPos();
    }

}
