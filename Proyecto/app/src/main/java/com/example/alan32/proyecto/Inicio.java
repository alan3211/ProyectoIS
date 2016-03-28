package com.example.alan32.proyecto;
/*Importando  las librerias de andorid necesarias*/

import android.app.*;
import android.content.Intent;
import android.os.*;
import android.view.View;
import android.widget.*;

public class Inicio extends Activity implements View.OnClickListener {

    private TextView mensaje;
    private TextView nombre;
    private EditText cajanombre;
    private Button iniciar;

    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_inicio);
        enlaza(); /*En este metodo  se enlazan los componentes con los xml*/
    }

    private void enlaza() {
        mensaje = (TextView) findViewById(R.id.xmensaje);
        nombre = (TextView) findViewById(R.id.xnombre);
        cajanombre = (EditText) findViewById(R.id.xcaja);
        iniciar = (Button) findViewById(R.id.xiniciar);
        iniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nombre = cajanombre.getText().toString();
            if (nombre.equals("")) {
                Toast toat = Toast.makeText(getApplicationContext(), "Ingresa tu nombre", Toast.LENGTH_LONG);
                toat.show();
            } else {
                Toast toat = Toast.makeText(getApplicationContext(), "Iniciando aplicación", Toast.LENGTH_LONG);
                toat.show();
                Intent nvo = new Intent(Inicio.this, Prince.class);
                Bundle bun = new Bundle();
                bun.putString("Nombre", cajanombre.getText().toString());
                nvo.putExtras(bun);
                startActivity(nvo);
            }
    }
}
