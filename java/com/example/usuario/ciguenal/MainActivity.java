package com.example.usuario.ciguenal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements TituloFragment.OnTituloSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.container)!=null){
            if (savedInstanceState == null){
                TituloFragment tituloFragment = new TituloFragment();
                tituloFragment.setArguments(getIntent().getExtras());
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container, tituloFragment)
                        .addToBackStack(null)
                        .commit();
            }
        }
    }

    @Override
    public void onTituloSelected(int position) {
        ParrafoFragment parrafoFragment = (ParrafoFragment)
                getSupportFragmentManager().findFragmentById(R.id.fgm_container);
        if (parrafoFragment != null){
            parrafoFragment.updateParrafoView(position);
        }else{
            //se lanza el fragmento
            ParrafoFragment parrafo = new ParrafoFragment();
            Bundle args = new Bundle();
            args.putInt(ParrafoFragment.ARG_POSITION,position);
            parrafo.setArguments(args);
            //esto resume las lineas de transaction
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fgm_container,parrafo)
                    .addToBackStack(null)
                    .commit();
        }
    }

}

