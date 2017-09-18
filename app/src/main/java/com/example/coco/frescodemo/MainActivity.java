package com.example.coco.frescodemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {

    private String str="http://p4.so.qhmsg.com/t0123767bc39ed749b9.jpg";
    private SimpleDraweeView draweeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = Uri.parse(str);
        draweeView = (SimpleDraweeView) findViewById(R.id.mSim);
        draweeView.setImageURI(uri);
    }
}
