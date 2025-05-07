package com.yelloyew.tcl.sleep;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

    @SuppressLint("QueryPermissionsNeeded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            try {
                Intent intent = new Intent("com.android.tv.settings.SLEEP_TIMER");
                intent.setClassName(
                        "com.android.tv.settings",
                        "com.tcl.android.tv.settings.device.display.SleepTimeActivity"
                );
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                if (getPackageManager().resolveActivity(intent, 0) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, getString(R.string.not_found_activity), Toast.LENGTH_SHORT).show();
                    Log.e("QuickSleep", "Not found sleep timer option");
                }
            } catch (Exception e) {
                Toast.makeText(this, getString(R.string.error_send_intent), Toast.LENGTH_SHORT).show();
                Log.e("QuickSleep", "Error send intent", e);
            }
        }

        finish();
    }
}
