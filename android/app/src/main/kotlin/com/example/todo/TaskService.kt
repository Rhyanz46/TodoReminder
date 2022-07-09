package com.example.todo

import android.app.IntentService
import android.content.Intent
import android.util.Log

class TaskService: IntentService("TaskService"){
    override fun onHandleIntent(workIntent: Intent?) {
        Log.v("TEST", "masuk TaskService");
    }
}
