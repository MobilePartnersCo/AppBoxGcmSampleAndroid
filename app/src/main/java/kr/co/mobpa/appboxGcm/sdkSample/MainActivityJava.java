package kr.co.mobpa.appboxGcm.sdkSample;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import kr.co.mobpa.appBoxGcmSDK.AppBoxGcm;
import kr.co.mobpa.appBoxGcmSDK.component.processor.AppBoxGcmSegmentResult;
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
        // AppBoxGcm 세그먼트 저장
        // --------------------------------------------------------------
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("A", "AA");
        AppBoxGcm.getInstance().saveSegment(hashMap, new AppBoxGcmSegmentResult() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onFailure(@Nullable String s) {

            }
        });
        // --------------------------------------------------------------

    }

}
