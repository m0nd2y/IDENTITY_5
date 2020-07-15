package com.example.macbook.ifhackthon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class third  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_third);
        TextView home = (TextView) findViewById(R.id.gohome);
        ImageView imageView = (ImageView) findViewById(R.id.down);
        final ScrollView scrollview = ((ScrollView) findViewById(R.id.scroll));

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(third.this,MainActivity.class);
                startActivity(intent);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollview.post(new Runnable() {
                    @Override public void run() {
                        scrollview.smoothScrollBy(0, 950);
                    }
                });
            }
        });
    }

}
