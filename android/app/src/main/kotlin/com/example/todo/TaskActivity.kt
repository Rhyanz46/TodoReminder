package com.example.todo

import io.flutter.embedding.android.FlutterActivity
import android.util.Log
import android.os.Bundle

class TaskActivity: FlutterActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v("TEST", "masuk TaskActivity");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task)
    }
}
