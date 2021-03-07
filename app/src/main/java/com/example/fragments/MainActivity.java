package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    Button b1;
    EditText editText;
    TextView tv;
    String s;String firstValue;
    FragmentA firstFragment;
    FragmentB secondFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView2);
        b1=findViewById(R.id.button);
        editText=findViewById(R.id.editText);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=editText.getText().toString();
                firstFragment=new FragmentA().newInstance(s);

                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container,firstFragment);
                transaction.commit();
            }
        });
    }

    public void addFragmentb(String s)
    {
        FragmentB firstFragment=new FragmentB().newInstance(s);

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,firstFragment);
        transaction.commit();
    }
}