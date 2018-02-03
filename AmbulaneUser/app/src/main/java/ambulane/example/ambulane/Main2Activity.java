<<<<<<< HEAD
package ambulane.example.ambulane;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ambulane.example.ambulane.MapsActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void goToActivity2 (View view){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
}
=======
package ambulane.example.ambulane;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ambulane.example.ambulane.MapsActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void goToActivity2 (View view){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
}
>>>>>>> 76c10b4b0a8129cada86eb3e78ad559335656ccc
