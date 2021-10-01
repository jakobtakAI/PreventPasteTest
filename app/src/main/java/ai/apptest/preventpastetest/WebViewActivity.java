package ai.apptest.preventpastetest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        button = (Button)findViewById(R.id.homeButton);
        button.setOnClickListener(handler);

        webView = (WebView)findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/pasteTest.html");
    }

    // click event handler
    View.OnClickListener handler = new View.OnClickListener(){
        public void onClick(View v) {
            if(v==button){
                Intent intentApp = new Intent(WebViewActivity.this,
                    MainActivity.class);
                WebViewActivity.this.startActivity(intentApp);
            }
        }
    };
}
