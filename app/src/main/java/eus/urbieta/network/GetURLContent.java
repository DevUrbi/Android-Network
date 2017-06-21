package eus.urbieta.network;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GetURLContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView webView = new WebView( this);
        setContentView( webView );
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled( true );
        webView.loadUrl("https://kutxabank.es");
    }
}
