package com.example.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentA extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    TextView tv;
    Button btn;
    CheckBox bt1,bt2,bt3,bt4,bt5;
    private String mParam1,result="";

    public static FragmentA newInstance(String param1) {
        FragmentA fragment = new FragmentA();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_a, container, false);
        tv=v.findViewById(R.id.tv);
        bt1=v.findViewById(R.id.checkBox);
        bt2=v.findViewById(R.id.checkBox2);
        bt3=v.findViewById(R.id.checkBox3);
        bt4=v.findViewById(R.id.checkBox4);
        bt5=v.findViewById(R.id.checkBox5);
        btn=v.findViewById(R.id.Fragment1Button);
        tv.setText("Welcome in Course Reg : "+mParam1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "Roll Number - " + mParam1;

                if (bt1.isChecked())
                    result += "\n" + "Registered In App Dev Course";

                if (bt2.isChecked())
                    result += "\n" + "Registered In Machine Learning Course";

                if (bt3.isChecked())
                    result += "\n" + "Registered In Artificial Intelligence Course";

                if (bt4.isChecked())
                    result += "\n" + "Registered In Data Mining Course";

                if (bt5.isChecked())
                    result += "\n" + "Registered In Robotics Course";

                ((MainActivity)getActivity()).addFragmentb(result);
            }
        });

        return  v;
    }
}