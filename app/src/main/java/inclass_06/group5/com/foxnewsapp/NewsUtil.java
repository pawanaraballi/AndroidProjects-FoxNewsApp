package inclass_06.group5.com.foxnewsapp;

import android.util.Log;

import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by pawan on 2/22/2016.
 */
public class NewsUtil {

    static public class NewsPullParser extends DefaultHandler{
        ArrayList<News> NewsList;
        News news;

        static ArrayList<News> parseNews(InputStream in) throws XmlPullParserException, IOException {
            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(in, "UTF-8");
            News news1 = null;
            ArrayList<News> Newslist = new ArrayList<News>();
            int event = parser.getEventType();

            int toggle = 0;
            while (event!=XmlPullParser.END_DOCUMENT){
                switch (event){

                    case XmlPullParser.START_TAG:
                        if(parser.getName().equals("item")) {
                            news1 = new News();
                            toggle=1;}
                        if(toggle==1) {
                            if (parser.getName().equals("title")) {
                                news1.setTitle(parser.nextText());
                            } else if (parser.getName().equals("description")) {
                                news1.setDescription(parser.nextText().trim());
                            }
                            else if (parser.getName().equals("pubDate")) {
                                news1.setPubDate(parser.nextText().trim());
                            }
                            else if (parser.getName().equals("media:thumbnail")){

                                news1.setThumbnail(parser.getAttributeValue(null, "url"));

                            }else if (parser.getName().equals("link")){

                                news1.setLink(parser.nextText().trim());
                            }
                        }
                        break;


                    case XmlPullParser.END_TAG:
                        if(parser.getName().equals("item")){
                            Newslist.add(news1);
                            news1=null;
                            toggle = 0;
                        }

                    default:break;

                }
                event=parser.next();
            }

            return Newslist;
        }
    }
}
