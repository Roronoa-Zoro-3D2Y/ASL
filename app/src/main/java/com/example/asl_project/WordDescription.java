package com.example.asl_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asl_project.Model.WordDescriptionModel;
import com.example.asl_project.parameters.MyConstant;

import java.util.ArrayList;

public class WordDescription extends AppCompatActivity {

    private TextView tv_descrpHeading,tv_photoTitle,tv_handShp,tv_loc,tv_movement,tv_face;
    private ImageView iv_asl_photo,iv_asl_photo_2;
    MyConstant myConstant;

    private int[] resourceIDCommonWords = new int[]{
            R.drawable.asl_hello,R.drawable.asl_goodbye,R.drawable.asl_you_are_welcome,
            R.drawable.asl_please,R.drawable.asl_help,R.drawable.asl_thanks,
            R.drawable.asl_stop
    };
    int[] resourceIDFruits = new int[]{
            R.drawable.asl_apple,R.drawable.asl_banana,R.drawable.asl_berry,
            R.drawable.asl_grapes,R.drawable.asl_peach,
    };

    int[] resourceIDVegetables = new int[]{
            R.drawable.asl_lettuce,R.drawable.asl_corn,R.drawable.asl_peas,
            R.drawable.asl_carrot
    };

    int[] resourceIDFamily = new int[]{
            R.drawable.asl_whole_family,R.drawable.asl_daddy,R.drawable.asl_mother,
            R.drawable.asl_grandmother,R.drawable.asl_grandfather,R.drawable.asl_uncle,
            R.drawable.asl_aunt,R.drawable.asl_cousin,R.drawable.asl_sister,
            R.drawable.asl_brother,R.drawable.asl_baby
    };

    private int asl_img_loc;
    private String asl_alphabet;
    private String asl_img_id;
    private String asl_word_list;
    ArrayList<WordDescriptionModel> wordDescriptionModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_description);

        tv_descrpHeading = findViewById(R.id.asl_description_heading);
        tv_photoTitle = findViewById(R.id.asl_photo_title);
        tv_handShp = findViewById(R.id.handShape_textView);
        tv_loc = findViewById(R.id.location_textview);
        tv_movement = findViewById(R.id.movement_textview);
        tv_face = findViewById(R.id.face_textview);
        iv_asl_photo = findViewById(R.id.asl_photo);

         asl_alphabet = getIntent().getStringExtra("ASL_ALPHABET");
         asl_img_id =  getIntent().getStringExtra("ASL_IMAGE");
         asl_word_list =  getIntent().getStringExtra("WORD_LIST");

        if(asl_img_id != null)
            asl_img_loc = Integer.parseInt(asl_img_id);

        assert asl_word_list != null;
        if(asl_word_list.equals("family")) {
            iv_asl_photo = findViewById(R.id.asl_photo_family);
            iv_asl_photo.setVisibility(View.VISIBLE);
        }

        //setting list and image view using location and word list
        setIv_asl_photo(asl_img_loc-1,asl_word_list);


        tv_photoTitle.setText(wordDescriptionModels.get(asl_img_loc-1).getWord());

        Log.d("WordDescription", ""+tv_photoTitle
                .getText());

        tv_handShp.setText(wordDescriptionModels.get(asl_img_loc-1).getHandShape());
        tv_loc.setText(wordDescriptionModels.get(asl_img_loc-1).getLocationOnBody());
        tv_movement.setText(wordDescriptionModels.get(asl_img_loc-1).getMovement());
        tv_face.setText(wordDescriptionModels.get(asl_img_loc-1).getFacialExp());


    }

    public void setCommonWordsDescriptionModels() {
            wordDescriptionModels.clear();
            wordDescriptionModels.add(new WordDescriptionModel(MyConstant.COMMON_WORDS,"HELLO","Open hand with fingers together.","Near your forehead.","Move your hand away from your forehead in a small arc, like a salute.","Smile or neutral expression."));
            wordDescriptionModels.add(new WordDescriptionModel(MyConstant.COMMON_WORDS,"GOODBYE","Open hand with fingers together.","In front of your body. ","Wave your hand from side to side.","Smile or neutral expression."));
            wordDescriptionModels.add(new WordDescriptionModel(MyConstant.COMMON_WORDS,"WELCOME","Dominant hand forms a \"B\" handshape (palm flat, fingers together)."," Near your forehead.","Start with your hand near your forehead and then move it forward and down, as if indicating a gesture of respect or acknowledgement.","Smile or neutral expression. "));
            wordDescriptionModels.add(new WordDescriptionModel(MyConstant.COMMON_WORDS,"PLEASE","Open hand with fingers together. ","On your chest. "," Move your hand in a circular motion on your chest. "," Smile or neutral expression. "));
            wordDescriptionModels.add(new WordDescriptionModel(MyConstant.COMMON_WORDS,"HELP","Non-dominant hand is flat with palm up, dominant hand forms an \"A\" handshape (thumb extended)."," In front of your body. ","Place the dominant hand (in \"A\" handshape) on the palm of the non-dominant hand and move both hands upward together.","Neutral or slight smile."));
            wordDescriptionModels.add(new WordDescriptionModel(MyConstant.COMMON_WORDS,"THANKS","Open your dominant hand with fingers together.","At your chin."," Move your hand forward and slightly down from your chin, away from your face."," Smile or neutral expression. "));
            wordDescriptionModels.add(new WordDescriptionModel(MyConstant.COMMON_WORDS,"STOP","Non-dominant hand is flat with palm up, dominant hand is flat with palm down","In front of your body.","Bring the dominant hand down sharply onto the palm of the non-dominant hand at a right angle.","Serious or neutral expression."));
    }
    public void setFruitsDescriptionModels() {
        wordDescriptionModels.clear();
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.FRUITS,"APPLE","Dominant hand in the \"X\" handshape (index finger bent).","At your cheek.","Twist the \"X\" handshape at your cheek, as if you are twisting an apple.","Neutral or slight smile."));
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.FRUITS,"BANANA","Non-dominant hand in the \"1\" handshape (index finger extended), dominant hand in an open \"A\" handshape (fist with thumb extended).","In front of your body.","Mimic peeling a banana by using the dominant hand to peel down the non-dominant index finger.","Neutral or slight smile."));
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.FRUITS,"BERRY","Non-dominant hand in the \"S\" handshape (fist), dominant hand in the \"F\" handshape (thumb and index finger touching to form a circle, other fingers extended).","In front of your body.","Place the \"F\" handshape on the tip of the non-dominant hand’s pinky and twist the \"F\" handshape slightly.","Neutral."));
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.FRUITS,"GRAPES","Non-dominant hand in an open \"B\" handshape (palm down, fingers together), dominant hand in a claw shape.","In front of your body","Tap the fingertips of the dominant hand (claw shape) on the back of the non-dominant hand, moving down the back of the hand as if showing clusters of grapes.","Smile or neutral expression. "));
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.FRUITS,"PEACH","Dominant hand in a flat \"O\" handshape (fingers together and slightly curved, touching the thumb)","At your cheek.","Brush the flat \"O\" handshape against your cheek, moving it slightly up and down.","Neutral or slight smile."));

    }

    public void setVegetablesDescriptionModels() {
        wordDescriptionModels.clear();
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.VEGETABLES,"LETTUCE","Dominant hand forms a claw shape (like a loose \"C\").","Side of your head, above your ear.","Tap the clawed hand against the side of your head a couple of times.","Neutral or slight smile."));
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.VEGETABLES,"CORN", "Dominant hand forms a fist with the thumb and index finger extended, mimicking holding an ear of corn.","In front of your mouth.","Move the hand from one side of your mouth to the other, as if eating corn off the cob.","Smile or neutral expression."));
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.VEGETABLES,"PEAS","Non-dominant hand holds the index finger extended. Dominant hand's thumb and index finger form a pinching motion.","In front of your body.","Use the dominant hand to pinch along the length of the non-dominant index finger, as if showing the size of small peas.","neutral expression."));
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.VEGETABLES,"CARROT","Dominant hand forms a fist.","Near your mouth.","Move the fist up to your mouth, twisting it slightly as if you are taking a bite out of a carrot.","Neutral or slight smile."));
    }

    public void setFamilyDescriptionModels(){
        wordDescriptionModels.clear();
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.FAMILY,"FAMILY","Both hands form the \"F\" handshape (thumb and index finger touch to form a circle, other fingers extended).","In front of your chest.","Start with the \"F\" handshapes touching at the tips (thumbs and index fingers). Move your hands in a circular motion, ending with the \"F\" handshapes touching again, but the pinkies will be closer together, forming an enclosed circle"," Neutral"));
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.FAMILY,"FATHER","Open hand with fingers spread (the \"5\" handshape).","On your forehead.","Tap your thumb on your forehead twice.","Neutral or smile "));
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.FAMILY,"MOTHER","Open hand with fingers spread (the \"5\" handshape).","On your chin.","Tap your thumb on your chin twice."," Neutral or smile."));
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.FAMILY,"GRANDMOTHER","Open hand with fingers spread (the \"5\" handshape).","On your chin.","Move your hand forward in two small arcs, away from your chin."," Neutral or smile."));
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.FAMILY,"GRANDFATHER"," Open hand with fingers spread (the \"5\" handshape).","On your forehead.","Move your hand forward in two small arcs, away from your forehead.","Neutral or smile."));
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.FAMILY,"UNCLE","\"U\" handshape (index and middle fingers extended and together)."," Near the side of your forehead. ","Make a small circular motion or shake your hand slightly.","Neutral."));
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.FAMILY,"AUNT","\"A\" handshape (fist with thumb along the side)."," Near the side of your chin.","Make a small circular motion or shake your hand slightly.","Neutral."));
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.FAMILY,"COUSIN","\"C\" handshape (thumb and fingers form a \"C\")."," Near the side of your face. For a gender-neutral cousin, place the \"C\" handshape near the cheek. For a male cousin, place it near the forehead; for a female cousin, place it near the chin. ","Shake the \"C\" handshape slightly in a small circular motion.","Neutral."));
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.FAMILY,"SISTER","Both hands form the \"L\" handshape (index finger and thumb extended).","Dominant hand starts at the chin, non-dominant hand in front of your chest.","Move your dominant hand from your chin down to meet the non-dominant hand. Both hands should end in the \"L\" shape with index fingers extended and aligned.","Neutral."));
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.FAMILY,"BROTHER","Both hands form the \"L\" handshape (index finger and thumb extended).","Dominant hand starts at the forehead, non-dominant hand in front of your chest."," Move your dominant hand from your forehead down to meet the non-dominant hand. Both hands should end in the \"L\" shape with index fingers extended and aligned.","Neutral."));
        wordDescriptionModels.add(new WordDescriptionModel(MyConstant.FAMILY,"BABY","Both hands are open, palms up, fingers together.","In front of your torso.","Cradle your hands together and gently rock them back and forth, as if holding a baby.","Gentle or loving expression."));
    }

    public void setIv_asl_photo(int asl_img_loc,String asl_word_list){
        switch (asl_word_list){
            case "family":
                iv_asl_photo.setImageResource(resourceIDFamily[asl_img_loc]);
                setFamilyDescriptionModels();
                break;
            case "fruits":
               iv_asl_photo.setImageResource(resourceIDFruits[asl_img_loc]);
               setFruitsDescriptionModels();
                break;
            case "vegetables":
                iv_asl_photo.setImageResource(resourceIDVegetables[asl_img_loc]);
                setVegetablesDescriptionModels();
                break;
            case "common words":
                iv_asl_photo.setImageResource(resourceIDCommonWords[asl_img_loc]);
                setCommonWordsDescriptionModels();
                break;
        }
    }
}