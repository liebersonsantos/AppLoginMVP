package com.liebersonsantos.apploginmvp.model;

import android.content.Context;
import android.text.TextUtils;

import com.liebersonsantos.apploginmvp.contract.Contract;

public class Login implements Contract.Model {

    private Contract.Presenter presenter;

    public Login(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void login(final String userName, final String password) {

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(userName)){
                    presenter.onUserNameError();
                }
                if (TextUtils.isEmpty(password)){
                    presenter.onPasswordError();
                }

                presenter.onSucess();

            }
        }, 1000);
    }
}