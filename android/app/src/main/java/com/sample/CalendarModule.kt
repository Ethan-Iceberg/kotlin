package com.sample

import android.util.Log
import android.widget.Toast
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod


// replace com.your-app-name with your app’s name


class CalendarModule internal constructor(context: ReactApplicationContext?) : ReactContextBaseJavaModule(context){

    // add to CalendarModule.java
    override fun getName(): String {
        return "CalendarModule"
    }

    @ReactMethod
    fun createCalendarEvent(name: String, location: String) {
        Log.d("CalendarModule", "Create event called with name: " + name
                + " and location: " + location)
        Toast.makeText(reactApplicationContext, name, Toast.LENGTH_SHORT).show()
    }
}