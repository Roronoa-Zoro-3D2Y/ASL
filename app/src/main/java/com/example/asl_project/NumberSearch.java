package com.example.asl_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asl_project.Adapters.ASL_RecyclerView_Adapter;
import com.example.asl_project.Adapters.List_Adapter;
import com.example.asl_project.Adapters.asl_main_adapter;
import com.example.asl_project.Model.AslModel;

import com.example.asl_project.data.ASLHandler;
import com.example.asl_project.databinding.ActivityMain2Binding;
import com.google.android.material.progressindicator.BaseProgressIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberSearch extends AppCompatActivity implements ASLRecyclerViewInterface,ASLMainInterface{
    MainActivity3 mainActivity3;
    ListView listView;
    ArrayList<AslModel> aslModelArrayListNumbers = new ArrayList<>();
    ArrayList<ASL_RecyclerView_Adapter> recyclerView_adapters = new ArrayList<>();

    asl_main_adapter asl_main_adapter;
    SearchView searchView;
    ImageView home;
    RecyclerView recyclerView;
    ArrayList<AslModel> aslModelArrayList = new ArrayList();
    ArrayList<AslModel> aslNumberArrayList = new ArrayList();
    ASL_RecyclerView_Adapter adapter1;
    ASL_RecyclerView_Adapter adapter2;
    ASL_RecyclerView_Adapter adapter3;
    ASLHandler db_num = new ASLHandler(NumberSearch.this);
    int[] resourceIDNumbers = new int[]{R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,
            R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,
            R.drawable.zero
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_search);

        recyclerView = findViewById(R.id.num_main_list);

        searchView = findViewById(R.id.num_searchView);
        searchView.clearFocus();
        home = findViewById(R.id.num_home_icon);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
//                Searching2(query,adapter1);
                numberSearch(query);
                return true;
            }

            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(NumberSearch.this, HomeScreen.class);
                startActivity(intent);
            }
        });

//        updateDataBase();
        adapter2 = new ASL_RecyclerView_Adapter(NumberSearch.this,getAslModelArrayListNumbers(),this);

        recyclerView_adapters.add(adapter2);

//        asl_main_adapter = new asl_main_adapter(NumberSearch.this,recyclerView_adapters,this);
        asl_main_adapter = new asl_main_adapter(NumberSearch.this,recyclerView_adapters,this);
        recyclerView.setAdapter(asl_main_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(NumberSearch.this));

    }


    public void Searching(String text,ASL_RecyclerView_Adapter recyclerViewAdapter) {
        ArrayList<AslModel> aslModelList = new ArrayList<>();

        for(AslModel i:aslModelArrayList) {
            if (i.getAslAlphabet().toLowerCase().contains(text.toLowerCase())) {
                aslModelList.add(i);
            }

            if (aslModelArrayList.isEmpty()) {
                Toast.makeText(NumberSearch.this, "Please Enter", Toast.LENGTH_SHORT).show();
            } else {
                recyclerViewAdapter.setFilteredList(aslModelList);
            }
        }

    }


    public ASL_RecyclerView_Adapter Searching2(String query) {
        ArrayList<AslModel> aslModelList = new ArrayList<>();
        ASL_RecyclerView_Adapter adapter = null;
        for(int j = 0; j < query.length();j++) {
            char letter = Character.toLowerCase(query.charAt(j));
            for(AslModel i: aslNumberArrayList) {
                char aslLetter = Character.toLowerCase(i.getAslAlphabet().charAt(0));
                if (aslLetter == letter) {
                    aslModelList.add(i);
                }

                if (aslNumberArrayList.isEmpty()) {
                    Toast.makeText(NumberSearch.this, "Please Enter", Toast.LENGTH_SHORT).show();
                } else {
                    adapter = new ASL_RecyclerView_Adapter(NumberSearch.this,aslModelList,this);
                }
            }
        }
        return adapter;
    }

    public ASL_RecyclerView_Adapter searchAndSetAdapter(String query) {
        ASL_RecyclerView_Adapter adapter = null;
        ArrayList<AslModel> aslModelList = new ArrayList<>();
//        ArrayList<AslModel> aslModelArrayList1 = getAslModelArrayListAlpha();
        for(int j=0;j<query.length();j++) {
            char letter = (query.charAt(j));
            for (AslModel i : aslModelArrayListNumbers) {
                char aslLetter = Character.toLowerCase(i.getAslAlphabet().charAt(0));
                if (letter == aslLetter) {
                    aslModelList.add(i);
//                    Toast.makeText(NumberSearch.this, " " + i.getAslAlphabet(), Toast.LENGTH_SHORT).show();
                }

                if (aslModelArrayListNumbers.isEmpty()) {
                    Toast.makeText(NumberSearch.this, "Please Enter", Toast.LENGTH_SHORT).show();
                } else {
                    adapter = new ASL_RecyclerView_Adapter(NumberSearch.this, aslModelList,this);
                }
            }
        }

        return adapter;
    }

    public void numberSearch(String query){
        ArrayList<AslModel> aslModels = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        ArrayList<ASL_RecyclerView_Adapter> adapterArrayList = new ArrayList<>();
        int countWords;
        if(query.contains(" ")) {
            words.addAll(Arrays.asList(query.split(" ")));

            /*for(int w=0;w<words.size();w++)
                Toast.makeText(NumberSearch.this," "+words.get(w),Toast.LENGTH_SHORT).show();*/

            for (int w = 0; w < words.size(); w++) {
                adapterArrayList.add(searchAndSetAdapter(words.get(w)));
            }
            asl_main_adapter.setQueryRecyclerViews(adapterArrayList);
        }
        else{
            Toast.makeText(NumberSearch.this," "+query,Toast.LENGTH_SHORT).show();
            ArrayList<ASL_RecyclerView_Adapter> adapterArrayList1 = new ArrayList<>();
            adapterArrayList1.add(Searching2(query));
            asl_main_adapter.setQueryRecyclerViews(adapterArrayList1);
        }
    }
    public void updateDataBase(){
//        db.deleteTABLE();

        AslModel one = new AslModel(1,resourceIDNumbers[0], "1");
        AslModel two = new AslModel(2,resourceIDNumbers[1], "2");
        AslModel three = new AslModel(3,resourceIDNumbers[2], "3");
        AslModel four = new AslModel(4,resourceIDNumbers[3], "4");
        AslModel five = new AslModel(5,resourceIDNumbers[4], "5");
        AslModel six = new AslModel(6,resourceIDNumbers[5], "6");
        AslModel seven = new AslModel(7,resourceIDNumbers[6], "7");
        AslModel eight = new AslModel(8,resourceIDNumbers[7], "8");
        AslModel nine = new AslModel(9,resourceIDNumbers[8], "9");
        AslModel zero = new AslModel(10,resourceIDNumbers[9], "0");

        db_num.addASL(zero);
        db_num.addASL(one);
        db_num.addASL(two);
        db_num.addASL(three);
        db_num.addASL(four);
        db_num.addASL(five);
        db_num.addASL(six);
        db_num.addASL(seven);
        db_num.addASL(eight);
        db_num.addASL(nine);
        
//        db_num.deleteTABLE();


        List<AslModel> aslModelList = db_num.getAllAslMap();
        aslNumberArrayList.addAll(aslModelList);

//        List<AslModel> aslWordsModelList = db_words.getAllAslMap();
//        aslWordsModelArrayList.addAll(aslWordsModelList);
    }

    public ArrayList<AslModel> getAslModelArrayListNumbers() {
        AslModel one = new AslModel(1,resourceIDNumbers[0], "1");
        AslModel two = new AslModel(2,resourceIDNumbers[1], "2");
        AslModel three = new AslModel(3,resourceIDNumbers[2], "3");
        AslModel four = new AslModel(4,resourceIDNumbers[3], "4");
        AslModel five = new AslModel(5,resourceIDNumbers[4], "5");
        AslModel six = new AslModel(6,resourceIDNumbers[5], "6");
        AslModel seven = new AslModel(7,resourceIDNumbers[6], "7");
        AslModel eight = new AslModel(8,resourceIDNumbers[7], "8");
        AslModel nine = new AslModel(9,resourceIDNumbers[8], "9");
        AslModel zero = new AslModel(10,resourceIDNumbers[9], "0");
        aslModelArrayListNumbers.add(one);
        aslModelArrayListNumbers.add(two);
        aslModelArrayListNumbers.add(three);
        aslModelArrayListNumbers.add(four);
        aslModelArrayListNumbers.add(five);
        aslModelArrayListNumbers.add(six);
        aslModelArrayListNumbers.add(seven);
        aslModelArrayListNumbers.add(eight);
        aslModelArrayListNumbers.add(nine);
        aslModelArrayListNumbers.add(zero);

        return aslModelArrayListNumbers;
    }




    @Override
    public void onRecyclerViewClick(ASL_RecyclerView_Adapter asl_recyclerView_adapters) {

    }

  /*  @Override
    public void OnItemClick(AslModel aslModel, int pos) {

    }*/

    @Override
    public void OnItemClick(ArrayList<AslModel> aslModelArrayList, int pos) {

    }

    @Override
    public void OnRecyclerViewClick(int pos) {

    }
}