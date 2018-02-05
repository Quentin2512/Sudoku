package com.example.quent.sudoku;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.MyDessin.Dessin;

public class Grille extends AppCompatActivity {

    Dessin d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grille);
        d = (Dessin)findViewById(R.id.dessin);

        Bundle bundle = this.getIntent().getExtras();

        String grille = bundle.getString("grille");
        d.grille = grille;
        d.activity = this;
        //d.grille = "001700509573024106800501002700295018009400305652800007465080071000159004908007053";
        //d.grille = "241768539573924186896531742734295618189476325652813497465382971327159864918647250";
    }

}
