package eus.urbieta.network;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SMSExample extends AppCompatActivity {

    private final int SEND_PERMISSION_REQUEST_CODE = 1;

    private ImageButton mSendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsexample);

        mSendMessage = (ImageButton) findViewById( R.id.send_sms );
        mSendMessage.setEnabled( false );

        if( checkSMSPermission(Manifest.permission.SEND_SMS ) ){
            mSendMessage.setEnabled( true );
        }
    }

    private boolean checkSMSPermission(String permsission) {
        return ActivityCompat.checkSelfPermission( this, permsission ) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch ( requestCode ){
            case SEND_PERMISSION_REQUEST_CODE:
                if ( grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED ){
                    mSendMessage.setEnabled( true );
                }
                return;
        }
    }

    public void sendSms(View view) {
        Log.println( Log.INFO, "", "SendClicked");
        String phoneNumber = ( (EditText) findViewById( R.id.number ) ).getText().toString();
        String message = ( (EditText) findViewById( R.id.message ) ).getText().toString();

        if( phoneNumber == null || phoneNumber.length() == 0 || message == null || message.length() == 0 ){
            return;
        }

        if( checkSMSPermission( Manifest.permission.SEND_SMS ) ){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage( phoneNumber, null, message, null, null );
            Toast.makeText( this, "Messagge SEND", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText( this, "No permission", Toast.LENGTH_LONG ).show();
        }
    }
}
