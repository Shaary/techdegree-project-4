package com.shaary.whichanimalareyou.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.shaary.whichanimalareyou.R;
import com.shaary.whichanimalareyou.model.AnimalSelector;

import java.util.ArrayList;
import java.util.List;

public class WhichAnimalActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "MainActivity";

    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    private Spinner spinner6;
    private Spinner spinner7;
    private Spinner spinner8;
    private Button button;
    AnimalSelector animalSelector = new AnimalSelector();
    private List<Integer> answers = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_which_animal);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);
        spinner5 = findViewById(R.id.spinner5);
        spinner6 = findViewById(R.id.spinner6);
        spinner7 = findViewById(R.id.spinner7);
        spinner8 = findViewById(R.id.spinner8);
        button = findViewById(R.id.button);

        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(this, R.array.options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        spinner4.setAdapter(adapter);
        spinner5.setAdapter(adapter);
        spinner6.setAdapter(adapter);
        spinner7.setAdapter(adapter);
        spinner8.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
        spinner4.setOnItemSelectedListener(this);
        spinner5.setOnItemSelectedListener(this);
        spinner6.setOnItemSelectedListener(this);
        spinner7.setOnItemSelectedListener(this);
        spinner8.setOnItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String animal = animalSelector.AnimalSelector(answers);

                chooseAnimal(animal);
            }
        });
    }

    private void chooseAnimal(String animal) {
        Intent intent = new Intent(this, ResultActivity.class);
        Resources resources = getResources();
        String key = resources.getString(R.string.key_name);
        intent.putExtra(key, animal);
        startActivity(intent);
        finish();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinner1:
                answers.add(0, spinner1.getSelectedItemPosition());
                break;
            case R.id.spinner2:
                answers.add(1, spinner2.getSelectedItemPosition());
                break;
            case R.id.spinner3:
                answers.add(2, spinner3.getSelectedItemPosition());
                break;
            case R.id.spinner4:
                answers.add(3, spinner4.getSelectedItemPosition());
                break;
            case R.id.spinner5:
                answers.add(4, spinner5.getSelectedItemPosition());
                break;
            case R.id.spinner6:
                answers.add(5, spinner6.getSelectedItemPosition());
                break;
            case R.id.spinner7:
                answers.add(6, spinner7.getSelectedItemPosition());
                break;
            case R.id.spinner8:
                answers.add(7, spinner8.getSelectedItemPosition());
                break;
            default:
                Toast.makeText(this, "Choose an option", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
