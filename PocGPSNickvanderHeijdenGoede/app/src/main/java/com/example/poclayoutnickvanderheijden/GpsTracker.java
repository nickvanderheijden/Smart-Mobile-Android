package com.example.poclayoutnickvanderheijden;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by Nick on 23-2-2018.
 */

public class GpsTracker implements LocationListener {
    Context context;
    public  GpsTracker(Context c){
        context = c;
    }
    public Location getLocation(){
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context,"Permission not granted",Toast.LENGTH_LONG).show();
            return null;
        }
        LocationManager lm =(LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        boolean isGPSEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(isGPSEnabled){
          lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,6000,10,this);
          Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
          return l;
        }else{
            Toast.makeText(context,"please accept GPS",Toast.LENGTH_LONG).show();
        }
        return null;
    }
    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
