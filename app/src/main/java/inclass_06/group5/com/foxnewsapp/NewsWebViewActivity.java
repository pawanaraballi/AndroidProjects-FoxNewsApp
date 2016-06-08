package inclass_06.group5.com.foxnewsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by pawan on 2/22/2016.
 */

public class NewsWebViewActivity extends AppCompatActivity {
    final static String Web_Key = "KEY";
    String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_web_view);

        if (getIntent().getExtras() != null){
            link = getIntent().getExtras().getString(GetData.CLICKED_LINK);
        }

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl(link);
    }
}
