package com.example.nonndk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCenter.start(getApplication(), "6fcb5289-d7e5-4ada-a6d8-6154368ab279", Analytics.class, Crashes.class);
AppCenter.setLogLevel(Log.VERBOSE);

TextView tv=new TextView(this);
tv.setText("Version4, Hello World form backend");
        setContentView(tv);
       Crashes.generateTestCrash();
    }
}