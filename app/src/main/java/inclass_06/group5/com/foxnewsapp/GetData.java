package inclass_06.group5.com.foxnewsapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by pawan on 2/22/2016.
 */
public class GetData extends AsyncTask<String, Void, ArrayList<News>> {
    ProgressDialog progressDialog;
   //0 Context context;
    NewsActivity newsact;
    final static String CLICKED_DES = "CLICK";
    final static String CLICKED_LINK = "CLICKEDLINK";
    final static String CLICKED_PUB = "CLICKEDPUB";
    final static String CLICKED_IMAGE = "CLICKEDIMAGE";
    final static String CLICKED_TITLE = "CLICKEDDATA";

    public GetData(NewsActivity news) {
        this.newsact = news;
    }

    @Override
    protected ArrayList<News> doInBackground(String... params) {
        Log.d("demo","Inside do in background");
        try {
            Log.d("demo","enter try");
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            Log.d("demo",url.toString());
            int statusCode = connection.getResponseCode();
            Log.d("demo", "Status code" + String.valueOf(statusCode));
            if (statusCode == HttpURLConnection.HTTP_OK) {
                Log.d("demo","Inside http ok");
                InputStream in = connection.getInputStream();
                return NewsUtil.NewsPullParser.parseNews(in);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(newsact);

        progressDialog.setMessage("Loading News");
        progressDialog.show();
        progressDialog.setCancelable(false);

    }

    @Override
    protected void onPostExecute(final ArrayList<News> news) {
        super.onPostExecute(news);
        if(news != null) {
            Log.d("demo", "Data" + news.toString());
        }
        //dynamic layout for scroll view and linear layout
        ScrollView scrollView = (ScrollView) newsact.findViewById(R.id.scrollViewid);
        LinearLayout linearLayout = (LinearLayout) newsact.findViewById(R.id.linearlayoutid);
        linearLayout.setOrientation(LinearLayout.VERTICAL);


        for (int i = 0; i < news.size() ; i++) {
            TextView tv = new TextView(newsact.getApplicationContext());
            tv.setTextColor(Color.BLACK);
            tv.setText(news.get(i).getTitle());
            final int finalI = i;
            final int finalI1 = i;
            final int finalI2 = i;
            final int finalI3 = i;
            final int finalI4 = i;
            final int finalI5 = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent inte = new Intent(newsact, NewsDetailsActivity.class);
                    inte.putExtra(CLICKED_DES, news.get(finalI1).getDescription());
                    inte.putExtra(CLICKED_TITLE, news.get(finalI2).getTitle());
                    inte.putExtra(CLICKED_LINK, news.get(finalI3).getLink());
                    inte.putExtra(CLICKED_IMAGE, news.get(finalI4).getThumbnail());
                    inte.putExtra(CLICKED_PUB, news.get(finalI5).getPubDate());
                    newsact.startActivity(inte);
                }
            });
            linearLayout.addView(tv);
        }
        //scrollView.addView(linearLayout);

        progressDialog.dismiss();
    }
}
