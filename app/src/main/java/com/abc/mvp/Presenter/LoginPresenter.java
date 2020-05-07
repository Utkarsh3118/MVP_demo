package com.abc.mvp.Presenter;

import com.abc.mvp.Model.User;
import com.abc.mvp.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {

        User user = new User(email,password);
        int LoginCode = user.isValidate();

        if (LoginCode == 0)
            loginView.onLoginError("Email field can't be empty");
        else if (LoginCode == 1)
            loginView.onLoginError("You must enter valid email");
        else if (LoginCode == 2)
            loginView.onLoginError("Password should be of more than 6 characters");
        else
            loginView.onLoginSuccess("Logged in Successfully");
    }
}
