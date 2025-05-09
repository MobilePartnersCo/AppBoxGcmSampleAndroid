package kr.co.mobpa.appboxGcm.sdkSample;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import kr.co.mobpa.appBoxGcmSDK.AppBoxGcm;

public class FirebaseMessagingServiceJava extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        // --------------------------------------------------------------
        // AppBoxGcm 푸시인지 체크
        // 기존 Firebase를 사용중일때 isAppBoxPush를 사용하여 푸시를 생성
        // --------------------------------------------------------------
        if (AppBoxGcm.getInstance().isAppBoxPush(this, remoteMessage)) {
            return;
        }

    }
}
