package com.luxora.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.leistung_combo);
        // Create an ArrayAdapter using the string array and a default spinner layout
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.leistungsart_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
                spinner.setAdapter(adapter);


        Button hinweise_button = (Button) findViewById(R.id.hinweise_button);
        hinweise_button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View viewer)
            {
                showtoast("Hinweise Button");
                showalertbox("Fälligkeitshinweise", "" +
                        "Fälligkeit von VG gem. § 46 (1) SGB VII: \n" +
                        "\nMit der AU Feststellung durch den Arzt vorausgehendem Tag\n" +
                        "\n" +
                        "Fälligkeit von Rente gem. § 96 SGB VII: \n" +
                        "\nEnde des Monats, für den die Leistung beansprucht wird \n" +
                        "\nBsp: Rente für März 2021 - Fällig am 31.03.2021");
            }
        });




        // prüfe Button Click im ersten View Starten Button:
        Button startenbutton = (Button) findViewById(R.id.starten_button);
        startenbutton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override

            public void onClick(View view) {

                // erfasse Dateneingaben:

                // erfasse: Fälligkeit:
                EditText faelligkeit_inputfield = (EditText) findViewById(R.id.faelligkeit_input);
                String faelligkeit_string = faelligkeit_inputfield.getText().toString();

                // erfasse Meldedatum:
                EditText meldedatum_inputfield = (EditText) findViewById(R.id.meldedatum_input);
                String meldedatum_string = meldedatum_inputfield.getText().toString();

                // a) Berechne Ablauf eines Monats nach Fälligkeit (vgl. § 44 (1) SGB I):

               /* Date faelligkeitsdate = new Date(faelligkeit_string);
                DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.GERMANY);
               try {
                   df.parse(faelligkeit_string);
               }
               catch (Exception dateparsingexy)
               {
                   showtoast("Datum konnte nicht geparsed werden, Exception on line 83 MainActivity.java");
               }*/

                Date dt = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(faelligkeit_string);

                // dt.setTime();


                showtoast("Time in string:" + dt.toString()); // ok.
                showtoast("Time2 in string:" + simpleDateFormat.toString()); // TODO wird nicht erkannt.

                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                c.add(Calendar.DATE, 1); // einen Monat hinzuzählen...
                dt = c.getTime();
                //System.out.println("Tomorrow: "+dt.toString());
                showtoast("Ergebnis der Zeitaddition:" + dt.toString());

                /*
                Date dt2 = new Date();
                System.out.println("Today:    " + dt);
                Instant instant = dt2.toInstant();
                Instant nextDay = instant.plus(1, ChronoUnit.MONTHS);
                System.out.println("Tomorrow: " + nextDay);
                */




                // b) Berechne Ablauf der Frist von sechs Monaten nach Eingang des Leistungsantrages:


                // Ermittlung des späteren Zeitraums von a) oder b):



                // späterer Zeitpunkt = Verzinsungbeginn:


                // Ende der Verzinsung berechnen:
                // bis zum Ende des Kalendermonats vor der Zahlung / Auszahlung verzinsen:


                // Berechne Höhe der Verzinsung:

                // Fällige Geldleistungen werden mit 4 % verzinst (§ 44 Abs. 1 SGB I):

                // nur volle Euro-Beträge (§ 44 Abs. 3 Satz 1 SGB I):


                //  Zinsmonat wird mit 30 Tagen angesetzt (§ 44 Abs. 3 Satz 2 SGB I).



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
    public void showalertbox (String titletext, String alterttext)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle(titletext);
        alertDialog.setMessage(alterttext);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

    }
    public void openZeitraeumeActivity() {
        Intent intent = new Intent(this, zinszeitraeume.class);
        startActivity(intent);
    }

}