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

public class WordSearch extends AppCompatActivity implements ASLRecyclerViewInterface,ASLMainInterface {
    MainActivity3 mainActivity3;
    ListView listView;
    ArrayList<AslModel> aslModelArrayListAlpha = new ArrayList<>();
    ArrayList<AslModel> aslModelArrayListNumbers = new ArrayList<>();
    ArrayList<AslModel> aslModelArrayListWords = new ArrayList<>();
    ArrayList<ASL_RecyclerView_Adapter> recyclerView_adapters = new ArrayList<>();

    asl_main_adapter asl_main_adapter;
    SearchView searchView;
    ImageView home;
    RecyclerView recyclerView;
    ArrayList<AslModel> aslModelArrayList = new ArrayList();
    ArrayList<AslModel> aslWordsModelArrayList = new ArrayList();
    ASL_RecyclerView_Adapter adapter1;
    ASL_RecyclerView_Adapter adapter2;
    ASL_RecyclerView_Adapter adapter3;
    ASLHandler db_word = new ASLHandler(WordSearch.this);
    int[] resourceIDWords = new int[]{R.drawable.asl_bored,R.drawable.asl_goodbye,R.drawable.asl_hello,
            R.drawable.asl_help,R.drawable.asl_please,R.drawable.asl_sad,R.drawable.asl_sorry,
            R.drawable.asl_stop,R.drawable.asl_thanks,R.drawable.asl_when,R.drawable.asl_where,
            R.drawable.asl_which,R.drawable.asl_you_are_welcome
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_search);

        recyclerView = findViewById(R.id.word_main_list);

        searchView = findViewById(R.id.word_searchView);
        searchView.clearFocus();
        home = findViewById(R.id.word_home_icon);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
//                Searching2(query,adapter1);
                wordSearch(query);
                return true;
            }

            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(WordSearch.this, HomeScreen.class);
                startActivity(intent);
            }
        });

//        updateDataBase();
        adapter3 = new ASL_RecyclerView_Adapter(WordSearch.this,getAslModelArrayListWords(),this);

        recyclerView_adapters.add(adapter3);

        asl_main_adapter = new asl_main_adapter(WordSearch.this,recyclerView_adapters,this);
//        asl_main_adapter = new asl_main_adapter(WordSearch.this,recyclerView_adapters,this);
        recyclerView.setAdapter(asl_main_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(WordSearch.this));

    }


    public void Searching(String text,ASL_RecyclerView_Adapter recyclerViewAdapter) {
        ArrayList<AslModel> aslModelList = new ArrayList<>();

        for(AslModel i:aslModelArrayList) {
            if (i.getAslAlphabet().toLowerCase().contains(text.toLowerCase())) {
                aslModelList.add(i);
            }

            if (aslModelArrayList.isEmpty()) {
                Toast.makeText(WordSearch.this, "Please Enter", Toast.LENGTH_SHORT).show();
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
            for(AslModel i: aslWordsModelArrayList) {
                char aslLetter = Character.toLowerCase(i.getAslAlphabet().charAt(0));
                if (aslLetter == letter) {
                    aslModelList.add(i);
                }

                if (aslWordsModelArrayList.isEmpty()) {
                    Toast.makeText(WordSearch.this, "Please Enter", Toast.LENGTH_SHORT).show();
                } else {
                    adapter = new ASL_RecyclerView_Adapter(WordSearch.this,aslModelList,this);
                }
            }
        }
        return adapter;
    }

    public ASL_RecyclerView_Adapter searchAndSetAdapter(String query) {
        ASL_RecyclerView_Adapter adapter = null;
        ArrayList<AslModel> aslModelList = new ArrayList<>();
//        ArrayList<AslModel> aslModelArrayList1 = getAslModelArrayListAlpha();
            for(AslModel i: aslModelArrayListWords) {
//                char aslLetter = Character.toLowerCase(i.getAslAlphabet().charAt(0));
                if (i.getAslAlphabet().equalsIgnoreCase(query)) {
                    aslModelList.add(i);
                    Toast.makeText(WordSearch.this," "+i.getAslAlphabet(),Toast.LENGTH_SHORT).show();
                }

                if (aslModelArrayListWords.isEmpty()) {
                    Toast.makeText(WordSearch.this, "Please Enter", Toast.LENGTH_SHORT).show();
                } else {
                    adapter = new ASL_RecyclerView_Adapter(WordSearch.this,aslModelList,this);
                }
            }

        return adapter;
    }

    public void wordSearch(String query){
        ArrayList<AslModel> aslModels = new ArrayList<>();
        ArrayList<String> words = new ArrayList<String>();
            ArrayList<ASL_RecyclerView_Adapter> adapterArrayList1 = new ArrayList<>();
            adapterArrayList1.add(searchAndSetAdapter(query));
            asl_main_adapter.setQueryRecyclerViews(adapterArrayList1);
    }
    public void updateDataBase(){
//        db.deleteTABLE();

        AslModel bored = new AslModel(1, WordSearch.this.resourceIDWords[0], "BORED");
        AslModel goodbye = new AslModel(2, WordSearch.this.resourceIDWords[1], "GOODBYE");
        AslModel hello = new AslModel(3, WordSearch.this.resourceIDWords[2], "HELLO");
        AslModel help = new AslModel(4, WordSearch.this.resourceIDWords[3], "HELP");
        AslModel please = new AslModel(5, WordSearch.this.resourceIDWords[4], "PLEASE");
        AslModel sad = new AslModel(6, WordSearch.this.resourceIDWords[5], "SAD");
        AslModel sorry = new AslModel(7, WordSearch.this.resourceIDWords[6], "SORRY");
        AslModel stop = new AslModel(8, WordSearch.this.resourceIDWords[7], "STOP");
        AslModel thanks = new AslModel(9, WordSearch.this.resourceIDWords[8], "THANKS");
        AslModel when = new AslModel(10, WordSearch.this.resourceIDWords[9], "WHEN");
        AslModel where = new AslModel(11, WordSearch.this.resourceIDWords[10], "WHERE");
        AslModel which = new AslModel(12, WordSearch.this.resourceIDWords[11], "WHICH");
        AslModel welcome = new AslModel(13, WordSearch.this.resourceIDWords[12], "You Are Welcome/WELCOME");

        db_word.addASL(bored);
        db_word.addASL(goodbye);
        db_word.addASL(hello);
        db_word.addASL(help);
        db_word.addASL(please);
        db_word.addASL(sad);
        db_word.addASL(sorry);
        db_word.addASL(stop);
        db_word.addASL(thanks);
        db_word.addASL(when);
        db_word.addASL(where);
        db_word.addASL(which);
        db_word.addASL(welcome);

        List<AslModel> aslModelList = db_word.getAllAslMap();
        aslWordsModelArrayList.addAll(aslModelList);

//        List<AslModel> aslWordsModelList = db_words.getAllAslMap();
//        aslWordsModelArrayList.addAll(aslWordsModelList);
    }

    public ArrayList<AslModel> getAslModelArrayListWords() {

        aslModelArrayListWords.add(new AslModel(1, resourceIDWords[0], "BORED"));
        aslModelArrayListWords.add(new AslModel(2, resourceIDWords[1], "GOODBYE"));
        aslModelArrayListWords.add(new AslModel(3, resourceIDWords[2], "HELLO"));
        aslModelArrayListWords.add(new AslModel(4, resourceIDWords[3], "HELP"));
        aslModelArrayListWords.add(new AslModel(5, resourceIDWords[4], "PLEASE"));
        aslModelArrayListWords.add(new  AslModel(6,resourceIDWords[5], "SAD"));
        aslModelArrayListWords.add(new AslModel(7, resourceIDWords[6], "SORRY"));
        aslModelArrayListWords.add(new AslModel(8, resourceIDWords[7], "STOP"));
        aslModelArrayListWords.add(new AslModel(9, resourceIDWords[8], "THANKS"));
        aslModelArrayListWords.add(new AslModel(10,resourceIDWords[9], "WHEN"));
        aslModelArrayListWords.add(new AslModel(11,resourceIDWords[10], "WHERE"));
        aslModelArrayListWords.add(new AslModel(12,resourceIDWords[11], "WHICH"));
        aslModelArrayListWords.add(new AslModel(13,resourceIDWords[12], "You Are Welcome/WELCOME"));

        return aslModelArrayListWords;
    }



    @Override
    public void onRecyclerViewClick(ASL_RecyclerView_Adapter asl_recyclerView_adapters) {

    }

    /*@Override
    public void OnItemClick(AslModel aslModel, int pos) {

    }*/

    @Override
    public void OnItemClick(ArrayList<AslModel> aslModelArrayList, int pos) {

    }

    @Override
    public void OnRecyclerViewClick(int pos) {

    }
}