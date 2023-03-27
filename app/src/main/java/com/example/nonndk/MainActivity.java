package com.example.nonndk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.appcenter.distribute.Distribute;

import java.text.SimpleDateFormat;
import java.util.Date;

//non ndk, only test the AppCenter Crashes feature.
public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE="com.example.NonNDK.Message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCenter.start(getApplication(), "161b6c0c-23d1-4375-991e-2e8c71dd3aaf", Analytics.class, Crashes.class, Distribute.class);
AppCenter.setLogLevel(Log.VERBOSE);
        setContentView(R.layout.activity_main);

    }
    public void sendMessage(View view){

        SimpleDateFormat sdf=new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
        Date d=new Date();
        Analytics.trackEvent("First event: button is clicked at "+sdf.format(d));

Intent intent=new Intent(this,DisplayMessageActivity.class);
        EditText editText=(EditText)findViewById(R.id.editText);
        String message=editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }
}