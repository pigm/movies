package com.cencosud.frameworks.loginv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.cencosud.frameworks.commonsv1.Config;
import com.cencosud.login.presentation.activity.WizardActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);


        //ENCRYPT CONFIGURATIONS
        Config.setEncrypSecretKey("$jqCOYvLC@2>Oq1856UOFyDTEOW1U4IhrPR");

        //API CONFIGURATIONS
        Config.setApiKey("64Q5gHBkM6xjGOPjmhlXMPm06o1ZuBq5");
        Config.setApiBaseUrl("https://api.smdigital.cl:8443/v0/cl/jumbo90/");

        //CMS API CONFIGURATIONS
        Config.setApiCmsBaseUrl("http://api.smdigital.cl:8000/co/jumbo/");
        Config.setCmsApiKey("ZxNyQXEdPwSLWZ8Zrni7rXkjek8L26Co");
        Config.setCmsContentBaseUrl("http://content4u.smdigital.cl/");

        startActivity(new Intent(this, WizardActivity.class));
    }
}
