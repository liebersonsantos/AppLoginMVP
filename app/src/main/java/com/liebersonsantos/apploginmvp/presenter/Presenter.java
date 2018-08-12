package com.liebersonsantos.apploginmvp.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.liebersonsantos.apploginmvp.contract.Contract;
import com.liebersonsantos.apploginmvp.model.Login;
import com.liebersonsantos.apploginmvp.view.MainActivity;

public class Presenter implements Contract.Presenter {

    private Contract.View view;
    private Contract.Model model;

    public Presenter() {
    }

    public Presenter(Contract.View view) {
        this.view = view;
        this.model = new Login(this);
    }

    @Override
    public void validateLogin(String userName, String password) {
        if (view != null){
            view.showProgressBar();
        }

        model.login(userName, password);

    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void onUserNameError() {
        if (view != null){
            view.setUserNameError();
            view.hideProgressBar();
        }

    }

    @Override
    public void onPasswordError() {
        if (view != null){
            view.setPasswordError();
            view.hideProgressBar();
        }

    }

    @Override
    public void onSucess() {
        if (view != null){
            view.navigateToHome();
            view.hideProgressBar();
            view.goMainActivity();
        }
    }
}
