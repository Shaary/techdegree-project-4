package com.shaary.whichanimalareyou.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.shaary.whichanimalareyou.R;
import com.shaary.whichanimalareyou.model.Animal;
import com.shaary.whichanimalareyou.model.Zoo;

public class ResultActivity extends AppCompatActivity implements MyCustomDialogue.OnInputListener{

    public static final String TAG = "ResultActivity";

    private Zoo zoo;
    private ImageView animalImageView;
    private TextView bubbleText;
    private Animal chosenAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        animalImageView = findViewById(R.id.animalImageView);
        bubbleText = findViewById(R.id.bubbleText);


        Intent intent = getIntent();
        String animal = intent.getStringExtra(getString(R.string.key_name));

        zoo = new Zoo();

        MyCustomDialogue dialog = new MyCustomDialogue();
        dialog.show(getFragmentManager(), "MyCustomDialog");

        loadAnimalImage(animal);
        toastMessage(animal);
    }
    private void loadAnimalImage(String animal) {
        chosenAnimal = zoo.getAnimal(animal);

        Drawable image = ContextCompat.getDrawable(this, chosenAnimal.getImageId());
        animalImageView.setImageDrawable(image);

        //Sets the bubbletext near the mouth of the animal
        bubbleSetter(chosenAnimal);
    }

    private void toastMessage(String animal) {
        if (animal.equalsIgnoreCase("owl") ||
                animal.equalsIgnoreCase("elephant")) {

            Toast.makeText(this, "You are an " + animal, Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "You are a " + animal, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void sendInput(String input) {
        Log.e(TAG, "sendInput: got the input" + input);
        if (input == null || input.isEmpty()) {
            bubbleText.setText(chosenAnimal.getCaption());
        } else {
            bubbleText.setText(input);
        }
    }

    public void bubbleSetter(Animal chosenAnimal) {

        float vBias = chosenAnimal.getVerticalBias();
        float hBias = chosenAnimal.getHorizontalBias();

        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) bubbleText.getLayoutParams();

        params.verticalBias = vBias;
        params.horizontalBias = hBias;

        bubbleText.setLayoutParams(params);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, WhichAnimalActivity.class));
    }
}
