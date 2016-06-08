
package inclass_06.group5.com.foxnewsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by pawan on 2/22/2016.
 */
public class MainActivity extends AppCompatActivity {

    final static String WEB_KEY = "WEB";
    static String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //
        TextView textView_mostpopular = (TextView) findViewById(R.id.textView_mostPopular);
        TextView textView_entertainment = (TextView) findViewById(R.id.textView_entertainment);
        TextView textView_health = (TextView) findViewById(R.id.textView_health);
        TextView textView_lifestyle = (TextView) findViewById(R.id.textView_lifestyle);
        TextView textView_opinion = (TextView) findViewById(R.id.textView_opinion);
        TextView textView_politics = (TextView) findViewById(R.id.textView_politics);
        TextView textView_science = (TextView) findViewById(R.id.textView_science);
        TextView textView_sports = (TextView) findViewById(R.id.textView_sport);
        TextView textView_tech = (TextView) findViewById(R.id.textView_tech);
        TextView textView_travel = (TextView) findViewById(R.id.textView_travel);
        TextView textView_US = (TextView) findViewById(R.id.textView_US);

        textView_mostpopular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "http://feeds.foxnews.com/foxnews/most-popular";
                Intent inte = new Intent(MainActivity.this, NewsActivity.class);
                inte.putExtra(WEB_KEY, url);
                startActivity(inte);
            }
        });
        textView_entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "http://feeds.foxnews.com/foxnews/entertainment";
                Intent inte = new Intent(MainActivity.this, NewsActivity.class);
                inte.putExtra(WEB_KEY, url);
                startActivity(inte);
            }
        });
        textView_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "http://feeds.foxnews.com/foxnews/health";
                Intent inte = new Intent(MainActivity.this, NewsActivity.class);
                inte.putExtra(WEB_KEY, url);
                startActivity(inte);
            }
        });
        textView_lifestyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "http://feeds.foxnews.com/foxnews/section/lifestyle";
                Intent inte = new Intent(MainActivity.this, NewsActivity.class);
                inte.putExtra(WEB_KEY, url);
                startActivity(inte);
            }
        });
        textView_opinion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "http://feeds.foxnews.com/foxnews/opinion";
                Intent inte = new Intent(MainActivity.this, NewsActivity.class);
                inte.putExtra(WEB_KEY, url);
                startActivity(inte);
            }
        });
        textView_politics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "http://feeds.foxnews.com/foxnews/politics";
                Intent inte = new Intent(MainActivity.this, NewsActivity.class);
                inte.putExtra(WEB_KEY, url);
                startActivity(inte);
            }
        });
        textView_science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "http://feeds.foxnews.com/foxnews/science";
                Intent inte = new Intent(MainActivity.this, NewsActivity.class);
                inte.putExtra(WEB_KEY, url);
                startActivity(inte);
            }
        });
        textView_sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "http://feeds.foxnews.com/foxnews/sports";
                Intent inte = new Intent(MainActivity.this, NewsActivity.class);
                inte.putExtra(WEB_KEY, url);
                startActivity(inte);
            }
        });
        textView_tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "http://feeds.foxnews.com/foxnews/tech";
                Intent inte = new Intent(MainActivity.this, NewsActivity.class);
                inte.putExtra(WEB_KEY, url);
                startActivity(inte);
            }
        });
        textView_travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "http://feeds.foxnews.com/foxnews/internal/travel/mixed";
                Intent inte = new Intent(MainActivity.this, NewsActivity.class);
                inte.putExtra(WEB_KEY, url);
                startActivity(inte);
            }
        });
        textView_US.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "http://feeds.foxnews.com/foxnews/national";
                Intent inte = new Intent(MainActivity.this, NewsActivity.class);
                inte.putExtra(WEB_KEY, url);
                startActivity(inte);
            }
        });


    }
}