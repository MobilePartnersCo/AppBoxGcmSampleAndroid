package kr.co.mobpa.appboxGcm.sdkSample

import android.app.Application
import android.util.Log
import kr.co.mobpa.appBoxGcmSDK.AppBoxGcm
import kr.co.mobpa.appBoxGcmSDK.component.processor.AppBoxGcmFunctionResult
import kr.co.mobpa.appBoxGcmSDK.component.processor.AppBoxGcmNotificationResult

class MainApplicationKotlin : Application() {
    override fun onCreate() {
        super.onCreate()

        // --------------------------------------------------------------
        // AppBoxGcm 초기화
        // --------------------------------------------------------------
        AppBoxGcm.getInstance().initSDK(
            context = this,
            projectId = "AYX-371110",
            isAutoTokenSave = true,
            debugMode = true,
            pushIcon = R.drawable.ic_launcher_background,
            callback = object : AppBoxGcmFunctionResult {
                override fun onResult(success: Boolean, message: String) {
                    Log.d("AppBoxGcmKotlin", "message : ${message}")
                }
            }
        )
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBoxGcm 푸시 클릭
        // --------------------------------------------------------------
        AppBoxGcm.getInstance().notificationResult = object : AppBoxGcmNotificationResult {
            override fun onClick(param: String) {
                Log.d("AppBoxGcmKotlin", "param : ${param}")
            }
        }
        // --------------------------------------------------------------
    }
}