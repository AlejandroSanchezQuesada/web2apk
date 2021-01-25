package com.example.web2apk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView visor;
    String url = "https://www.google.com";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        visor = (WebView) findViewById(R.id.visorWeb);
        visor.setWebViewClient(new WebViewClient());
        getSupportActionBar().hide();
        final WebSettings ajustesVisorWeb = visor.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);
        visor.loadUrl(url);
    }

    //Por defecto al ser un webview, el botón de atrás cerraría la aplicación.
    //Con esta función navegaría hacia atrás de forma correcta
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView miVisorWeb;
        miVisorWeb = (WebView) findViewById(R.id.visorWeb);
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (miVisorWeb.canGoBack()) {
                        miVisorWeb.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}