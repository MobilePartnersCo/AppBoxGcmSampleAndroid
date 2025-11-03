package kr.co.mobpa.appboxGcm.sdkSample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kr.co.mobpa.appBoxGcmSDK.AppBoxGcm
import kr.co.mobpa.appBoxGcmSDK.component.processor.AppBoxGcmCallback
import kr.co.mobpa.appBoxGcmSDK.component.processor.AppBoxGcmResult

class MainActivityKotlin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // --------------------------------------------------------------
        // AppBoxGcm Token 가져오기
        // --------------------------------------------------------------
        Log.d("AppBoxGcmKotlin", "getPushToken : ${AppBoxGcm.getInstance().getPushToken()}")
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBoxGcm Token 저장(수동)
        // --------------------------------------------------------------
        AppBoxGcm.getInstance().savePushToken(
            token = "token",
            pushYn = true,
            callback = object : AppBoxGcmResult<String> {
                override fun onSuccess(result: String) {

                }

                override fun onFailure(errorMessage: String) {

                }
            }
        )
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBoxGcm Token 저장(자동)
        // --------------------------------------------------------------
        AppBoxGcm.getInstance().savePushToken(
            pushYn = true,
            callback = object : AppBoxGcmResult<String> {
                override fun onSuccess(result: String) {

                }

                override fun onFailure(errorMessage: String) {

                }
            }
        )
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBoxGcm Token 가져오기
        // --------------------------------------------------------------
        AppBoxGcm.getInstance().getPushToken()
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBoxGcm 세그먼트 저장
        // --------------------------------------------------------------
        AppBoxGcm.getInstance()
            .saveSegment(
                hashMap = hashMapOf(Pair("key", "value")),
                callback = object : AppBoxGcmCallback {
                    override fun onSuccess() {

                    }

                    override fun onFailure(errorMessage: String) {

                    }
                })
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBoxGcm 전환코드 저장
        // --------------------------------------------------------------
        AppBoxGcm.getInstance()
            .trackingConversion(
                conversionCode = "conversionCode",
                callback = object : AppBoxGcmCallback {
                    override fun onSuccess() {

                    }

                    override fun onFailure(errorMessage: String) {

                    }
                })
        // --------------------------------------------------------------

    }
}