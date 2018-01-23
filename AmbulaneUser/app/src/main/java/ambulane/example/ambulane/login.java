package ambulane.example.ambulane;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }






    public IBinder onBind(Intent intent) {
        return null;
    }
    public void goToActivity3 (View view){
        Log.d("inside", "3");
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
    public void goToActivity1 (View view){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

}