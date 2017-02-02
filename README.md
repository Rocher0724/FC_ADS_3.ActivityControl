# FC_ADS_3.ActivityControl
패스트캠퍼스 안드로이드 스튜디오, 프로젝트 3 Activity 활용

# ActivityControl
Activity 라이프사이클 및 컴포넌트 다루기

## Activity LifeCycle

onCreate() -> onStart() -> onResume() -> Running(러닝은 상태없음) -> onPause() -> onStop() -> [onRestart()] onDestroy()

## Activity 호출하기

### 일반적인 호출
```java
    Intent intent = new Intent(this, ClassName.class);
    startActivity(intent)
```

### Activity 호출 후 값 다시 받기
* 호출하는 Activity
```java
    // 호출하는 측의 특정 위치를 구분하기 위한 상수
    public static final int REQ_CODE = 99;

    // 액티비티를 호출하는 함수
    public void callActivity(){
        Intent intent = new Intent(this, ClassName.class);
        startActivityForResult(intent, REQ_CODE);
    }

    // 호출되는 Activity 에서 사용되는 함수
    // requestCode = 호출측 구분 값
    // resultCode = 호출되는 측에서 처리결과를 알려주기 위해 정의된 값
    // intent = 결과 값
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){

    }
```

* 호출되는 Activity
```java
    // 처리 결과코드 상수정의
    public static final int RESULT_OK = 0;
    public static final int RESULT_FAIL = 1;

    // 처리 완료 후 호출하는 함수
    private void callResult(){
        Intent intent = new Intent();
        intent.putExtra("result", " 처리된 값 ");

        // setResult 함수가 호출한 Activity의 onActivityResult 함수를 자동으로 호출한다.
        setResult(RESULT_OK, intent);

        // finish() 를 호출하여 현재 Activity 를 닫는다.
    }
```
