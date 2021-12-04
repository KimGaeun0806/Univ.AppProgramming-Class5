package org.techtown.ap7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 제일 처음 기본 설정은 -> layout_login의 visibility는 visible, layout_success와 layout_failed의 visibility는 gone

    String username = "zico"; // 로그인을 성공시키기 위한 아이디
    String password = "onew"; // 로그인을 성공시키기 위한 비번

    public void bt_login_onClick(View v) {
        EditText et_username = findViewById(R.id.et_username);
        EditText et_password = findViewById(R.id.et_password);

        boolean isLoginSuccessful = true; // 로그인 성공여부

        isLoginSuccessful = username.equals(et_username.getText().toString()); // isLoginSuccessful = username == et_username.getText().toString(); 같이 == 연산자를 쓰는 대신 equals 메소드를 써야 함
        // equals의 경우 username 안에 들어있는 글자들과 et_username의 text attribute의 string 표현 안에 들어있는 글자들이 동일한지 물어보는 것
        // == 의 경우 그 둘이 동일한 string 인스턴스를 각각 담고있는지를 물어보는 것

        if (isLoginSuccessful == true) {
            isLoginSuccessful = password.equals(et_username.getText().toString());
        } // 이런 방식이 아니라 위에서 && 연산자를 써서 username과 password가 같은지 한 번에 처리할 수도 있음

        if (isLoginSuccessful == true) {
            ConstraintLayout layout_login = findViewById(R.id.layout_login);
            ConstraintLayout layout_success = findViewById(R.id.layout_success);

            layout_login.setVisibility(View.GONE); // Gone만 치면 자동완성됨
            layout_success.setVisibility(View.VISIBLE);
        }
        else {
            ConstraintLayout layout_login = findViewById(R.id.layout_login);
            ConstraintLayout layout_failed = findViewById(R.id.layout_failed);

            layout_login.setVisibility(View.GONE);
            layout_failed.setVisibility(View.VISIBLE);
        }
    }
}