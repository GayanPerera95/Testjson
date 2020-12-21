package com.example.testjson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

        Button button;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_main );

            button = findViewById( R.id.btn );
            button.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText( getApplicationContext(),"haii",Toast.LENGTH_SHORT ).show();
                    startActivity( new Intent(MainActivity.this,DisplayList.class) );
                }
            } );
        }
    }
