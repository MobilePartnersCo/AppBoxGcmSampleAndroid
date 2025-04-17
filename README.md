![AppBox 데모](images/AppboxVisual.jpg)

# AppBoxGcm SDK 사용 샘플소스
[![Custom Badge](https://img.shields.io/badge/JitPack-1.0.0-green.svg)](https://jitpack.io)
[![API](https://img.shields.io/badge/API-28%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=28)

- AppBox 푸시알림 SDK는 모바일 웹사이트를 앱으로 패키징하여 최소한의 개발로 푸시알림 기능을 사용할 수 있는 솔루션입니다.
- AppBox 푸시알림 SDK는 앱박스 홈페이지의 [푸시 전용 콘솔](https://appboxapp.com/console/launchpad)을 활용하여 푸시알림 서비스를 사용할 수 있습니다.
- 푸시 전용 콘솔을 이용하여 테스트 발송, 예약 발송 등 다양한 푸시 기능을 사용하실 수 있습니다.


---

## 라이선스

- 앱박스 푸시알림 SDK는 기업 및 개인이 상업적 목적으로 사용할 수 있습니다.
  본 SDK의 사용 및 일부 기능은 앱박수 푸시 콘솔을 통한 구독 등급에 따라 제한되거나 유료로 제공될 수 있습니다.
  자세한 라이선스 및 이용 조건은 [공식문서](https://appboxapp.com/policy/terms/push)를 확인해 주세요.

---

## 개발자 메뉴얼

- **메뉴얼**: [https://www.appboxapp.com/guide/dev](https://www.appboxapp.com/guide/dev)

---

## 전체 기능

- 브라우저의 기본기능
- 생체 인증, 탭 메뉴, 브라우저 메뉴, 햄버거 메뉴, 진동 울리기, 로딩 아이콘, 토스트 메시지, 인트로 실행하기
- 플로팅 메뉴, 로컬 푸시, 앱 평가, 달력 실행, 팝업 실행하기, 이미지 뷰어, 외부 페이지 열기
- 바코드 리더기 실행하기, QR 팝업 실행하기, 바코드 팝업 실행하기, 업데이트 실행, 다른 앱 실행하기
- QR 리더기 실행하기, 공유하기, 앱 종료, 위치를 받아옴, 전화걸기, 문자보내기, 걸음수, 푸시 토큰 등록, API 실행하기 다양한 기능을 사용할 수 있습니다.

---

## 설치 방법

AppBox SDK는 [JitPack](https://jitpack.io) 저장소를 통해 제공됩니다. 아래 단계를 따라 프로젝트에 SDK를 통합하세요.

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
    implementation("com.github.MobilePartnersCo:AppBoxSDKPackage:gcm-v0.0.13")

}
```

---

## 사용법

### 1. SDK 초기화

AppBox SDK를 사용하려면 먼저 초기화를 수행해야 합니다. initSDK 메서드를 호출하여 초기화를 완료하세요.

#### 예제 코드:

```
// AppBoxGcm 초기화
AppBoxGcm.getInstance().initSDK(
   context = this,
   projectId = "PROJECT_ID",
   isAutoTokenSave = true,
   debugMode = false,
   pushIcon = R.drawable.ic_launcher_background,
   callback = object : AppBoxGcmFunctionResult {
       override fun onResult(success: Boolean, message: String) {
           
       }
   }
)
```

---

### 2. 추가 기능 설정

AppBox SDK 실행 전 추가 기능이 설정이 되어야 적용이 됩니다.

#### 푸시 클릭 콜백

푸시 클릭 콜백

```
// AppBoxGcm 푸시 클릭 콜백
 AppBoxGcm.getInstance().notificationResult = object : AppBoxGcmNotificationResult {
   override fun onClick(param: String) {
       
   }
}
```

#### 토큰 가져오기

FCM 토큰 가져오기

```
// AppBoxGcm 토큰 가져오기
AppBoxGcm.getInstance().getPushToken()
```

#### 토큰 저장하기

FCM 토큰 저장하기

```
// AppBoxGcm 토큰 저장하기
AppBoxGcm.getInstance().savePushToken(
   pushYn = true,
   callback = object : AppBoxGcmFunctionResult {
       override fun onResult(success: Boolean, message: String) {
           Log.d("AppBoxGcmKotlin", "message : ${message}")
       }
   }
)
```

#### AppBoxGcm 푸시 체크 & 푸시 생성

푸시 체크 & 푸시 생성

```
// AppBoxGcm 푸시 체크 & 푸시 생성
AppBoxGcm.getInstance().isAppBoxPush(
   context = this@MainActivityKotlin,
   remoteMessage = null,
   isNotificationCreate = false
)
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
    - INTERNET 권한 추가
    - allowBackup, fullBackupContent 값을 false로 설정

```
      <uses-permission android:name="android.permission.INTERNET" />

      <application
        android:allowBackup="false"
        android:fullBackupContent="false">
      </application>
```


---

## 지원

문제가 발생하거나 추가 지원이 필요한 경우 아래로 연락하세요:

- **이메일**: [contact@mobpa.co.kr](mailto:contact@mobpa.co.kr)
- **홈페이지**: [https://www.appboxapp.com](https://www.appboxapp.com)

---
