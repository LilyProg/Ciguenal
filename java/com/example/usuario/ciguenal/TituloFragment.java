package com.example.usuario.ciguenal;

import android.app.Activity;
import android.app.AliasActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by usuario on 24/03/2018.
 */

public class TituloFragment extends ListFragment {

    OnTituloSelectedListener mCallBack;

    public interface OnTituloSelectedListener{
        public void onTituloSelected(int position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_titulo,container,false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.support_simple_spinner_dropdown_item,
                contenido.Titulos));
    }

    @Override
    public void onStart(){
        super.onStart();
        if(getFragmentManager().findFragmentById(R.id.container) !=null){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        try{
            Activity activity = (Activity) context;
            mCallBack = (OnTituloSelectedListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString()+
            "debe implementar el mètodo onTituloSelectedListener");
        }
    }

    @Override
    public void onListItemClick(ListView listView,View view, int position, long id){
        mCallBack.onTituloSelected(position);
        getListView().setItemChecked(position,true);
    }
}












































