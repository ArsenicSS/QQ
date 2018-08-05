package com.example.qq.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qq.AccountData;
import com.example.qq.AccountMatch;
import com.example.qq.R;

import org.litepal.crud.DataSupport;

import java.util.List;

public class Reset extends AppCompatActivity {

    EditText resetAccountId;
    EditText resetAccountPassword;
    EditText repeatResetAccountPassword;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset);

        resetAccountId = (EditText)findViewById(R.id.reset_id);
        resetAccountPassword = (EditText)findViewById(R.id.reset_password);
        repeatResetAccountPassword = (EditText)findViewById(R.id.repeat_reset_password);

        btnReset = (Button)findViewById(R.id.btn_reset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginId = resetAccountId.getText().toString();
                String loginPassword = resetAccountPassword.getText().toString();
                String repeatLoginPassword = repeatResetAccountPassword.getText().toString();

                if(!AccountMatch.isThereAccount(loginId)){
                    Toast.makeText(Reset.this,"Not found Account",Toast.LENGTH_SHORT).show();
                    resetAccountId.setText("");
                    resetAccountPassword.setText("");
                    repeatResetAccountPassword.setText("");
                }else if(!loginPassword.equals(repeatLoginPassword)){
                    Toast.makeText(Reset.this,"两次密码不一致",Toast.LENGTH_SHORT).show();
                    resetAccountPassword.setText("");
                    repeatResetAccountPassword.setText("");
                }else{
                    AccountData accountData = new AccountData();
                    accountData.setAccountPassword(loginPassword);
                    accountData.updateAll("accountId == ?" , loginId);

                    Toast.makeText(Reset.this,"Reset Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Reset.this , Main.class);
                    startActivity(intent);
                }
            }
        });

    }

}
