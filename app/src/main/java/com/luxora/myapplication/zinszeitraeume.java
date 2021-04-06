package com.luxora.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class zinszeitraeume extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zeitraeume);

        MainActivity main = new MainActivity();



        // PRÜFE clicked Weiter Button:
        Button weiterbutton = (Button) findViewById(R.id.weiter_button);

        weiterbutton.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View v) {
                main.showtoast("Zeitraum von bis,JAV & MdE abfangen...");

                // Felder initialisieren:
                EditText zeitraumvon = (EditText) findViewById(R.id.zeitraum_beginn);
                EditText zeitraumbis = (EditText)  findViewById(R.id.zeitraum_ende);
                EditText javinputfield = (EditText) findViewById(R.id.jav_input);
                EditText mdeinputfield = (EditText) findViewById(R.id.mde_input);
                CheckBox weiterezeitraeumefield = (CheckBox) findViewById(R.id.checkbox_weiterezeitraeume);


                // Strings erstellen - Daten holen:
                String zeitraumvon_string = zeitraumvon.getText().toString();
                String zeitraumbis_string = zeitraumbis.getText().toString();
                String jav1 = javinputfield.getText().toString();
                String mde_input = mdeinputfield.getText().toString();


                if (weiterezeitraeumefield.isSelected() == true)
                {
                    // keine weiteren Eingaben gewünscht, letzte Eingabe true gewählt:


                    // hole Daten aus Zwischenspeicher:


                    // führe Zins-Berechnungen durch:

                }
                else {                      // bleibe in gleicher Acitivity, schreibe in File und warte erneute Eingabe des Users ab:



                }




            }
        });







    }

}
