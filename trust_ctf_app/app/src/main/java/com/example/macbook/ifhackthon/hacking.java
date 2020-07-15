package com.example.macbook.ifhackthon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;


public class hacking  extends AppCompatActivity {
    TextView output;
    EditText input;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondhacking);
        input = (EditText) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = input.getText().toString();
                byte[] targetBytes = text.getBytes();
                Decoder decoder = Base64.getDecoder();
                byte[] decodedBytes = decoder.decode(targetBytes);
                String tmp = "";
                try {
                    tmp = new String(decodedBytes, "UTF-8");
                } catch (UnsupportedEncodingException e) {

                }
                output.setText(tmp);
            }
        });
    }
}
