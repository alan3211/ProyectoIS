package com.example.alan32.proyecto;

/*Importando  las librerias de andorid necesarias*/
import android.app.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.*;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

public class Prince extends Activity implements View.OnClickListener{

    private TextView mensaje;
    private Button cargar;
    private ImageView imgview;

    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_prince);
        enlaza(); /*En este metodo  se enlazan los componentes con los xml*/
    }

    private void enlaza(){
        mensaje = (TextView)findViewById(R.id.xmensaje);
        Bundle bun = this.getIntent().getExtras();
        mensaje.append(" "+bun.getString("Nombre"));
        cargar = (Button)findViewById(R.id.xcarga);
        imgview = (ImageView)findViewById(R.id.ximagen);
        imgview.setOnClickListener(this);
        cargar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
           switch(v.getId()){
               case R.id.ximagen:       Animation anima = AnimationUtils.loadAnimation(this,R.anim.acercar);
                                                       anima.reset();
                                                       imgview.startAnimation(anima);
                                                        break;
               case R.id.xcarga:    final CharSequence[] opciones= {"Elige imagen","Cancelar"};
                                                 AlertDialog.Builder builder = new AlertDialog.Builder(Prince.this);
                                                builder.setTitle("Elige una opción");
                                                builder.setItems(opciones, new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int seleccion) {
                                                        if (opciones[seleccion] == "Elige imagen") {
                                                            Intent in = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                                            in.setType("image/*");
                                                            startActivityForResult(in.createChooser(in, "Selecciona una imagen"), 200);
                                                        } else if (opciones[seleccion] == "Cancelar") {
                                                            dialog.dismiss();
                                                        }
                                                    }
                                                });
                                                builder.show();
                                                break;

           }

    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
                if(requestCode == RESULT_OK){
                        Uri path = data.getData();
                        imgview.setImageURI(path);
                }
    }
}
