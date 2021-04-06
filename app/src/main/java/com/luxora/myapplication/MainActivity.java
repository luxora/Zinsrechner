package com.luxora.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // prüfe Button Click im ersten View Starten Button:
        Button startenbutton = (Button) findViewById(R.id.startenbutton);
        startenbutton.setOnClickListener ( new View.OnClickListener(){
                 @Override

            public void onClick (View view) {

                     // erfasse Dateneingaben:

                     // erfasse: Anzahl der Zeiträume:
                     EditText anzahl_zeitraeume_inputfield = (EditText) findViewById(R.id.jav_input);
                     String anzahl_zeitraeume_string = anzahl_zeitraeume_inputfield.getText().toString();
                    showtoast(anzahl_zeitraeume_string);

                     // erfasse Meldedatum:
                     EditText meldedatum_inputfield = (EditText) findViewById(R.id.meldedatum_input);
                     String meldedatum_string = meldedatum_inputfield.getText().toString();
                    showtoast(meldedatum_string);

                     // prüfe Checkbox Anpassung über 01.07.:
                     CheckBox anpassung_cb = (CheckBox) findViewById(R.id.checkbox_anpassung);

                     if (anpassung_cb.isChecked())
                     {
                         Toast.makeText(getApplicationContext(),"Zeiträume über dem 01.07. werden angepasst...",Toast.LENGTH_LONG).show();
                     }

                     // öffne Eingabe der Zeiträume: von bis und JAV MDE
                     openZeitraeumeActivity ();
                 }
        });

    }

    public void showtoast (String toaststring)
    {
        Toast.makeText(getApplicationContext(),toaststring,Toast.LENGTH_SHORT).show();
    }
    public void openZeitraeumeActivity() {
        Intent intent = new Intent(this, zinszeitraeume.class);
        startActivity(intent);
    }
}