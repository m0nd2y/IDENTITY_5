package com.example.macbook.ifhackthon;

import android.content.Intent;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView ko;
    TextView bu;
    TextView lo;
    EditText text;
    ImageView imageview = null;

    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.mWevView);
        TextView button1 = (TextView) findViewById(R.id.button1);
        TextView button2 = (TextView) findViewById(R.id.button2);
        TextView button3 = (TextView) findViewById(R.id.button3);
        imageview = (ImageView) findViewById(R.id.down);
        ko = (TextView) findViewById(R.id.kor);
        lo = (TextView) findViewById(R.id.longtext);
        bu = (TextView) findViewById(R.id.buck);

        text =(EditText)findViewById(R.id.editText);
        final ScrollView scrollview = ((ScrollView) findViewById(R.id.scroll));

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        third.class); // 다음 넘어갈 클래스 지정
                startActivity(intent); // 다음 화면으로 넘어간다
                Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent2);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        second.class); // 다음 넘어갈 클래스 지정
                startActivity(intent); // 다음 화면으로 넘어간다
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = text.getText().toString();
                imageview.setImageResource(R.drawable.downbutton);
                database(value);
            }
        });
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollview.post(new Runnable() {
                    @Override public void run() {
                        scrollview.smoothScrollBy(0, 950);
                    }
                });
            }
        });

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });


    }

    public void database(String str) {
        if (str.contains("도시락")) {
            ko.setText("도시락");
            bu.setText("곽밥");
            lo.setText("점심밥을 담는, 고리버들이나 대오리로 길고 둥글게 결은 작은 그릇.");
        }
        else if (str.contains("태양열")) {
            ko.setText("태양열");
            bu.setText("해빛열");
            lo.setText("태양에서 나와 지구에 도달하는 열. 대기나 구름에 의한 흡수와 산란 따위로 지구 표면에 도달하는 열의 양은 실제 태양이 내는 열에 비하여 매우 적다.");
        }
        else if (str.contains("필통")) {
            ko.setText("필통");
            bu.setText("필갑통");
            lo.setText("붓이나 필기구 따위를 꽂아 두는 통.");
        }
        else if (str.contains("터널")) {
            ko.setText("터널");
            bu.setText("차굴");
            lo.setText("차를 세워 두도록 마련한 곳.");
        }
        else if (str.contains("헬리콥터")) {
            ko.setText("헬리콥터");
            bu.setText("직승비행기");
            lo.setText("회전 날개를 기관으로 돌려서 생기는 양력(揚力)과 추진력으로 나는 항공기. 수직 이착륙과 공중 정지가 가능하며, 회전 날개가 각도를 조정하여 전진ㆍ후진ㆍ횡진할 수 있다.");
        }
        else if (str.contains("스님")) {
            ko.setText("스님");
            bu.setText("중선생");
            lo.setText("승려가 자신의 스승을 이르는 말.");
        }
        else if (str.contains("공무원")) {
            ko.setText("공무원");
            bu.setText("정무원");
            lo.setText("국가 또는 지방 공공 단체의 사무를 맡아보는 사람. 사무 범위에 따라 국가 공무원과 지방 공무원으로 나누며, 선임 및 근무 방법에 따라 일반직과 별정직으로 나눈다.");
        }
        else if (str.contains("수면제")) {
            ko.setText("수면제");
            bu.setText("잠약");
            lo.setText("잠이 들게 하는 약.");
        }
        else if (str.contains("버튼")) {
            ko.setText("버튼");
            bu.setText("자동단추");
            lo.setText("찰현 악기의 몸통 최하단에 있는 핀. 줄을 감아 매는 역할을 한다.");
        }
        else if (str.contains("원피스")) {
            ko.setText("원피스");
            bu.setText("외동옷");
            lo.setText("윗옷과 아래옷이 붙어서 한 벌로 된 옷. 주로 여성복에 많다.");
        }
        else if (str.contains("개기 월식")) {
            ko.setText("개기 월식");
            bu.setText("옹근월식");
            lo.setText("달이 지구의 그림자에 완전히 가려 태양 빛을 받지 못하고 어둡게 보이는 현상.");
        }
        else if (str.contains("TRUST")) {
            Intent intent1 = new Intent(
                    getApplicationContext(), // 현재 화면의 제어권자
                    hacking.class); // 다음 넘어갈 클래스 지정
            startActivity(intent1); // 다음 화면으로 넘어간다
        }
        else if (str.contains("trust")) {
            Intent intent1 = new Intent(
                    getApplicationContext(), // 현재 화면의 제어권자
                    secondhacking.class); // 다음 넘어갈 클래스 지정
            startActivity(intent1); // 다음 화면으로 넘어간다
        }
        else if (str.contains("flag")) {
            ko.setText("flag???");
            bu.setText("bit.ly/2VZSlns");
            lo.setText("here you are flag, but it is not at all (grin)");
        }
        else {
            lo.setText("you can’t get chocolate at valentine’s day");
        }
    }



}