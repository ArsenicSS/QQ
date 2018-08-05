package com.example.qq.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qq.AccountData;
import com.example.qq.*;

public class Register extends AppCompatActivity {
    EditText register_Id;
    EditText register_Password;
    Button btn_Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        register_Id = (EditText) findViewById(R.id.register_id);
        register_Password = (EditText)findViewById(R.id.register_password);

        btn_Register = findViewById(R.id.btn_register);
        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = register_Id.getText().toString();
                String password = register_Password.getText().toString();

                if(!AccountMatch.isThereAccount(id)){
                    AccountData accountData = new AccountData();
                    accountData.setAccountId(id);
                    accountData.setAccountPassword(password);
                    accountData.save();
                    Toast.makeText(Register.this , "创建成功", Toast.LENGTH_SHORT).show();
                }

                else Toast.makeText(Register.this , "帐户已存在" , Toast.LENGTH_SHORT).show();
            }
        });

    }
}
