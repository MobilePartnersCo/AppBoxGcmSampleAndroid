package kr.co.mobpa.appboxGcm.sdkSample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kr.co.mobpa.appBoxGcmSDK.AppBoxGcm

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
        // AppBoxGcm Token 저장
        // --------------------------------------------------------------
        AppBoxGcm.getInstance().savePushToken(
            pushYn = true
        )
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBoxGcm 앱박스 푸시 체크 & 푸시 생성(파이어베이스 메시지 사용시)
        // --------------------------------------------------------------
        AppBoxGcm.getInstance().isAppBoxPush(
            context = this@MainActivityKotlin,
            remoteMessage = null,
            isNotificationCreate = false
        )
        // --------------------------------------------------------------

    }
}