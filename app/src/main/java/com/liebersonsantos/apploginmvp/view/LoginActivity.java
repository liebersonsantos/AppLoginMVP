package com.liebersonsantos.apploginmvp.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.liebersonsantos.apploginmvp.R;
import com.liebersonsantos.apploginmvp.contract.Contract;
import com.liebersonsantos.apploginmvp.presenter.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements Contract.View{

    @BindView(R.id.text_user_name)
    TextInputEditText textUserName;
    @BindView(R.id.text_password)
    TextInputEditText textPassword;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private Contract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new Presenter(this);

    }

    @OnClick(R.id.button_login)
    void login(){
        presenter.validateLogin(textUserName.getText().toString(), textPassword.getText().toString());
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {
        textUserName.setError("Usuário inválido");
    }

    @Override
    public void setPasswordError() {
        textPassword.setError("Senha inválida");
    }

    @Override
    public void navigateToHome() {
        Toast.makeText(this, "Login realizado com sucesso", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void goMainActivity() {
//        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//        startActivity(intent);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
