package com.example.qq.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qq.AccountData;
import com.example.qq.AccountMatch;
import com.example.qq.R;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class Login extends AppCompatActivity {

    EditText accountId;
    EditText accountPassword;
    Button btnLogin;
    Button btnReset;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Connector.getDatabase();

        //隐藏状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //隐藏状态栏
        /*View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
*/
        accountId = (EditText)findViewById(R.id.account_id);
        accountPassword = (EditText)findViewById(R.id.account_password);

        btnLogin = (Button)findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginId = accountId.getText().toString();
                String loginPassword = accountPassword.getText().toString();

                if(!AccountMatch.isThereAccount(loginId)){
                    Toast.makeText(Login.this,"Not found Account",Toast.LENGTH_SHORT).show();
                    accountId.setText("");
                    accountPassword.setText("");
                }else if(!AccountMatch.isPasswordRight(loginId, loginPassword)){
                    Toast.makeText(Login.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                    accountPassword.setText("");
                }else{
                    Toast.makeText(Login.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this , Main.class);
                    startActivity(intent);
                }
            }
        });

        btnReset = (Button)findViewById(R.id.btn_reset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this , Reset.class);
                startActivity(intent);
            }
        });

        btnRegister = (Button)findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this , Register.class);
                startActivity(intent);
            }
        });
    }
}
