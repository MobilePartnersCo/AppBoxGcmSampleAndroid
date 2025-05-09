package kr.co.mobpa.appboxGcm.sdkSample

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kr.co.mobpa.appBoxGcmSDK.AppBoxGcm

class FirebaseMessagingServiceKotlin : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        // --------------------------------------------------------------
        // AppBoxGcm 푸시인지 체크
        // 기존 Firebase를 사용중일때 isAppBoxPush를 사용하여 푸시를 생성
        // --------------------------------------------------------------
        if (AppBoxGcm.getInstance().isAppBoxPush(this, remoteMessage)) {
            return
        }

    }
}