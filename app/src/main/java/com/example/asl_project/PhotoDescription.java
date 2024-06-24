package com.example.asl_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        descriptionModels.add(new PhotoNDescriptionModel("Extend your index finger horizontally, pointing to the side.","Position your thumb parallel to your index finger, pointing in the same direction, while keeping other fingers curled in. "));//G
        descriptionModels.add(new PhotoNDescriptionModel("Extend your index and middle fingers together horizontally. "," Tuck your thumb and remaining fingers into your palm."));//H
        descriptionModels.add(new PhotoNDescriptionModel("Extend your pinky finger straight up.  ","Curl the other fingers into your palm, keeping your thumb against the side of your hand. "));//I
        descriptionModels.add(new PhotoNDescriptionModel("Extend your pinky finger straight up.  ","Draw a \"J\" shape in the air with your pinky, starting from the top and curving downwards. "));//J
        descriptionModels.add(new PhotoNDescriptionModel("Extend your index and middle fingers straight up and spread apart. ","Position your thumb between the index and middle fingers, pointing up. "));//K
        descriptionModels.add(new PhotoNDescriptionModel("Extend your thumb and index finger to form an \"L\" shape.","Keep the other three fingers curled into your palm."));//L
        descriptionModels.add(new PhotoNDescriptionModel("Curl your pinky, ring, and middle fingers over your thumb, placing the thumb between them.","Keep your index finger extended against the top of your thumb."));//M
        descriptionModels.add(new PhotoNDescriptionModel("Curl your ring and middle fingers over your thumb, placing the thumb between them.","Keep your index and pinky fingers extended."));//N
        descriptionModels.add(new PhotoNDescriptionModel("Bring your fingers and thumb together to form an \"O\" shape. ","Keep the tips of your fingers touching the tip of your thumb."));//O
        descriptionModels.add(new PhotoNDescriptionModel("Extend your index and middle fingers together, pointing upwards.","Place your thumb between the index and middle fingers, then rotate your hand so the fingers point downward."));//P
        descriptionModels.add(new PhotoNDescriptionModel("Extend your thumb and index finger together, pointing downwards. ","Keep the other fingers curled into your palm.\n"));//Q
        descriptionModels.add(new PhotoNDescriptionModel("Cross your index and middle fingers over each other.","Keep the other fingers curled into your palm."));//R
        descriptionModels.add(new PhotoNDescriptionModel("Make a fist with all fingers curled tightly into your palm. ","Position your thumb over the front of your fingers."));//S
        descriptionModels.add(new PhotoNDescriptionModel("Make a fist with your thumb tucked under your index finger. ","Let the thumb protrude slightly between the index and middle fingers."));//T
        descriptionModels.add(new PhotoNDescriptionModel("Extend your index and middle fingers together, pointing upwards. ","Keep the other fingers curled into your palm, with your thumb resting against the side of your palm."));//U
        descriptionModels.add(new PhotoNDescriptionModel("Extend your index and middle fingers to form a \"V\" shape. ","Keep the other fingers curled into your palm."));//V
        descriptionModels.add(new PhotoNDescriptionModel("Extend your thumb, index, and middle fingers to form a \"W\" shape. ","Keep your ring and pinky fingers curled into your palm."));//W
        descriptionModels.add(new PhotoNDescriptionModel("Extend your index finger, curling it to form a hook. ","Keep the other fingers curled into your palm."));//X
        descriptionModels.add(new PhotoNDescriptionModel("Extend your thumb and pinky finger outward.","Keep the other fingers curled into your palm."));//y
        descriptionModels.add(new PhotoNDescriptionModel("Extend your index finger straight up. ","Use your index finger to draw a \"Z\" shape in the air, starting from left to right, then diagonally down to the left, and finally across to the right."));//Z

    }
}