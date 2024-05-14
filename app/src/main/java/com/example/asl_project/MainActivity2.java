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

public class MainActivity2 extends AppCompatActivity {
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
    ASLHandler db = new ASLHandler(this);
    ASLHandler db_words = new ASLHandler(this);
    int[] resourceID = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
            R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,
            R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o,
            R.drawable.p,R.drawable.q,R.drawable.r,R.drawable.s,R.drawable.t,
            R.drawable.u,R.drawable.v,R.drawable.w,R.drawable.x,R.drawable.y,
            R.drawable.z,R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,
            R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,
            R.drawable.zero
    };
    int[] resourceIDWords = new int[]{R.drawable.asl_bored,R.drawable.asl_goodbye,R.drawable.asl_hello,
            R.drawable.asl_help,R.drawable.asl_please,R.drawable.asl_sad,R.drawable.asl_sorry,
            R.drawable.asl_stop,R.drawable.asl_thanks,R.drawable.asl_when,R.drawable.asl_where,
            R.drawable.asl_which,R.drawable.asl_you_are_welcome
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.main_list);

        searchView = (SearchView)this.findViewById(R.id.searchView);
        searchView.clearFocus();
        home = findViewById(R.id.home_icon);
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
                Intent intent = new Intent(MainActivity2.this, HomeScreen.class);
                startActivity(intent);
            }
        });

        updateDataBase();
        adapter1 = new ASL_RecyclerView_Adapter(MainActivity2.this,getAslModelArrayListAlpha());
        adapter2 = new ASL_RecyclerView_Adapter(MainActivity2.this,getAslModelArrayListNumbers());
//        adapter3 = new ASL_RecyclerView_Adapter(MainActivity2.this,getAslModelArrayListWords());

        recyclerView_adapters.add(adapter1);
        recyclerView_adapters.add(adapter2);
//        recyclerView_adapters.add(adapter3);

        asl_main_adapter = new asl_main_adapter(MainActivity2.this,recyclerView_adapters);
        recyclerView.setAdapter(asl_main_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    public ArrayList<AslModel> getAslModelArrayListNumbers() {
        AslModel one = new AslModel(27, this.resourceID[26], "1");
        AslModel two = new AslModel(28, this.resourceID[27], "2");
        AslModel three = new AslModel(29, this.resourceID[28], "3");
        AslModel four = new AslModel(30, this.resourceID[29], "4");
        AslModel five = new AslModel(31, this.resourceID[30], "5");
        AslModel six = new AslModel(32, this.resourceID[31], "6");
        AslModel seven = new AslModel(33, this.resourceID[32], "7");
        AslModel eight = new AslModel(34, this.resourceID[33], "8");
        AslModel nine = new AslModel(35, this.resourceID[34], "9");
        AslModel zero = new AslModel(36, this.resourceID[35], "0");
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

    public ArrayList<AslModel> getAslModelArrayListAlpha() {
        aslModelArrayListAlpha.add( new AslModel(1, this.resourceID[0], "A"));
        aslModelArrayListAlpha.add( new AslModel(2, this.resourceID[1], "B"));
        aslModelArrayListAlpha.add( new AslModel(3, this.resourceID[2], "C"));
        aslModelArrayListAlpha.add( new AslModel(4, this.resourceID[3], "D"));
        aslModelArrayListAlpha.add( new AslModel(5, this.resourceID[4], "E"));
        aslModelArrayListAlpha.add( new AslModel(6, this.resourceID[5], "F"));
        aslModelArrayListAlpha.add( new AslModel(7, this.resourceID[6], "G"));
        aslModelArrayListAlpha.add( new AslModel(8, this.resourceID[7], "H"));
        aslModelArrayListAlpha.add( new AslModel(9, this.resourceID[8], "I"));
        aslModelArrayListAlpha.add( new AslModel(10, this.resourceID[9], "J"));
        aslModelArrayListAlpha.add( new AslModel(11, this.resourceID[10], "K"));
        aslModelArrayListAlpha.add( new AslModel(12, this.resourceID[11], "L"));
        aslModelArrayListAlpha.add( new AslModel(13, this.resourceID[12], "M"));
        aslModelArrayListAlpha.add( new AslModel(14, this.resourceID[13], "M"));
        aslModelArrayListAlpha.add( new AslModel(15, this.resourceID[14], "O"));
        aslModelArrayListAlpha.add( new AslModel(16, this.resourceID[15], "P"));
        aslModelArrayListAlpha.add( new AslModel(17, this.resourceID[16], "Q"));
        aslModelArrayListAlpha.add( new AslModel(18, this.resourceID[17], "R"));
        aslModelArrayListAlpha.add( new AslModel(19, this.resourceID[18], "S"));
        aslModelArrayListAlpha.add( new AslModel(20, this.resourceID[19], "T"));
        aslModelArrayListAlpha.add( new AslModel(21, this.resourceID[20], "U"));
        aslModelArrayListAlpha.add( new AslModel(22, this.resourceID[21], "U"));
        aslModelArrayListAlpha.add( new AslModel(23, this.resourceID[22], "W"));
        aslModelArrayListAlpha.add( new AslModel(24, this.resourceID[23], "X"));
        aslModelArrayListAlpha.add( new AslModel(25, this.resourceID[24], "Y"));
        aslModelArrayListAlpha.add( new AslModel(26, this.resourceID[25], "Z"));

        return aslModelArrayListAlpha;
    }

    public void Searching(String text,ASL_RecyclerView_Adapter recyclerViewAdapter) {
        ArrayList<AslModel> aslModelList = new ArrayList<>();

        for(AslModel i:aslModelArrayList) {
            if (i.getAslAlphabet().toLowerCase().contains(text.toLowerCase())) {
                aslModelList.add(i);
            }

            if (aslModelArrayList.isEmpty()) {
                Toast.makeText(this, "Please Enter", Toast.LENGTH_SHORT).show();
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
            for(AslModel i: aslModelArrayList) {
                char aslLetter = Character.toLowerCase(i.getAslAlphabet().charAt(0));
                if (aslLetter == letter) {
                    aslModelList.add(i);
                }

                if (aslModelArrayList.isEmpty()) {
                    Toast.makeText(this, "Please Enter", Toast.LENGTH_SHORT).show();
                } else {
                    adapter = new ASL_RecyclerView_Adapter(this,aslModelList);
                }
            }
        }
        return adapter;
    }

    public ASL_RecyclerView_Adapter searchAndSetAdapter(String query) {
        ASL_RecyclerView_Adapter adapter = null;
        ArrayList<AslModel> aslModelList = new ArrayList<>();
//        ArrayList<AslModel> aslModelArrayList1 = getAslModelArrayListAlpha();
        for(int j = 0; j < query.length();j++) {

            char letter = Character.toLowerCase(query.charAt(j));
            for(AslModel i: aslModelArrayList) {
                char aslLetter = Character.toLowerCase(i.getAslAlphabet().charAt(0));
                if (aslLetter == letter) {
                    aslModelList.add(i);
                }

                if (aslModelArrayList.isEmpty()) {
                    Toast.makeText(this, "Please Enter", Toast.LENGTH_SHORT).show();
                } else {
                    adapter = new ASL_RecyclerView_Adapter(this,aslModelList);
                }
            }
        }
        return adapter;
    }

    public void wordSearch(String query){
        ArrayList<AslModel> aslModels = new ArrayList<>();
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<ASL_RecyclerView_Adapter> adapterArrayList = new ArrayList<>();
        int countWords;
        if(query.contains(" ")) {
            words.addAll(Arrays.asList(query.split(" ")));

        /*for(int w=0;w<words.size();w++)
            Toast.makeText(MainActivity2.this," "+words.get(w),Toast.LENGTH_SHORT).show();*/
            for (int w = 0; w < words.size(); w++) {
                adapterArrayList.add(searchAndSetAdapter(words.get(w)));
            }
            asl_main_adapter.setQueryRecyclerViews(adapterArrayList);
        }
        else{
            ArrayList<ASL_RecyclerView_Adapter> adapterArrayList1 = new ArrayList<>();
            adapterArrayList1.add(Searching2(query));
            asl_main_adapter.setQueryRecyclerViews(adapterArrayList1);
        }
    }
    public void updateDataBase(){

        AslModel A = new AslModel(1, this.resourceID[0], "A");
        AslModel B = new AslModel(2, this.resourceID[1], "B");
        AslModel C = new AslModel(3, this.resourceID[2], "C");
        AslModel D = new AslModel(4, this.resourceID[3], "D");
        AslModel E = new AslModel(5, this.resourceID[4], "E");
        AslModel F = new AslModel(6, this.resourceID[5], "F");
        AslModel G = new AslModel(7, this.resourceID[6], "G");
        AslModel H = new AslModel(8, this.resourceID[7], "H");
        AslModel I = new AslModel(9, this.resourceID[8], "I");
        AslModel J = new AslModel(10, this.resourceID[9], "J");
        AslModel K = new AslModel(11, this.resourceID[10], "K");
        AslModel L = new AslModel(12, this.resourceID[11], "L");
        AslModel M = new AslModel(13, this.resourceID[12], "M");
        AslModel N = new AslModel(14, this.resourceID[13], "M");
        AslModel O = new AslModel(15, this.resourceID[14], "O");
        AslModel P = new AslModel(16, this.resourceID[15], "P");
        AslModel Q = new AslModel(17, this.resourceID[16], "Q");
        AslModel R = new AslModel(18, this.resourceID[17], "R");
        AslModel S = new AslModel(19, this.resourceID[18], "S");
        AslModel T = new AslModel(20, this.resourceID[19], "T");
        AslModel U = new AslModel(21, this.resourceID[20], "U");
        AslModel V = new AslModel(22, this.resourceID[21], "U");
        AslModel W = new AslModel(23, this.resourceID[22], "W");
        AslModel X = new AslModel(24, this.resourceID[23], "X");
        AslModel Y = new AslModel(25, this.resourceID[24], "Y");
        AslModel Z = new AslModel(26, this.resourceID[25], "Z");
        AslModel one = new AslModel(27, this.resourceID[26], "1");
        AslModel two = new AslModel(28, this.resourceID[27], "2");
        AslModel three = new AslModel(29, this.resourceID[28], "3");
        AslModel four = new AslModel(30, this.resourceID[29], "4");
        AslModel five = new AslModel(31, this.resourceID[30], "5");
        AslModel six = new AslModel(32, this.resourceID[31], "6");
        AslModel seven = new AslModel(33, this.resourceID[32], "7");
        AslModel eight = new AslModel(34, this.resourceID[33], "8");
        AslModel nine = new AslModel(35, this.resourceID[34], "9");
        AslModel zero = new AslModel(36, this.resourceID[35], "0");


        AslModel bored = new AslModel(37, this.resourceIDWords[0], "BORED");
        AslModel goodbye = new AslModel(38, this.resourceIDWords[1], "GOODBYE");
        AslModel hello = new AslModel(39, this.resourceIDWords[2], "HELLO");
        AslModel help = new AslModel(40, this.resourceIDWords[3], "HELP");
        AslModel please = new AslModel(41, this.resourceIDWords[4], "PLEASE");
        AslModel sad = new AslModel(42, this.resourceIDWords[5], "SAD");
        AslModel sorry = new AslModel(43, this.resourceIDWords[6], "SORRY");
        AslModel stop = new AslModel(44, this.resourceIDWords[7], "STOP");
        AslModel thanks = new AslModel(45, this.resourceIDWords[8], "THANKS");
        AslModel when = new AslModel(46, this.resourceIDWords[9], "WHEN");
        AslModel where = new AslModel(47, this.resourceIDWords[10], "WHERE");
        AslModel which = new AslModel(48, this.resourceIDWords[11], "WHICH");
        AslModel welcome = new AslModel(49, this.resourceIDWords[12], "You Are Welcome/WELCOME");

        db.addASL(A);
        db.addASL(B);
        db.addASL(C);
        db.addASL(D);
        db.addASL(E);
        db.addASL(F);
        db.addASL(G);
        db.addASL(H);
        db.addASL(I);
        db.addASL(J);
        db.addASL(K);
        db.addASL(L);
        db.addASL(M);
        db.addASL(N);
        db.addASL(O);
        db.addASL(P);
        db.addASL(Q);
        db.addASL(R);
        db.addASL(S);
        db.addASL(T);
        db.addASL(U);
        db.addASL(V);
        db.addASL(W);
        db.addASL(X);
        db.addASL(Y);
        db.addASL(Z);
        db.addASL(zero);
        db.addASL(one);
        db.addASL(two);
        db.addASL(three);
        db.addASL(four);
        db.addASL(five);
        db.addASL(six);
        db.addASL(seven);
        db.addASL(eight);
        db.addASL(nine);

//        db.deleteTABLE();



        /*db.addASL(bored);
        db.addASL(goodbye);
        db.addASL(hello);
        db.addASL(help);
        db.addASL(please);
        db.addASL(sad);
        db.addASL(sorry);
        db.addASL(stop);
        db.addASL(thanks);
        db.addASL(when);
        db.addASL(where);
        db.addASL(which);
        db.addASL(welcome);*/

        List<AslModel> aslModelList = db.getAllAslMap();
        aslModelArrayList.addAll(aslModelList);

//        List<AslModel> aslWordsModelList = db_words.getAllAslMap();
//        aslWordsModelArrayList.addAll(aslWordsModelList);
    }

    public ArrayList<AslModel> getAslModelArrayListWords() {

        aslModelArrayListWords.add(new AslModel(1, this.resourceIDWords[0], "BORED"));
        aslModelArrayListWords.add(new AslModel(2, this.resourceIDWords[1], "GOODBYE"));
        aslModelArrayListWords.add(new AslModel(3, this.resourceIDWords[2], "HELLO"));
        aslModelArrayListWords.add(new AslModel(4, this.resourceIDWords[3], "HELP"));
        aslModelArrayListWords.add(new AslModel(5, this.resourceIDWords[4], "PLEASE"));
        aslModelArrayListWords.add(new  AslModel(6, this.resourceIDWords[5], "SAD"));
        aslModelArrayListWords.add(new AslModel(7, this.resourceIDWords[6], "SORRY"));
        aslModelArrayListWords.add(new AslModel(8, this.resourceIDWords[7], "STOP"));
        aslModelArrayListWords.add(new AslModel(9, this.resourceIDWords[8], "THANKS"));
        aslModelArrayListWords.add(new AslModel(10, this.resourceIDWords[9], "WHEN"));
        aslModelArrayListWords.add(new AslModel(11, this.resourceIDWords[10], "WHERE"));
        aslModelArrayListWords.add(new AslModel(12, this.resourceIDWords[11], "WHICH"));
        aslModelArrayListWords.add(new AslModel(13, this.resourceIDWords[12], "You Are Welcome/WELCOME"));

        return aslModelArrayListWords;
    }
}