package com.example.bohyun.ppd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class Permissions extends AppCompatActivity {
    TextView permissionsPage;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);
        permissionsPage = findViewById(R.id.permissions_id);

        String s = getIntent().getStringExtra("EXTRA_SESSION_ID");
        permissionsPage.setText(s);
    }
}
