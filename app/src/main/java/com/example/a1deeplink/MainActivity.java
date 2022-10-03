package com.example.a1deeplink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDeepLink();

    }

    private void showDeepLink(){
        // Lấy ra đường dẫn uri mà khi click từ ngoài app
        // test url : http://www.abc.com?id=1
        Intent intent = getIntent();
        Uri uri = intent.getData();
        // Handle logic
        String id;
        if(uri != null && uri.toString().contains("=")){
            String getID[] = uri.toString().trim().split("=");
            id = getID[1].trim();
            if(id.equals("1")){
                startActivity(new Intent(this,SecondAct.class));
                finish();
            }else{
                Toast.makeText(this, "ID = "+id+" không phải ID = 1", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        showDeepLink();
        Log.e("HiepPD","onNewIntent");

    }


}