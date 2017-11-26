package com.xiang.androidmail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendMailTool.setHtml(new String[]{"840182754@qq.com"},null,null);
            }
        });

    }
}
