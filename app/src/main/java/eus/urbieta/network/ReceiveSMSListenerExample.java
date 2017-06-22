package eus.urbieta.network;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.security.Permission;

public class ReceiveSMSListenerExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_smslistener_example);

        if( ! checkPermission(Manifest.permission.RECEIVE_SMS ) ){
            ActivityCompat.requestPermissions( this, new String[]{ Manifest.permission.RECEIVE_SMS }, 0);
        }


    }

    private boolean checkPermission( String permission ){
        return ContextCompat.checkSelfPermission( this, permission ) == PackageManager.PERMISSION_GRANTED;
    }
}
