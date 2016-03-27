package com.example.alan32.proyecto;
/*Importando  las librerias de andorid necesarias*/

import android.app.*;
import android.os.*;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

public class Inicio extends Activity implements View.OnClickListener{

    private TextView mensaje;
    private Button iniciar;
    ImageView imagen;

    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_inicio);
        enlaza(); /*En este metodo  se enlazan los componentes con los xml*/
    }

    private void enlaza(){
        mensaje = (TextView)findViewById(R.id.xmensaje);
        iniciar = (Button)findViewById(R.id.xiniciar);
        imagen = (ImageView)findViewById(R.id.ximagen);
        iniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.xiniciar:   Toast toat = Toast.makeText(getApplicationContext(),"Iniciando aplicación",Toast.LENGTH_LONG);
                                              toat.show();
                                              break;
            case R.id.ximagen:
                                                Animation mizoom = AnimationUtils.loadAnimation(this,R.anim.acercar);
                                                mizoom.reset();
                                                imagen.startAnimation(mizoom);
                                                break;
        }
    }
}
