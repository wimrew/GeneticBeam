package com.example.imrevekov.geneticbeam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText totalLengthEditText, distributedForceEditText, iterationsEditText;
    Button calculateButton;
    Beams beams;
    TextView results;
    Archive archive;
    double distributedForce;
    double totalLength;
    int iterations, populationSize;
    Population population, initialPopulation;
    String initialPopulationString, finalPopulationString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeGraphics();
        populationSize = 100;
        beams = new Beams();
        archive = new Archive();
        Log.d("beams", beams.getBeams() + "");

    }

    private void insertPopulationIntoArchive() {
        ArrayList<Setup> tempSetups = population.getPopulationOfSetups();
        for (int i = 0; i < tempSetups.size(); i++) {
            Setup setup = tempSetups.get(i);
            if (setup.getAllRight())
                archive.insertSetupIntoArchive(setup);
        }
    }

    private void generatePopulation() {
        population = new Population(totalLength, distributedForce, populationSize);
        saveInitialPopulationInformation();
    }

    private void saveFinalPopulationInformation() {
        finalPopulationString = "";
        for (int i = 0; i < populationSize; i++) {
            finalPopulationString +=population.getPopulationOfSetups().get(i).beam.getName()+" " +population.getPopulationOfSetups().get(i).getOpenings()+ "\n";

        }
    }

    private void saveInitialPopulationInformation() {
        initialPopulationString = "";
        for (int i = 0; i < populationSize; i++) {
            initialPopulationString +=population.getPopulationOfSetups().get(i).beam.getName()+" " +population.getPopulationOfSetups().get(i).getOpenings()+ "\n";

        }
    }


    private void displayArchive() {
        ArrayList setupsFromArchive = archive.getSetups();
        results.setText("Archive:\n");
        for (int i = 0; i < setupsFromArchive.size(); i++) {
            results.setText(results.getText() + "\nSetup " + (i + 1) + ":\n" + setupsFromArchive.get(i) + "");
        }
    }

    private void displayBestSetup() {
        results.setText(results.getText() + "\nBest solution from the archive:\n" + archive.bestSetupFromArchive());
    }

    private void initializeGraphics() {
        totalLengthEditText = (EditText) findViewById(R.id.editText);
        distributedForceEditText = (EditText) findViewById(R.id.editText2);
        iterationsEditText = (EditText) findViewById(R.id.editText3);
        calculateButton = (Button) findViewById(R.id.button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                archive.clearSetups();
                distributedForce = Double.parseDouble(distributedForceEditText.getText().toString());
                totalLength = Double.parseDouble(totalLengthEditText.getText().toString());
                iterations = Integer.parseInt(iterationsEditText.getText().toString());
                generatePopulation();
                insertPopulationIntoArchive();
                for (int i = 0; i < iterations; i++) {
                    population.mutatePopulation();
                    population.crossoverPopulation();
                    insertPopulationIntoArchive();
                }
                saveFinalPopulationInformation();
                displayArchive();
                displayBestSetup();


                Log.d("population", "The initial population:");
                Log.d("population", initialPopulationString);
                Log.d("population", "The final population:");
                Log.d("population", finalPopulationString);
            }
        });
        results = (TextView) findViewById(R.id.textView8);
        results.setText("");
    }


}
