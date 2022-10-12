package com.example.tablayoutapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    EditText urlBox;
    WebView webView;
    Button back, forward, refresh, cancel;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        urlBox = (EditText) findViewById(R.id.urlBox);
        webView = (WebView) findViewById(R.id.webView);
        back = (Button) findViewById(R.id.back);
        forward = (Button) findViewById(R.id.forward);
        refresh = (Button) findViewById(R.id.refresh);
        cancel = (Button) findViewById(R.id.cancel);
        progress = (ProgressBar) findViewById(R.id.progress);

        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());

        back.setOnKeyListener((v, keyCode, event) -> {

            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                Intent intent = new Intent(urlBox.getText().toString());
                startActivity(intent);
            } else {
                return false;
            }

            return true;

        });


            //go to previous page
            back.setOnClickListener(v -> {
            if (webView.canGoBack()) {
                webView.goBack();
            }
        });

            //go to next page
            forward.setOnClickListener(v -> {
            if (webView.canGoForward()) {
                webView.goForward();
            }
        });

            //reload page
            refresh.setOnClickListener(v -> webView.reload());

            //cancel loading page
            cancel.setOnClickListener(v -> webView.stopLoading());
        }


        public class webViewClient extends WebViewClient {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        }

        public class webChromeClient extends WebChromeClient {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progress.setProgress(newProgress);
                urlBox.setText(view.getUrl());

                if (newProgress == 100) {
                    cancel.setVisibility(View.GONE);
                    progress.setVisibility(View.GONE);


                } else {
                    cancel.setVisibility(View.VISIBLE);
                    progress.setVisibility(View.VISIBLE);

                }
            }
        }
    }


