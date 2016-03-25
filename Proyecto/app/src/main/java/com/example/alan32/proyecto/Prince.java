package com.example.alan32.proyecto;

/*Importando  las librerias de andorid necesarias*/
import android.app.*;
import android.os.*;
import android.widget.*;

public class Prince extends Activity{

    private TextView mensaje;

    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_prince);
        enlaza(); /*En este metodo  se enlazan los componentes con los xml*/
    }

    private void enlaza(){
        mensaje = (TextView)findViewById(R.id.xmensaje);
    }
}
