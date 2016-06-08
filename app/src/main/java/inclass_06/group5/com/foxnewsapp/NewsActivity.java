package inclass_06.group5.com.foxnewsapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * Created by pawan on 2/22/2016.
 */

public class NewsActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        if (getIntent().getExtras() != null){
            url = getIntent().getExtras().getString(MainActivity.WEB_KEY);
        }
        new GetData(this).execute(url);



        //make a for loop for each title
        //add each title to the linear layout with linearLayout.addView(textView_title1);

    }
}
