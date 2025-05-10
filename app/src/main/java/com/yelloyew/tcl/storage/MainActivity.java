package com.yelloyew.tcl.storage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

    @SuppressLint("QueryPermissionsNeeded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            try {
                Intent intent = new Intent(Settings.ACTION_INTERNAL_STORAGE_SETTINGS);
                if (getPackageManager().resolveActivity(intent, 0) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, getString(R.string.not_found_activity), Toast.LENGTH_SHORT).show();
                    Log.e("QuickSleep", "Not found sleep timer option");
                }
            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                Log.e("QuickSleep", "Error send intent", e);
            }
        }

        finish();
    }
}
