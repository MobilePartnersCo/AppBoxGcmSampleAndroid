package kr.co.mobpa.appboxGcm.sdkSample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kr.co.mobpa.appBoxGcmSDK.AppBoxGcm
import kr.co.mobpa.appBoxGcmSDK.component.processor.AppBoxGcmSegmentResult
import kr.co.mobpa.appBoxGcmSDK.component.processor.AppBoxGcmTokenResult

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
            callback = object : AppBoxGcmTokenResult {
                override fun onFailure(error: String?) {

                }

                override fun onSuccess(token: String?) {

                }
            }
        )
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBoxGcm Token 저장(자동)
        // --------------------------------------------------------------
        AppBoxGcm.getInstance().savePushToken(
            pushYn = true,
            callback = object : AppBoxGcmTokenResult {
                override fun onFailure(error: String?) {

                }

                override fun onSuccess(token: String?) {

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
        val hashMap = hashMapOf<String, String>()
        hashMap["A"] = "AAAA"
        hashMap["B"] = "BBBB"
        hashMap["C"] = "CCCC"
        AppBoxGcm.getInstance()
            .saveSegment(hashMap = hashMap, callback = object : AppBoxGcmSegmentResult {
                override fun onFailure(error: String?) {

                }

                override fun onSuccess() {

                }
            })
        // --------------------------------------------------------------

    }
}