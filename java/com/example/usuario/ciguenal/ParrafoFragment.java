package com.example.usuario.ciguenal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by usuario on 24/03/2018.
 */

public class ParrafoFragment extends Fragment {

    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_parrafo,container,false);
    }

    public void updateParrafoView (int position){
        TextView textView = (TextView)getActivity()
                .findViewById(R.id.txt_parrafo);
        textView.setText(contenido.Parrafos[position]);

        mCurrentPosition = position;
    }

    @Override
    public void onStart(){
        super.onStart();
        Bundle args = getArguments();
        if (args != null){
            updateParrafoView(args.getInt(ARG_POSITION));
        }else if (mCurrentPosition != -1){
            updateParrafoView(mCurrentPosition);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION,mCurrentPosition);
    }

}

























