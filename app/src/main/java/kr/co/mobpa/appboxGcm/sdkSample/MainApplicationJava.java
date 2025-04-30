package kr.co.mobpa.appboxGcm.sdkSample;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import kr.co.mobpa.appBoxGcmSDK.AppBoxGcm;
import kr.co.mobpa.appBoxGcmSDK.component.processor.AppBoxGcmNotificationResult;

public class MainApplicationJava extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // --------------------------------------------------------------
        // AppBoxGcm 초기화
        // --------------------------------------------------------------
        AppBoxGcm.getInstance().initSDK(
                this,
                "PROJECT_ID",
                true,
                true,
                R.drawable.ic_launcher_background
        );
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBoxGcm 푸시 클릭
        // --------------------------------------------------------------
        AppBoxGcm.getInstance().setNotificationResult(new AppBoxGcmNotificationResult() {
            @Override
            public void onClick(@NonNull String param) {
                Log.d("AppBoxGcmJava", "param : " + param);
            }
        });
        // --------------------------------------------------------------
    }
}
