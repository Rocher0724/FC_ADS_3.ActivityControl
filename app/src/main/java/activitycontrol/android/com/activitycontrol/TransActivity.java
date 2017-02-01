package activitycontrol.android.com.activitycontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TransActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvValue;
    EditText etValue;
    Button btnOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);
        tvValue = (TextView) findViewById(R.id.tvValue);
        etValue = (EditText) findViewById(R.id.etValue);
        btnOk = (Button) findViewById(R.id.btnOk);

        btnOk.setOnClickListener(this);
    }


    /** 텍스트를 입력하고 셀렉티드 버튼을 눌렀을 때 이전 화면으로 돌아가면서 적용됨.
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
//        // 당연히 하는 인텐트 설정
//        Intent intent = new Intent();// 피니시 하면 앞 액티비티에서 호출되도록 설정했기 때문에 괄호안에 아무것도 넣지않는다.
//        //1 . 되돌려 줄 값을 설정
//        String result = etValue.getText().toString();
//        // 2. 처리상태를 결정
//        int statusCode = 1;
//        // 3. 되돌려 줄 값이 문제가 있으면 처리상태 변경
//        if(result == null || result.equals("")) {
//            setResult(0, intent);
//            statusCode = 0;
//        }
//        // 4. 돌려줄 값을 Intent에 세팅
//        intent.putExtra("result", result);
//        // 5. setResult 함수로 결과값 전송
//        setResult(statusCode, result);
//        // 6. 액티비티를 종료하여 메인 엔티비티를 호출
//        finish();

        returnValue();
    }

    @Override
    public void onBackPressed() { // 뒤로가기 키를 눌렀을때 실행되게 할수도 있음.
        returnValue();
        super.onBackPressed();
    }

    public void returnValue() {
        // 당연히 하는 인텐트 설정
        Intent intent = new Intent();// 피니시 하면 앞 액티비티에서 호출되도록 설정했기 때문에 괄호안에 아무것도 넣지않는다.
        //1 . 되돌려 줄 값을 설정
        String result = etValue.getText().toString();
        // 2. 처리상태를 결정
        int statusCode = 1;
        // 3. 되돌려 줄 값이 문제가 있으면 처리상태 변경
        if(result == null || result.equals("")) {
            setResult(0, intent);
            statusCode = 0;
        }
        // 4. 돌려줄 값을 Intent에 세팅
        intent.putExtra("result", result);
        // 5. setResult 함수로 결과값 전송
        setResult(statusCode, intent);
        // 6. 액티비티를 종료하여 메인 엔티비티를 호출
        finish();
    }
}
