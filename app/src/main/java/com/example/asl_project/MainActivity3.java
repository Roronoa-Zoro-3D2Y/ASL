package com.example.asl_project;//

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asl_project.Adapters.ASL_RecyclerView_Adapter;
import com.example.asl_project.Model.AslModel;
import com.example.asl_project.data.ASLHandler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity implements ASLRecyclerViewInterface{
    RecyclerView recyclerView,recyclerView2;
    ListView listViewMain;
    RecyclerView.LayoutManager layoutManager;
    ASLHandler db = new ASLHandler(this);

    ASLHandler db2 = new ASLHandler(this);
    ArrayList<AslModel> aslModelArrayList = new ArrayList();
    ArrayList<AslModel> aslModelArrayList2 = new ArrayList<>();
    ASL_RecyclerView_Adapter recyclerViewAdapter;
    SearchView searchView;
    ImageView home;
    int[] resourceID = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
            R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,
            R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o,
            R.drawable.p,R.drawable.q,R.drawable.r,R.drawable.s,R.drawable.t,
            R.drawable.u,R.drawable.v,R.drawable.w,R.drawable.x,R.drawable.y,
            R.drawable.z,R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,
            R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,
            R.drawable.zero
    };
    int[] asl_words_IDs = new int[]{};

    public MainActivity3() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        home = (ImageView)this.findViewById(R.id.home_icon);
        recyclerView = (RecyclerView)this.findViewById(R.id.recyclerView_main_3);

        layoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(layoutManager);

        searchView = (SearchView)this.findViewById(R.id.searchView);
        searchView.clearFocus();
        this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                Searching2(query);
                return true;
            }

            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, MainActivity3.class);
                MainActivity3.this.startActivity(intent);
            }
        });
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

        List<AslModel> aslModelList = this.db.getAllAslMap();
        aslModelArrayList.addAll(aslModelList);

        for(AslModel i:aslModelArrayList) {
            Log.d("TAG", "onCreate: " + i.getId() + " id " + i.getAslAlphabet() + " alpha ");
        }

        recyclerViewAdapter = new ASL_RecyclerView_Adapter(MainActivity3.this, aslModelArrayList,this);
        recyclerView.setAdapter(this.recyclerViewAdapter);

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            public boolean onClose() {
                return true;
            }
        });
    }

    public void Searching(String text) {
        ArrayList<AslModel> aslModelList = new ArrayList<>();

        for(AslModel i:aslModelArrayList) {
            if (i.getAslAlphabet().toLowerCase().contains(text.toLowerCase())) {
                aslModelList.add(i);
            }

            if (this.aslModelArrayList.isEmpty()) {
                Toast.makeText(this, "Please Enter", Toast.LENGTH_SHORT).show();
            } else {
                this.recyclerViewAdapter.setFilteredList(aslModelList);
            }
        }

    }

    public void Searching2(String query) {
        ArrayList<AslModel> aslModelList = new ArrayList<>();

        for(int j = 0; j < query.length(); ++j) {
            char letter = Character.toLowerCase(query.charAt(j));
            for(AslModel i:aslModelArrayList) {
                char aslLetter = Character.toLowerCase(i.getAslAlphabet().charAt(0));
                if (aslLetter == letter) {
                    aslModelList.add(i);
                }

                if (this.aslModelArrayList.isEmpty()) {
                    Toast.makeText(this, "Please Enter", Toast.LENGTH_SHORT).show();
                } else {
                    this.recyclerViewAdapter.setFilteredList(aslModelList);
                }
            }
        }

    }

    public void SearchingWords(String query){
        ArrayList<AslModel> filterList  = new ArrayList<>();
        if(query.contains(" ")){

        }
    }

    public ASL_RecyclerView_Adapter getRecyclerViewAdapter() {
        recyclerViewAdapter = new ASL_RecyclerView_Adapter(this,getAslModelArrayList2(),this);
        return recyclerViewAdapter;
    }

    public ArrayList<AslModel> getAslModelArrayList2() {
        AslModel A = new AslModel(1, this.resourceID[0], "A");
        AslModel B = new AslModel(2, this.resourceID[1], "B");
        AslModel C = new AslModel(3, this.resourceID[2], "C");
        AslModel D = new AslModel(4, this.resourceID[3], "D");
        aslModelArrayList2.add(A);
        aslModelArrayList2.add(B);
        aslModelArrayList2.add(C);
        aslModelArrayList2.add(D);

        return aslModelArrayList2;
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
