package com.example.alan32.proyecto;

/*Importando  las librerias de andorid necesarias*/
import android.app.*;
import android.content.Intent;
import android.net.Uri;
import android.os.*;
import android.view.View;
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
        //cargar = (Button)findViewById(R.id.xcarga);
        //imgview = (ImageView)findViewById(R.id.ximagen);
        cargar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Prince.this);
            Intent in = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            in.setType("image/*");
            startActivityForResult(in.createChooser(in, "Selecciona una imagen"), 200);
            builder.show();
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
