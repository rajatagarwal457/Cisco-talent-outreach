<<<<<<< HEAD
package com.ambulane.driver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToActivity3 (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
=======
package com.ambulane.driver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToActivity3 (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
>>>>>>> 76c10b4b0a8129cada86eb3e78ad559335656ccc
