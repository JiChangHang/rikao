package com.bawei.day5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jch on 2017/9/1.
 */

public class MainActivity2 extends AppCompatActivity {

    private MyCustom myCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        myCustom = (MyCustom) findViewById(R.id.mycustom2);
        myCustom.setOnButClickListener(new MyCustom.OnButClickListener() {
            @Override
            public void onButClick() {


                finish();

            }
        });
    }
}
