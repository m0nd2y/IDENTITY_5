package com.example.macbook.ifhackthon;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class second extends AppCompatActivity {
    Intent intent;
    SpeechRecognizer mRecognizer;
    private WebView mWebView;
    TextView textView;
    TextView ko;
    TextView bu;
    TextView lo;
    ImageView imageview = null;
    private final int MY_PERMISSIONS_RECORD_AUDIO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_second);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.RECORD_AUDIO)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.RECORD_AUDIO}, MY_PERMISSIONS_RECORD_AUDIO
                );
            }
        }

        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getPackageName());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR");

        mRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        mRecognizer.setRecognitionListener(recognitionListener);


        textView = (TextView) findViewById(R.id.tv);
        TextView button = (TextView) findViewById(R.id.button1);
        TextView home = (TextView) findViewById(R.id.gohome);
        mWebView = (WebView) findViewById(R.id.mvebview);
        final ImageView rabbit = (ImageView) findViewById(R.id.imageView3);
        ko = (TextView) findViewById(R.id.kor);
        lo = (TextView) findViewById(R.id.longtext);
        bu = (TextView) findViewById(R.id.buck);
        imageview = (ImageView) findViewById(R.id.down);
        final ScrollView scrollview = ((ScrollView) findViewById(R.id.scroll));

        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(rabbit);
        Glide.with(this).load(R.drawable.recordgif).into(gifImage);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ko.setText("");
                bu.setText("");
                lo.setText("");
                mWebView.clearView();
                mWebView.clearCache(true);
                mWebView.clearHistory();
                mWebView.loadUrl("about:blank");
                textView.setText("인식중");
                imageview.setImageResource(R.drawable.blank);
                mRecognizer.startListening(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(second.this,MainActivity.class);
                startActivity(intent);
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

    }

    private RecognitionListener recognitionListener = new RecognitionListener() {
        @Override
        public void onReadyForSpeech(Bundle bundle) {
        }

        @Override
        public void onBeginningOfSpeech() {
        }

        @Override
        public void onRmsChanged(float v) {
        }

        @Override
        public void onBufferReceived(byte[] bytes) {
        }

        @Override
        public void onEndOfSpeech() {
        }

        @Override
        public void onError(int i) {
            textView.setText("너무 늦게 말했어요..");
        }

        @Override
        public void onResults(Bundle bundle) {
            String key = "";
            key = SpeechRecognizer.RESULTS_RECOGNITION;
            ArrayList<String> mResult = bundle.getStringArrayList(key);

            String[] rs = new String[mResult.size()];
            mResult.toArray(rs);

            textView.setText(rs[0]);
            database(rs[0]);
            imageview.setImageResource(R.drawable.downbutton);

        }

        @Override
        public void onPartialResults(Bundle bundle) {
        }

        @Override
        public void onEvent(int i, Bundle bundle) {
        }
    };

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
        else if (str.contains("flag")) {
            ko.setText("flag????");
            bu.setText("www.google.com");
            lo.setText("here you flag");
        }
        else {
            ko.setText("error");
            bu.setText("error");
            lo.setText("존재하지 않는 단어입니다.");
            mWebView.loadUrl("https://ko.wikipedia.org/wiki/"+str);
        }
    }
}