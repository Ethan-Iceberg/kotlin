package com.sample.ui

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager
import java.util.Arrays

/**
 * Add this package to getPackages() method in MainActivity.
 */
class MyCustomPackage : ReactPackage {
    override fun createViewManagers(
            reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
        return Arrays.asList<ViewManager<*, *>>(
                MyCustomReactViewManager()
        )
    }

    override fun createNativeModules(
            reactContext: ReactApplicationContext): List<NativeModule> {
        return emptyList()
    }
}
