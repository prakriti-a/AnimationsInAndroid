package com.prakriti.animationsinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtAnim, txtReplace, txtAndroid;
    private ImageView imgCat, imgDog;
    private boolean txtClicked = true, imgClicked = true; // default val is false

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // can use setX or setY to set position of view at specified point during startup of app
        // use translationXBy() or translationYBy() to reset them to original positions

        txtAnim = findViewById(R.id.txtAnim);
        txtReplace = findViewById(R.id.txtReplace);
        txtAndroid = findViewById(R.id.txtAndroid);

        imgDog = findViewById(R.id.imgDog);
        imgCat = findViewById(R.id.imgCat);

            // set on click listener for textview
        txtAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    // if - else condition used to reverse fade in & fade out of textviews
                if(txtClicked) {
                    // rotate rotates the view by specified degrees
                    // txtAnim.animate().rotation(60f).setDuration(1000); // duration in ms
                    // scaleX scales the view along X axis by specified value, similarly scaleY
                    // alpha (0~1) 0 is faded, 1 is solid
                    txtAnim.animate().alpha(0).setDuration(2000);
                    txtReplace.animate().alpha(1).setDuration(2000); // alpha initially set as 0
                    txtClicked = false;
                }
                else { // else if (!txtClicked)
                    txtReplace.animate().alpha(0).setDuration(2000);
                    txtAnim.animate().alpha(1).setDuration(2000);
                    txtClicked = true;
                }
            }
        });

        txtAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // translationX etc starts from top left corner of screen
                // view is moved in + or - direction at specified value on the axis in dp
                // positive axis is left (X) & down (Y)
                txtAndroid.animate().translationX(-200).translationY(400).setDuration(3000);
           //     txtAndroid.animate().translationY(400).setDuration(3000);
                    // animations can also be chained together
                txtAndroid.animate().rotation(360).setDuration(1000);
                // txtAndroid.animate().translationZ(500).setDuration(2000); // along Z axis
                // translationXBy() - works similarly but moves view acc to its current position

                // rotationXBy() works similar to rotation()
                // rotationX or rotationY rotates the view along the axis, not along the screen

                // scaleX() scales up (<0) or down (>0) the view acc to specified value along X axis
                // txtAndroid.animate().scaleX(0.2f).scaleY(0.5f).setDuration(3000);
            }
        });

            // set code for transitioning thru multiple images
        imgDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imgClicked) {
                //    imgPic.animate().rotationY(360).setDuration(1000);
                  //  imgPic.setImageResource(R.drawable.cat);
                    imgDog.animate().alpha(0).rotationY(360).setDuration(2000);
                    imgCat.animate().alpha(1).setDuration(2000);
                    imgClicked = false;
                }
                else { // else if (!txtClicked)
//                    imgPic.animate().rotationY(360).setDuration(1000);
  //                  imgPic.setImageResource(R.drawable.dog);
                    imgCat.animate().alpha(0).rotationY(360).setDuration(2000);
                    imgDog.animate().alpha(1).setDuration(2000);
                    imgClicked = true;
                }
            }
        });

    }
}