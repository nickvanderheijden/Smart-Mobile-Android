package com.example.poclayoutnickvanderheijden;

import android.Manifest;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ReportActivity extends AppCompatActivity {
    private Button buttonBack;
    private Button gpsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        buttonBack = (Button)findViewById(R.id.btnBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToHome();
            }
        });

        gpsButton = (Button)findViewById(R.id.btnPos);
        ActivityCompat.requestPermissions(ReportActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);
        gpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GpsTracker g = new GpsTracker(getApplicationContext());
                Location l = g.getLocation();
                if(l != null){
                    double lat = l.getLatitude();
                    double lon = l.getLongitude();
                    Toast.makeText(getApplicationContext(),"LAT:"+lat+"Lon"+lon,Toast.LENGTH_LONG).show();

                }
            }
        });

    }


    public void backToHome(){
       finish();
    }
}
