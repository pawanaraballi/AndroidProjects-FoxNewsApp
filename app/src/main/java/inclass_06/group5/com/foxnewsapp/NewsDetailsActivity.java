package inclass_06.group5.com.foxnewsapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by pawan on 2/22/2016.
 */

public class NewsDetailsActivity extends AppCompatActivity {
    final static String ArrayList_Key = "KEY";
    TextView title, description,publicationDate;
    ImageView imageView;
    ProgressDialog imagedialog;
    final static String CLICKED_LINK = "CLICKEDLINK";
    //ArrayList<News> newsArrayList;
    String link,titledata,des,thumbnail,pubdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        if (getIntent().getExtras() != null){
            link = getIntent().getExtras().getString(GetData.CLICKED_LINK);
            titledata = getIntent().getExtras().getString(GetData.CLICKED_TITLE);
            des = getIntent().getExtras().getString(GetData.CLICKED_DES);
            thumbnail = getIntent().getExtras().getString(GetData.CLICKED_IMAGE);
            pubdate = getIntent().getExtras().getString(GetData.CLICKED_PUB);

        }

        imagedialog = new ProgressDialog(this);
        imagedialog.setMessage("Loading Image");
        imagedialog.setCancelable(false);

        title = (TextView) findViewById(R.id.textView_title);
        publicationDate = (TextView) findViewById(R.id.textView_publicationDate);
        description = (TextView) findViewById(R.id.textView_description);
        imageView = (ImageView) findViewById(R.id.imageView);

        title.setText(titledata);
        publicationDate.setText(pubdate);
        new GetImage().execute(thumbnail);
        description.setText(des);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsDetailsActivity.this, NewsWebViewActivity.class);
                intent.putExtra(CLICKED_LINK, link);
                startActivity(intent);
            }
        });
    }

    //ASYNC task to get images
    class GetImage extends AsyncTask<String, Void, Bitmap> {
        Bitmap image = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            imagedialog.show();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(image);
            imagedialog.dismiss();
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            InputStream inputStream = null;
            String urlDisplay = urls[0];
            try {
                inputStream = new java.net.URL(urlDisplay).openStream();
                image = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return image;
        }
    }
}
