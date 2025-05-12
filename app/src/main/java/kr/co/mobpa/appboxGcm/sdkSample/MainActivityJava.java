package kr.co.mobpa.appboxGcm.sdkSample;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import kr.co.mobpa.appBoxGcmSDK.AppBoxGcm;
import kr.co.mobpa.appBoxGcmSDK.component.processor.AppBoxGcmTokenResult;

public class MainActivityJava extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --------------------------------------------------------------
        // AppBoxGcm Token 가져오기
        // --------------------------------------------------------------
        Log.d("AppBoxGcmJava", "getPushToken : " + AppBoxGcm.getInstance().getPushToken());
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBoxGcm Token 저장(수동)
        // --------------------------------------------------------------
        AppBoxGcm.getInstance().savePushToken(
                "token",
                true,
                new AppBoxGcmTokenResult() {
                    @Override
                    public void onSuccess(@Nullable String s) {

                    }

                    @Override
                    public void onFailure(@Nullable String s) {

                    }
                }
        );
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBoxGcm Token 저장(자동)
        // --------------------------------------------------------------
        AppBoxGcm.getInstance().savePushToken(
                true,
                new AppBoxGcmTokenResult() {
                    @Override
                    public void onSuccess(@Nullable String s) {

                    }

                    @Override
                    public void onFailure(@Nullable String s) {

                    }
                }
        );
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBoxGcm Token 가져오기
        // --------------------------------------------------------------
        AppBoxGcm.getInstance().getPushToken();
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBoxGcm 앱박스 푸시 체크 & 푸시 생성(파이어베이스 메시지 사용시)
        // --------------------------------------------------------------
        AppBoxGcm.getInstance().isAppBoxPush(
                this,
                null
        );
        // --------------------------------------------------------------

    }

}
