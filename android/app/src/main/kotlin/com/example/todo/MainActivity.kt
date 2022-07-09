package com.example.todo

import io.flutter.embedding.android.FlutterActivity
import android.util.Log
import android.os.Bundle

class MainActivity: FlutterActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v("TEST", "masuk MainActivity");
        super.onCreate(savedInstanceState)
    }
}
