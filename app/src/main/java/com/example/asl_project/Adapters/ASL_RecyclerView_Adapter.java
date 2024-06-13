package com.example.asl_project.Adapters;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asl_project.ASLRecyclerViewInterface;
import com.example.asl_project.MainActivity2;
import com.example.asl_project.Model.AslModel;
import com.example.asl_project.PhotoDescription;
import com.example.asl_project.R;

import java.util.ArrayList;

public class ASL_RecyclerView_Adapter extends RecyclerView.Adapter<ASL_RecyclerView_Adapter.MyViewHolder> {
    Context context;
    static Context context2;
     public ArrayList<AslModel> aslModelArrayList;
     static ArrayList<AslModel> aslModelArrayList2;
    String aslTextBeingSet;

    ArrayList<ArrayList<AslModel>> listOfAsls = new ArrayList<>();


    public final ASLRecyclerViewInterface aslRecyclerViewInterface;

    public ArrayList<AslModel> getAslModelArrayList() {
        return aslModelArrayList;
    }

    public ASL_RecyclerView_Adapter(Context context, ArrayList<AslModel> aslModelArrayList1, ASLRecyclerViewInterface aslRecyclerViewInterface) {
        this.context = context;
        this.context2 = context;
        this.aslModelArrayList = aslModelArrayList1;
        this.aslModelArrayList2 = aslModelArrayList1;
        this.aslRecyclerViewInterface = aslRecyclerViewInterface;
/*

        ArrayList<AslModel> aslModels = new ArrayList<>();
        aslModels.add(new AslModel(R.drawable.a,"a"));
        aslModels.add(new AslModel(R.drawable.b,"b"));
        listOfAsls.add(aslModels);

        ArrayList<AslModel> aslModels2 = new ArrayList<>();
        aslModels2.add(new AslModel(R.drawable.c,"c"));
        listOfAsls.add(aslModels2);
*/



    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(R.layout.asl_card_view, parent, false);
        return new MyViewHolder(view,this.aslRecyclerViewInterface,this.aslTextBeingSet);
    }


    public void onBindViewHolder(@NonNull ASL_RecyclerView_Adapter.MyViewHolder holder, int position) {
        holder.aslSign.setImageResource(((AslModel)this.aslModelArrayList.get(position)).getAslImage());
        holder.aslText.setText(((AslModel)this.aslModelArrayList.get(position)).getAslAlphabet());

        aslTextBeingSet = aslModelArrayList.get(position).getAslAlphabet();
    }

    public int getItemCount() {
        return this.aslModelArrayList.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView aslSign;
        TextView aslText;
        public MyViewHolder(@NonNull View itemView,ASLRecyclerViewInterface recyclerViewInterface,String aslTextClicked) {
            super(itemView);

            aslSign = itemView.findViewById(R.id.asl_img);
            aslText = itemView.findViewById(R.id.asl_text_img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int pos = getLayoutPosition();
                        if(pos != RecyclerView.NO_POSITION)
                            recyclerViewInterface.OnItemClick(aslModelArrayList2,pos);
                        Log.d("mainAdapter3", pos+" ");
                    }
                    /*AslModel aslModel;
                    aslModel = aslModelArrayList2.get(getAdapterPosition());
                    Intent intent = new Intent(context2, PhotoDescription.class);
                    intent.putExtra("ASL_ALPHABET", aslModel.getAslAlphabet());
                    intent.putExtra("ASL_IMAGE", aslModel.getId() + "");
                    context2.startActivity(intent);*/
                }
            });
        }

        @Override
        public void onClick(View view) {
//            int pos = getAdapterPosition();
//            AslModel temp = aslModelArrayList2.get(pos);
//            Intent intent = new Intent(context2, PhotoDescription.class);
//            intent.putExtra("ASL_ALPHABET",aslModelArrayList2.get(pos).getAslAlphabet());
//            intent.putExtra("ASL_IMAGE",aslModelArrayList2.get(pos).getId()+"");
////        intent.putExtra("ASL_ALPHABET",test);
//
//            context2.startActivity(intent);

        }
    }
    public void setFilteredList(ArrayList<AslModel> filteredList) {
        this.aslModelArrayList = filteredList;

        this.notifyDataSetChanged();
    }

    public void returnOrigialList(ArrayList<AslModel> filteredList) {
        this.aslModelArrayList = filteredList;
        this.notifyDataSetChanged();
    }
}
