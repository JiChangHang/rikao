package com.bawei.day5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private MyCustom myCustom;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCustom = (MyCustom) findViewById(R.id.mycuston);
        myCustom.setOnButClickListener(new MyCustom.OnButClickListener() {
            @Override
            public void onButClick() {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}
