package activitycontrol.android.com.activitycontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private  static final String TAG = "MainActivity";

    public final static int ONE = 1;
    public final static int TWO = 2;

    Button mCommonBtn, mTransBtn1, mTransBtn2;
    TextView mTrans1, mTrans2;
    EditText mEditText;

    Intent intent;

    public MainActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCommonBtn = (Button) findViewById(R.id.commonBtn);
        mTransBtn1 = (Button) findViewById(R.id.transBtn1);
        mTransBtn2 = (Button) findViewById(R.id.transBtn2);
        mEditText = (EditText) findViewById(R.id.mainEditText);
        mTrans1 = (TextView) findViewById(R.id.trans1);
        mTrans2 = (TextView) findViewById(R.id.trans2);

        mTransBtn1.setOnClickListener(new CustomClickListener());
        mTransBtn2.setOnClickListener(new CustomClickListener());
        mCommonBtn.setOnClickListener(new CustomClickListener());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.print("onRestart 시작", TAG);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.print("onStart 시작", TAG);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.print("onResume 시작", TAG);
    }
    // Running



    @Override
    protected void onPause() {
        super.onPause();
        Logger.print("onPause 시작", TAG);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.print("onStop 시작", TAG);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.print("onDestroy 시작", TAG);
    }




    class CustomClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.commonBtn:
                    // # 액티비티로 값넘기기
                    // 1. 인텐트 생성
                    intent = new Intent(MainActivity.this,CommonActivity.class);
                    // 2. putExtra 함수에 전달할 값 설정 "var"는 보내는 키값이다. 받을때 키값으로 받는다.
                    intent.putExtra("var" , mEditText.getText().toString());
                    startActivity(intent);
                    break;
                case R.id.transBtn1:
                    // # 호출한 액티비티로 부터 값을 돌려받을때
                    // 1.
                    intent = new Intent(MainActivity.this, TransActivity.class);

                    // 2. putExtra 함수에 전달할 값 설정
                    intent.putExtra("var" , mEditText.getText().toString());
                    intent.putExtra("varNum" , 33333);

                    // 3. 액티비티 호출
                    startActivityForResult(intent, ONE);
                    break;
                case R.id.transBtn2:
                    // # 호출한 액티비티로 부터 값을 돌려받을때
                    // 1.
                    intent = new Intent(MainActivity.this, TransActivity.class);

                    // 2. putExtra 함수에 전달할 값 설정
                    intent.putExtra("var" , mEditText.getText().toString());
                    intent.putExtra("varNum" , 33333);

                    // 3. 액티비티 호출
                    startActivityForResult(intent, TWO);
                    break;

            }
            // 엑스트라에 담긴 값을 intent를 통해 전달한다.
//            startActivity(intent); //로직을 한줄이라도 줄이기 위한 몸부림
        }
    }


    /** start Activity For Result() 함수로 호출된 액티비티가 종료되면서 호출
     *
     * @param requestCode   호출시에 호출한 액티비티에서 넘긴 구분 값
     * @param resultCode    호출된 액티비티의 상태 코드
     * @param data          호출된 액티비티가 돌려주는 데이터
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        // 처리 상태 코드 체크.
        if(resultCode == 1) {
            // 1. 돌려받은 intent를 꺼내고
            Bundle bundle = intent.getExtras();

            // 2. 호출한 측 코드를 매칭후 값을 처리
            switch (requestCode) {
                case ONE:
                    mTrans1.setText(bundle.getString("result"));
                    break;
                case TWO:
                    mTrans2.setText(bundle.getString("result"));
                    break;
            }
        }
    }
}

