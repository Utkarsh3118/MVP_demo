package com.abc.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abc.mvp.Presenter.ILoginPresenter;
import com.abc.mvp.Presenter.LoginPresenter;
import com.abc.mvp.View.ILoginView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements ILoginView {

    ILoginPresenter loginPresenter;
    private EditText etEmail,etPassword;
    private Button LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
        loginPresenter = new LoginPresenter(this);


        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(etEmail.getText().toString(),etPassword.getText().toString());
            }
        });

    }

    private void initializeView() {
     etEmail = findViewById(R.id.etEmail);
     etPassword = findViewById(R.id.etPassword);
     LoginButton = findViewById(R.id.LoginButton);
    }


    @Override
    public void onLoginError(String message) {
        Toasty.error(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show();
    }
}
