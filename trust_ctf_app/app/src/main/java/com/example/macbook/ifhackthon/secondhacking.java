package com.example.macbook.ifhackthon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class secondhacking  extends AppCompatActivity {
    TextView output;
    EditText input;
    Button button;
    String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hacking);
        input = (EditText) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = input.getText().toString();
                byte[] targetBytes = text.getBytes();
                Base64.Decoder decoder = Base64.getDecoder();
                byte[] decodedBytes = decoder.decode(targetBytes);
                String tmp = "";
                try {
                    tmp = new String(decodedBytes, "UTF-8");
                } catch (UnsupportedEncodingException e) {

                }
                output.setText(tmp);
                flag = "this is fourth flag : https://bit.ly/2Hz3XL1";
                flag = "total : five gadgets";
            }
        });
    }
}