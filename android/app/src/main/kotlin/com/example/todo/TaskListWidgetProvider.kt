package com.example.todo

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.util.Log
import android.widget.RemoteViews
import android.app.PendingIntent
import es.antonborri.home_widget.HomeWidgetBackgroundIntent
import es.antonborri.home_widget.HomeWidgetLaunchIntent
import es.antonborri.home_widget.HomeWidgetProvider

import android.os.Build

class TaskListWidgetProvider : HomeWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray, widgetData: SharedPreferences) {
        appWidgetIds.forEach { widgetId ->
            val views = RemoteViews(context.packageName, R.layout.task_list).apply {

                // Open App on Widget Click
                val pendingIntent = HomeWidgetLaunchIntent.getActivity(
                    context,
                    MainActivity::class.java
                )
                setOnClickPendingIntent(R.id.widget_root, pendingIntent)

                val counter = widgetData.getInt("_counter", 0)
                Log.v("TEST", "sampe sini");

                var counterText = "Arian!!!, Your counter value is: $counter"

                if (counter == 0) {
                    counterText = "You have not pressed the counter button"
                }

                setTextViewText(R.id.tv_counter, counterText)
                Log.v("cobaaaa", "jumlah $counter");

                // Pending intent to update counter on button click
                val backgroundIntent = HomeWidgetBackgroundIntent.getBroadcast(context,
                        Uri.parse("myWidget://updatecounter"))

                // var flags = PendingIntent.FLAG_UPDATE_CURRENT
                // if (Build.VERSION.SDK_INT >= 23) {
                //     flags = flags or PendingIntent.FLAG_IMMUTABLE
                // }
                // val intent = Intent(context, TaskActivity::class.java)
                // val intent = Intent(context, TaskService::class.java)
                // val taskpendingIntent = PendingIntent.getService(context, 0, intent, flags)
                setOnClickPendingIntent(R.id.bt_update, backgroundIntent)
            }
            
            appWidgetManager.updateAppWidget(widgetId, views)
        }
    }
}