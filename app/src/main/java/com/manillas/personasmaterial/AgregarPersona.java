package com.manillas.personasmaterial;


import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Random;

public class AgregarPersona extends AppCompatActivity {
    private EditText txtCedula, txtNombre, txtApellido;
    private Spinner cmbSexo;
    private String opc[];
    private ArrayList<Integer> fotos;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);
        txtCedula = findViewById(R.id.txtCedula);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        cmbSexo = findViewById(R.id.cmbSexo);
        foto = findViewById(R.id.foto);
        fotos = new ArrayList<>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);
        opc = getResources().getStringArray(R.array.sexo);

    }

    public int fotoAleatoria(){
        int fotoSel;
        Random r = new Random();
        fotoSel = r.nextInt(this.fotos.size());
        return fotos.get(fotoSel);
    }

    public void guardar(View v){
        String ced, nom, ape;
        int foto, sexo;
        foto = this.fotoAleatoria();
        ced = txtCedula.getText().toString();
        nom = txtNombre.getText().toString();
        ape = txtApellido.getText().toString();
        sexo = cmbSexo.getSelectedItemPosition();
        Persona p = new Persona(foto,ced,nom,ape, sexo);
        p.guardar();
        limpiar();
        Snackbar.make(v, getResources().getString(R.string.guardado_exito), Snackbar.LENGTH_SHORT).show();

    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(AgregarPersona.this, Principal.class);
        startActivity(i);
    }
    public void limpiar(){
        txtCedula.setText("");
        txtNombre.setText("");
        txtCedula.setText("");
        txtCedula.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void limpiar(View v){
        limpiar();
    }
}
