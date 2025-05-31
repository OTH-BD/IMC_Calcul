package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText poidsInput, tailleInput;
    Button calculerBtn;
    TextView resultatIMC, categorieText;
    ImageView imageCategorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poidsInput = findViewById(R.id.poidsInput);
        tailleInput = findViewById(R.id.tailleInput);
        calculerBtn = findViewById(R.id.calculerBtn);
        resultatIMC = findViewById(R.id.resultatIMC);
        categorieText = findViewById(R.id.categorieText);
        imageCategorie = findViewById(R.id.imageCategorie);

        calculerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculerIMC();
            }
        });
    }

    private void calculerIMC() {
        String poidsStr = poidsInput.getText().toString();
        String tailleStr = tailleInput.getText().toString();

        if (poidsStr.isEmpty() || tailleStr.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        float poids = Float.parseFloat(poidsStr);
        float tailleCm = Float.parseFloat(tailleStr);
        float tailleM = tailleCm / 100;

        float imc = poids / (tailleM * tailleM);

        DecimalFormat df = new DecimalFormat("#.##");
        resultatIMC.setText("Votre IMC est: " + df.format(imc));

        if (imc < 18.5) {
            categorieText.setText("Maigreur");
            imageCategorie.setImageResource(R.drawable.maigre);
        } else if (imc < 25) {
            categorieText.setText("Normal");
            imageCategorie.setImageResource(R.drawable.normal);
        } else if (imc < 30) {
            categorieText.setText("Sur Poids");
            imageCategorie.setImageResource(R.drawable.surpoids);
        } else {
            categorieText.setText("Obésité");
            imageCategorie.setImageResource(R.drawable.tobese);
        }
    }
}
