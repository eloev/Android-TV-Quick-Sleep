package com.yelloyew.tcl.sleep

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.tv.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.yelloyew.tcl.sleep.ui.theme.QuickSleepTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuickSleepTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = RectangleShape
                ) {
                    Greeting(
                        "Android",
                        modifier = Modifier.clickable {
                            val intent = Intent("com.android.tv.settings.SLEEP_TIMER")
                            intent.setClassName(
                                "com.android.tv.settings",
                                "com.tcl.android.tv.settings.device.display.SleepTimeActivity"
                            )
                            intent.addCategory(Intent.CATEGORY_DEFAULT)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuickSleepTheme {
        Greeting("Android")
    }
}
