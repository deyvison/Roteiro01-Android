package com.example.deyvison.roteiro01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle b = getIntent().getExtras();
        String usuario = b.getString("usuario");

        this.mTexto = (TextView)findViewById(R.id.msgView);
        mTexto.setText("Olá "+usuario+" - Seja bem vindo!");


    }
}
