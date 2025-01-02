package com.sample.ui

import android.util.Log
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

/**
 * Created by mmpkl05 on 12/14/17.
 */
class MyCustomReactViewManager : SimpleViewManager<CustomView?>() {
    private val message = "NOT SET"
    override fun getName(): String {
        return REACT_CLASS
    }

    public override fun createViewInstance(context: ThemedReactContext): CustomView {
        Log.i("Create View Instance", "ANDROID_SAMPLE_UI")
        return CustomView(context, message) //If your customview has more constructor parameters pass it from here.
    }

    @ReactProp(name = "message")
    fun setMessage(view: CustomView, message: String?) {
        Log.i("Set Message", "ANDROID_SAMPLE_UI")
        view.setMessage(message!!)
    }

    //PART 3: Added Receive Event.
    override fun getExportedCustomDirectEventTypeConstants(): Map<String, Any>? {
        //For frequent updates like on change or movement, read about getExportedCustomBubblingEventTypeConstants
        Log.i("Register Native Click", "ANDROID_SAMPLE_UI")
        return MapBuilder.builder<String, Any>()
                .put("nativeClick",  //Same as name registered with receiveEvent
                        MapBuilder.of("registrationName", "onClick"))
                .build()
    }

    companion object {
        const val REACT_CLASS = "MyCustomReactViewManager"
    }
}
