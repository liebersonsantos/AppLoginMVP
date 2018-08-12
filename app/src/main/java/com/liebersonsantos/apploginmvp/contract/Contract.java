package com.liebersonsantos.apploginmvp.contract;

import android.app.Activity;
import android.content.Context;

import com.liebersonsantos.apploginmvp.view.MainActivity;

public class Contract {

    public interface Model{

        void login(String userName, String password);
    }

    public interface View{

        void showProgressBar();
        void hideProgressBar();
        void setUserNameError();
        void setPasswordError();
        void navigateToHome();
        void goMainActivity();
    }

    public interface Presenter{

        void validateLogin(String userName, String password);
        void onDestroy();

        void onUserNameError();
        void onPasswordError();
        void onSucess();
    }
}
