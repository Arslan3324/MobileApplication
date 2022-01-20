package com.example.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {
    private EditText editText;
    private Button buttonOK;
    public interface FragmentListener{
        void onInputASent(charSequence input);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_a,container,false);
        editText=v.findViewById(R.id.edit_text);
        buttonOK=v.findViewById(R.id.button_ok);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input=editText.getText();

            }
        });
        return v;
    }
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof FragmentListener)
            listener = (FragmentAListener) context;
    }
}
