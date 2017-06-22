package eus.urbieta.network;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.Arrays;

public class ReadSMSExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_smsexample);

        ListView smsList = (ListView) findViewById(R.id.sms_list);

        Cursor cursor = getContentResolver().query(Uri.parse("content://sms/"), null, null, null, null );

        Log.println( Log.ASSERT, "SMS Columns", Arrays.asList( cursor.getColumnNames() ).toString() );

        String[] columns = new String[]{
                cursor.getColumnName(2),
                cursor.getColumnName(12)
        };

        SimpleCursorAdapter simpleCursorAdapter =
                new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2,
                        cursor, columns, new int[]{android.R.id.text1, android.R.id.text2}, 0);
        smsList.setAdapter(simpleCursorAdapter);
    }
}
