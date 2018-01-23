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
