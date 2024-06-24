package com.example.asl_project;

import com.example.asl_project.Model.AslModel;

import java.util.ArrayList;

public interface ASLRecyclerViewInterface {
//    void OnItemClick(AslModel aslModel,int pos);
    void OnItemClick(ArrayList<AslModel> aslModelArrayList, int pos);
    void OnRecyclerViewClick(int posClicked,int childPos);

}
