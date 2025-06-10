![AppBox 데모](images/AppboxVisual.jpg)

# AppBoxGcm SDK 사용 샘플소스
[![Custom Badge](https://img.shields.io/badge/JitPack-1.0.0-green.svg)](https://jitpack.io)
[![API](https://img.shields.io/badge/API-28%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=28)

- AppBoxGcm SDK는 푸시를 간편하게 연동하는 솔루션입니다.
- AppBoxGcm 푸시알림 SDK는 앱박스 홈페이지의 [푸시 전용 콘솔](https://appboxapp.com/console/launchpad)을 활용하여 푸시알림 서비스를 사용할 수 있습니다.
- 푸시 전용 콘솔을 이용하여 테스트 발송, 예약 발송 등 다양한 푸시 기능을 사용하실 수 있습니다.


---

## 라이선스

- 앱박스 푸시알림 SDK는 기업 및 개인이 상업적 목적으로 사용할 수 있습니다.
  본 SDK의 사용 및 일부 기능은 앱박수 푸시 콘솔을 통한 구독 등급에 따라 제한되거나 유료로 제공될 수 있습니다.
  자세한 라이선스 및 이용 조건은 [공식문서](https://appboxapp.com/policy/terms/push)를 확인해 주세요.

---

## 전체 기능

### 푸시 콘솔 페이지를 활용하여 사용할 수 있는 기능

- 테스트 및 예약 발송 기능
- 진동이나 사운드없이 조용한 발송 기능
- 파라미터 및 URL 이동 기능
- 푸시 데이터 발송 통계 제공(OS별 성공/실패/오픈률 집계)
- 푸시 수신 방문율 제공(푸시 오픈 시간 추이 및 발송 시간대별 푸시 오픈률 제공)

---

## 설치 방법

AppBoxGcm SDK는 [JitPack](https://jitpack.io) 저장소를 통해 제공됩니다. 아래 단계를 따라 프로젝트에 SDK를 통합하세요.

### Gradle 설정

#### 1. 프로젝트 수준의 build.gradle 파일 수정

프로젝트의 build.gradle 파일에 JitPack 저장소를 추가합니다.

```
repositories {
    google()
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")

        // SDK 접근 설정
        credentials {
            username = "jp_ku9piga59cvtv8rlos3utncvms"
        }
    }
}
```


#### 2. 앱 수준의 build.gradle 파일에 SDK 의존성 추가

아래 의존성을 추가합니다:

```
dependencies {

    // implementation 선언
    implementation("com.github.MobilePartnersCo:AppBoxSDKPackage:gcm-v1.0.8")

}
```

---

## 사용법

### 1. SDK 초기화

AppBoxGcm SDK를 사용하려면 먼저 초기화를 수행해야 합니다. initSDK 메서드를 호출하여 초기화를 완료하세요.

#### 예제 코드:

```
// AppBoxGcm 초기화
AppBoxGcm.getInstance().initSDK(
   context = this,
   projectId = "PROJECT_ID",
   debugMode = false,
   pushIcon = R.drawable.ic_launcher_background
)
```

---

### 2. 추가 기능 설정

#### 푸시 클릭 콜백

```
// AppBoxGcm 푸시 클릭 콜백
 AppBoxGcm.getInstance().notificationResult = object : AppBoxGcmNotificationResult {
   override fun onClick(param: String) {
       
   }
}
```

#### 토큰 가져오기

```
// AppBoxGcm 토큰 가져오기
AppBoxGcm.getInstance().getPushToken()
```

#### 토큰 저장하기(수동 입력)

```
// AppBoxGcm 토큰 저장하기
AppBoxGcm.getInstance().savePushToken(
   token: String,
   pushYn = true,
   callback = object : AppBoxGcmTokenResult {
       override fun onSuccess(token: String?) {
           
       }
       
       override fun onFailure(error: String?) {
           
       }
   }
)
```

#### 토큰 저장하기(자동 생성 및 입력)

```
// AppBoxGcm 토큰 저장하기
AppBoxGcm.getInstance().savePushToken(
   pushYn = true,
   callback = object : AppBoxGcmTokenResult {
       override fun onSuccess(token: String?) {
           
       }
       
       override fun onFailure(error: String?) {
           
       }
   }
)
```

#### 세그먼트 저장하기

```
// AppBoxGcm 세그먼트 저장하기
AppBoxGcm.getInstance().saveSegment(hashMap = hashMapOf(Pair("A", "AA")), callback = object : AppBoxGcmSegmentResult {
    override fun onFailure(error: String?) {

    }

    override fun onSuccess() {

    }
})
```

---

## 요구 사항

- **Android** 8.0 이상
- **Gradle Version** 8.7

---

## 주의 사항

1. **초기화 필수**
    - initSDK를 호출하여 SDK를 초기화한 후에만 사용할 수 있습니다.
    - 초기화를 수행하지 않으면 실행 시 예외가 발생할 수 있습니다.

2. **AndroidManifest 설정**
    - AndroidManifest.xml 파일에 다음 설정을 확인하세요:
    - allowBackup, fullBackupContent 값을 false로 설정

```
      <application
        android:allowBackup="false"
        android:fullBackupContent="false">
      </application>
```

3. **사용중인 라이브러리 목록**
    - androidx.core:core-ktx:1.13.1
    - androidx.appcompat:appcompat:1.7.0
    - com.google.android.material:material:1.12.0
    - com.google.firebase:firebase-messaging:24.1.1
    - com.google.android.gms:play-services-ads-identifier:18.2.0
    - com.google.code.gson:gson:2.13.1
    - com.github.bumptech.glide:glide:4.16.0

4. **Proguard 설정**
   - Proguard 사용시 코드 추가

```
      -keep class kr.co.mobpa.appBoxGcmSDK.** { *; }
```


---

## 지원

문제가 발생하거나 추가 지원이 필요한 경우 아래로 연락하세요:

- **이메일**: [contact@mobpa.co.kr](mailto:contact@mobpa.co.kr)
- **홈페이지**: [https://www.appboxapp.com](https://www.appboxapp.com)

---
