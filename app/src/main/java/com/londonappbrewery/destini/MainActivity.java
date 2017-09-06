package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import static android.R.id.list;
import static com.londonappbrewery.destini.R.id.bottom;
import static com.londonappbrewery.destini.R.id.buttonTop;
import static com.londonappbrewery.destini.R.id.top;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button topButton;
    Button bottomButton;
    TextView story;

    int currentStory;

    void setEndingButtons(){
        currentStory = 4;
        topButton.setText(R.string.Restart);
        bottomButton.setText(R.string.Finish);
    }

    void updateTopStories(){
        if(currentStory == 1 || currentStory == 2){
            currentStory = 3;
            story.setText(R.string.T3_Story);
            topButton.setText(R.string.T3_Ans1);
            bottomButton.setText(R.string.T3_Ans2);
        } else if(currentStory == 3) {
            story.setText(R.string.T6_End);
            setEndingButtons();
        } else {
            currentStory = 1;
            story.setText(R.string.T1_Story);
            topButton.setText(R.string.T1_Ans1);
            bottomButton.setText(R.string.T1_Ans2);
        }
    }

    void updateBottomStories(){
        if(currentStory == 1){
            currentStory = 2;
            story.setText(R.string.T2_Story);
            topButton.setText(R.string.T2_Ans1);
            bottomButton.setText(R.string.T2_Ans2);
        } else if(currentStory == 2) {
            story.setText(R.string.T4_End);
            setEndingButtons();
        } else if(currentStory == 3){
            story.setText(R.string.T5_End);
            setEndingButtons();
        } else {
            finish();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("currentStory", currentStory);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        topButton = (Button)findViewById(R.id.buttonTop);
        bottomButton = (Button)findViewById(R.id.buttonBottom);
        story = (TextView)findViewById(R.id.storyTextView);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        topButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                updateTopStories();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        bottomButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                updateBottomStories();
            }
        });

    }
}
