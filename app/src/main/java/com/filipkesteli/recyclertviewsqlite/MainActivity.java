package com.filipkesteli.recyclertviewsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etOsobaID;
    private EditText etOsobaIme;
    private EditText etOsobaPrezime;
    private Button btnAddOsoba;
    private Button btnLookupOsoba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();
    }

    private void initWidgets() {
        etOsobaID = (EditText) findViewById(R.id.etOsobaID);
        etOsobaID = (EditText) findViewById(R.id.etOsobaIme);
        etOsobaID = (EditText) findViewById(R.id.etOsobaPrezime);
        btnAddOsoba = (Button) findViewById(R.id.btnAddOsoba);
        btnLookupOsoba = (Button) findViewById(R.id.btnLookupOsoba);
    }

    private void setupListeners() {
        btnAddOsoba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDBHandler myDBHandler = new MyDBHandler(getApplicationContext(), null, null, 1);
                String osobaIme = etOsobaIme.getText().toString();
                String osobaPrezime = etOsobaPrezime.getText().toString();
                Osoba osoba = new Osoba(osobaIme, osobaPrezime);
                myDBHandler.addOsoba(osoba);
                // TODO: 22.6.2016. Dodati metodu za dodavanje na listu RecyclerView-a
                etOsobaIme.setText("");
                etOsobaPrezime.setText("");
            }
        });
        btnLookupOsoba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDBHandler myDBHandler = new MyDBHandler(getApplicationContext(), null, null, 1);
                String osobaIme = etOsobaIme.getText().toString();
                Osoba osoba = myDBHandler.findOsoba(osobaIme);
                if (osoba != null) {
                    etOsobaID.setText(String.valueOf(osoba.get_id()));
                    etOsobaPrezime.setText(String.valueOf(osoba.get_prezime()));
                    // TODO: 22.6.2016. Dodati metodu za dodavanje na listu RecyclerView-a umjesto pisanja po EditTextovima
                } else {
                    etOsobaID.setText("No match found");
                }
            }
        });
    }
}
