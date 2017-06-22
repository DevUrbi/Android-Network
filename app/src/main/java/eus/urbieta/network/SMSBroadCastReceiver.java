package eus.urbieta.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SMSBroadCastReceiver extends BroadcastReceiver {

    final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if ( SMS_RECEIVED.equals( intent.getAction() ) ){
            Bundle bundle = intent.getExtras();
            
        }
    }
}
