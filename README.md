![AppBox 데모](images/AppboxVisual.jpg)

# AppBoxGcm SDK 사용 샘플소스
[![Custom Badge](https://img.shields.io/badge/JitPack-1.0.0-green.svg)](https://jitpack.io)
[![API](https://img.shields.io/badge/API-28%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=28)

- AppBox SDK는 모바일 웹사이트를 앱으로 패키징하여 최소한의 개발로 구글 플레이 및 앱스토어에 등록할 수 있는 솔루션입니다.
- 앱박스는 모바일 웹사이트에서 자바스크립트 코드를 사용해서 앱의 기능을 사용할 수 있게 하는 솔루션으로 아래 40여가지 기능을 무료로 사용가능합니다.
- SDK 형태로 제공되어 도메인만 입력하면 기본 브라우져 기능부터 간편히 사용 가능합니다.

---

## 라이선스

- 앱박스의 SDK의 사용은 영구적으로 무료입니다. 기업 또는 개인 상업적인 목적으로 사용 할 수 있습니다.

---

## 개발자 메뉴얼

- **메뉴얼**: [https://www.appboxapp.com/guide/dev](https://www.appboxapp.com/guide/dev)

---

## 데모앱 다운로드

- GooglePlay : https://play.google.com/store/apps/details?id=kr.co.mobpa.appbox
- AppStore : https://apps.apple.com/kr/app/id6737824370

---

## 전체 기능

- 브라우저의 기본기능
- 생체 인증, 탭 메뉴, 브라우저 메뉴, 햄버거 메뉴, 진동 울리기, 로딩 아이콘, 토스트 메시지, 인트로 실행하기
- 플로팅 메뉴, 로컬 푸시, 앱 평가, 달력 실행, 팝업 실행하기, 이미지 뷰어, 외부 페이지 열기
- 바코드 리더기 실행하기, QR 팝업 실행하기, 바코드 팝업 실행하기, 업데이트 실행, 다른 앱 실행하기
- QR 리더기 실행하기, 공유하기, 앱 종료, 위치를 받아옴, 전화걸기, 문자보내기, 걸음수, 푸시 토큰 등록, API 실행하기 다양한 기능을 사용할 수 있습니다.

---

## 브라우저의 기본기능

- 동영상 플레이어의 전체화면 지원
- KG이니시스, 토스패이먼트, 나이스페이먼츠 등의 PG결제 지원
- 파일 업/다운로드: WebView 내에서 파일 업로드 및 다운로드 지원
- window.open()으로 새창 열기 지원

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
