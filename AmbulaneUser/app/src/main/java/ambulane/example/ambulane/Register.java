package ambulane.example.ambulane;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }



    @Nullable

    public IBinder onBind(Intent intent) {
        return null;
    }
    public void goToActivity3 (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
    public void goToActivity2 (View view){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
}