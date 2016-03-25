package com.example.alan32.proyecto;
/*Importando  las librerias de andorid necesarias*/

import android.app.*;
import android.content.Intent;
import android.os.*;
import android.view.View;
import android.widget.*;

public class Inicio extends Activity implements View.OnClickListener{

    private TextView mensaje;
    private Button iniciar;

    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_inicio);
        enlaza(); /*En este metodo  se enlazan los componentes con los xml*/
    }

    private void enlaza(){
        mensaje = (TextView)findViewById(R.id.xmensaje);
        iniciar = (Button)findViewById(R.id.xiniciar);
        iniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent in = new Intent(Inicio.this,Prince.class);
        startActivity(in);
    }
}
