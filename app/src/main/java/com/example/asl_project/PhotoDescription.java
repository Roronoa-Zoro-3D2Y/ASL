package com.example.asl_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asl_project.Model.PhotoNDescriptionModel;

import java.util.ArrayList;
import java.util.Objects;

public class PhotoDescription extends AppCompatActivity {

    TextView tv_photo_title;
    ImageView iv_asl_photo;
    TextView tv_asl_photo_heading;
    TextView tv_dsrcp_line1,tv_dsrcp_line2;
    int asl_img_loc;
    int[] resourceID = new int[]{R.drawable.a_color,R.drawable.b_color,R.drawable.c_color,R.drawable.d_color,R.drawable.e_color,
            R.drawable.f_color,R.drawable.g_color,R.drawable.h_color,R.drawable.i_color,R.drawable.j_color,
            R.drawable.k_color,R.drawable.l_color,R.drawable.m_color,R.drawable.n_color,R.drawable.o_color,
            R.drawable.p_color,R.drawable.q_color,R.drawable.r_color,R.drawable.s_color,R.drawable.t_color,
            R.drawable.u_color,R.drawable.v_color,R.drawable.w_color,R.drawable.x_color,R.drawable.y_color,
            R.drawable.z_color,R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,
            R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,
            R.drawable.zero
    };

    ArrayList<PhotoNDescriptionModel> descriptionModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_description);

        String asl_alphabet = getIntent().getStringExtra("ASL_ALPHABET");
        String asl_img_id =  getIntent().getStringExtra("ASL_IMAGE");

        if(asl_img_id != null)
            asl_img_loc = Integer.parseInt(asl_img_id);

        tv_photo_title = findViewById(R.id.asl_photo_title);
        iv_asl_photo = findViewById(R.id.asl_photo);
        tv_dsrcp_line1 = findViewById(R.id.asl_photo_dscrp_line1);
        tv_dsrcp_line2 = findViewById(R.id.asl_photo_dscrp_line2);
        tv_asl_photo_heading = findViewById(R.id.asl_description_heading);
        setDescriptionModels();

        tv_photo_title.setText(asl_alphabet);
        iv_asl_photo.setImageResource(resourceID[asl_img_loc - 1]);
        tv_dsrcp_line1.setText(descriptionModels.get(asl_img_loc - 1).getDescription_line1());
        tv_dsrcp_line2.setText(descriptionModels.get(asl_img_loc - 1).getDescription_line2());

        tv_asl_photo_heading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhotoDescription.this, HomeScreen.class);
                startActivity(intent);
            }
        });

    }

    public void setDescriptionModels() {
        descriptionModels.add(new PhotoNDescriptionModel("Make a fist with all fingers curled tightly into your palm.","Place your thumb against the side of your index finger, resting along the outer edge."));//A
        descriptionModels.add(new PhotoNDescriptionModel("Extend all fingers straight and together, pointing upward","Place your thumb across your palm, touching the base of your fingers."));//B
        descriptionModels.add(new PhotoNDescriptionModel("Curve all your fingers and thumb to form the shape of the letter \"C\". ","Keep your fingers and thumb separated, maintaining the curve."));//C
        descriptionModels.add(new PhotoNDescriptionModel("Extend your index finger straight up."," Curl the remaining fingers down to touch your thumb, forming a small circle."));//D
        descriptionModels.add(new PhotoNDescriptionModel("Curl your fingers down towards your palm.","Press your thumb against the tips of your fingers."));//E
        descriptionModels.add(new PhotoNDescriptionModel("Touch the tips of your thumb and index finger together to form a circle. ","Extend the other three fingers straight up and apart."));//F
    }
}