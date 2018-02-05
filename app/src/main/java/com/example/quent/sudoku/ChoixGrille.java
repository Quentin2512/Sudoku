package com.example.quent.sudoku;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TwoLineListItem;

import com.example.MyDessin.Dessin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ChoixGrille extends AppCompatActivity {

    MyAdapter adapter;
    Context cont;
    InputStream inputStream;
    BufferedReader buffer;
    String grille = "";
    ArrayList<String> listGrilles = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_grille);

        cont = this;

        Bundle objetbunble = this.getIntent().getExtras();
        this.setTitle("Sudoku niveau " + objetbunble.getInt("niveau"));
        int file = 0;

        switch (objetbunble.getInt("niveau")) {
            case 1:
                file = R.raw.lvl_1;
                break;
            case 2:
                file = R.raw.lvl_2;
                break;
            case 3:
                file = R.raw.lvl_3;
                break;
        }
        inputStream = this.getResources().openRawResource(file);

        buffer = new BufferedReader(new InputStreamReader(inputStream));

        String str = "";
        if (inputStream != null) {
            try {
                while ((str = buffer.readLine()) != null) {
                    listGrilles.add(str);
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        ArrayList<vGrille> listVgril = new ArrayList<vGrille>();
        for (int i = 1; i <= listGrilles.size(); i++) {
            listVgril.add(new vGrille(objetbunble.getInt("niveau"), i));
        }

        adapter = new MyAdapter(this, listVgril);
        ListView listV = (ListView) findViewById(R.id.listV);
        listV.setAdapter(adapter);
        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                vGrille item = (vGrille) parent.getAdapter().getItem(position);
                new AlertDialog.Builder(cont)
                        .setTitle("Information ")
                        .setMessage("Niveau " + item.level + " --> " + item.done + "%")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(cont, Grille.class);
                                Bundle objet = new Bundle();
                                System.out.println(listGrilles.get(position));
                                objet.putString("grille", listGrilles.get(position));
                                intent.putExtras(objet);
                                cont.startActivity(intent);

                            }
                        }).show();
            }
        });
    }
}
