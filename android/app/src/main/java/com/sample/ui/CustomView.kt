package com.sample.ui

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.ReactContext
import com.facebook.react.uimanager.events.RCTEventEmitter
import com.sample.R

/**
 * Created by mmpkl05 on 12/14/17.
 */
class CustomView(private val context: Context, message: String) : LinearLayout(context) {
    private var message = "NOT SET"

    init {
        this.message = message
        init()
    }

    fun init() {
        //Part 1: Don't need to copy BONUS part, this alone already integrate Android UI to RN native.
        inflate(context, R.layout.multiplecamerastreamlayout, this)
        //This can be viewed in Android Studio's Log Cat.
        Log.i("Inflated XML", "ANDROID_SAMPLE_UI")

        //BONUS: Create a button that writes a toast.
        val clickButton = findViewById<View>(R.id.multipleCameraButton) as Button
        val _context = context
        clickButton.setOnClickListener {
            //Log into the Logcat of android studio. Filter by Info and ANDROID_SAMPLE_UI.
            Log.i("Button get clicked", "ANDROID_SAMPLE_UI")
            val toast = Toast.makeText(_context, message, Toast.LENGTH_LONG)
            toast.show()

            //PART 3: This is a sample to receive callback/events from Android to RN's JS and visa versa.
            //Save to remove if don't need to care events sent
            callNativeEvent()
            //END OF PART 3
        }
    }

    fun setMessage(message: String) {
        this.message = message
    }

    //PART 3: Added Receive Event.
    fun callNativeEvent() {
        Log.i("Call Native Event", "ANDROID_SAMPLE_UI")
        //This output a message to Javascript as an event.
        val event = Arguments.createMap()
        event.putString("customNativeEventMessage", "Emitted an event") //Emmitting an event to Javascript

        //Create a listener where that emits/send the text to JS when action is taken.
        val reactContext = getContext() as ReactContext
        reactContext.getJSModule(RCTEventEmitter::class.java).receiveEvent(
                id,
                "nativeClick",  //name has to be same as getExportedCustomDirectEventTypeConstants in MyCustomReactViewManager
                event)
    }
}
