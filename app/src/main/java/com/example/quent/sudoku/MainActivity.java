package com.example.quent.sudoku;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Context context;
    Bundle objetbunble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        Button btnNiv1 = (Button) findViewById(R.id.niv1);
        Button btnNiv2 = (Button) findViewById(R.id.niv2);
        Button btnNiv3 = (Button) findViewById(R.id.niv3);

        btnNiv1.setOnClickListener(this);
        btnNiv2.setOnClickListener(this);
        btnNiv3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        intent = new Intent(context, ChoixGrille.class);
        objetbunble = new Bundle();
        switch (v.getId()) {
            case R.id.niv1:
                objetbunble.putInt("niveau", 1);
                break;
            case R.id.niv2:
                objetbunble.putInt("niveau", 2);
                break;
            case R.id.niv3:
                objetbunble.putInt("niveau", 3);
                break;
        }
        intent.putExtras(objetbunble);
        context.startActivity(intent);
    }
}
