package com.example.kt1_congan_hongkhanh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edtxtUsername;
    EditText edtxrPassword;
    AppCompatButton btnLogin;
    TextView txtvSignup;
    CheckBox cbRemember;
    SharedPreferences sharedpreferences;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String USERNAME = "userNameKey";
    public static final String PASS = "passKey";
    public static final String REMEMBER = "remember";
    String userLogin = "hongkhanh";
    String passLogin = "123456";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        initWidgets();//khởi tạo các control
        loadData();//lấy dữ liệu đã lưu nếu có
        //thiết đặt button đăng nhập
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }
    public void login(){
        String email = edtxtUsername.getText().toString();
        String password = edtxrPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            edtxtUsername.setError("Email cannot be empty");
            edtxtUsername.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            edtxrPassword.setError("Password cannot be empty");
            edtxrPassword.requestFocus();
        }else{
            if (cbRemember.isChecked())
                //lưu lại thông tin đăng nhập
                saveData(edtxtUsername.getText().toString(), edtxrPassword.getText().toString());
            else
                clearData();//xóa thông tin đã lưu
            //nếu thông tin đăng nhập đúng thì đến màn hình home
            //if (edtxtUsername.getText().toString().equals(userLogin) && edtxtUsername.getText().toString().equals(passLogin)) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(LoginActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
            //} else
               // Toast.makeText(LoginActivity.this, "Thông tin đăng nhập không đúng", Toast.LENGTH_SHORT).show();
        }
    }
    private void clearData() {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.commit();
    }

    private void saveData(String username, String Pass) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USERNAME, username);
        editor.putString(PASS, Pass);
        editor.putBoolean(REMEMBER,cbRemember.isChecked());
        editor.commit();
    }
    private void loadData() {
        if(sharedpreferences.getBoolean(REMEMBER,false)) {
            edtxtUsername.setText(sharedpreferences.getString(USERNAME, ""));
            edtxrPassword.setText(sharedpreferences.getString(PASS, ""));
            cbRemember.setChecked(true);
        }
        else
            cbRemember.setChecked(false);

    }
    private void initWidgets() {
        edtxtUsername = (EditText) findViewById(R.id.editTextUserName);
        edtxrPassword = (EditText) findViewById(R.id.editTextPass);
        cbRemember = (CheckBox) findViewById(R.id.checkboxLuuMK);
        btnLogin = (AppCompatButton) findViewById(R.id.buttonLogin);
    }

}