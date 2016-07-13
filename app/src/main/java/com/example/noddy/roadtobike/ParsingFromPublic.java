package com.example.noddy.roadtobike;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.InputStream;
import java.io.StringReader;

/**
 * Created by Administrator on 2016-07-13.
 */
public class ParsingFromPublic extends Activity {

    private SQLiteDatabase db;
    static String[] Wifi = new String[150];//무료와이파이 정보 들어갈 배열
    static String[] Bike = new String[50];//자전거인증소 정보 들어갈 배열
    static String[] Toilet = new String[2000];//공중화장실 정보 들어갈 배열
    public int i =0;
    public int j =0;
    public int z =0;//i,j,z 변수는 위에서 선언한 배열에 차례차례 들어가도록 선언한 변수
    public DBHelper dbHelper;

    public void StartParsingFromPublic() {

        String file = "Wifi.xml";
        String result = "";
        try {
            InputStream is = getAssets().open(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            result = new String(buffer, "utf-8");

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true); //xml 네임스페이스 지원 여부 설정
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(result));
            int eventType = xpp.getEventType();

            boolean bSet = false;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    String tag_name = xpp.getName();
                    if (tag_name.equals("INIT_AREA_NM") | tag_name.equals("INIT_AREA_DETAIL") | tag_name.equals("LAT") | tag_name.equals("LNG"))
                        //이 if문은 xml파일에서 필요한 부분만 추출해서 읽어오는 코드
                        bSet = true;
                } else if (eventType == XmlPullParser.TEXT) {
                    if (bSet) {
                        String data = xpp.getText();
                        Wifi[i] = data;
                        i++;
                        bSet = false;
                    }
                } else if (eventType == XmlPullParser.END_TAG) ;
                eventType = xpp.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        String file1 = "BikeL.xml";
        String result1 = "";
        try {
            InputStream is = getAssets().open(file1);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            result1 = new String(buffer, "utf-8");

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true); //xml 네임스페이스 지원 여부 설정
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(result1));
            int eventType = xpp.getEventType();

            boolean bSet = false;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    String tag_name = xpp.getName();
                    if (tag_name.equals("SISUL_NM") | tag_name.equals("INIT_AREA") | tag_name.equals("LNG") | tag_name.equals("LAT"))
                        bSet = true;
                } else if (eventType == XmlPullParser.TEXT) {
                    if (bSet) {
                        String data = xpp.getText();
                        Bike[j] = data;
                        j++;
                        bSet = false;
                    }
                } else if (eventType == XmlPullParser.END_TAG) ;
                eventType = xpp.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        String file2 = "Toilet.xml";
        String result2 = "";
        try {
            InputStream is = getAssets().open(file2);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            result2 = new String(buffer, "utf-8");

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true); //xml 네임스페이스 지원 여부 설정
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(result2));
            int eventType = xpp.getEventType();

            boolean bSet = false;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    String tag_name = xpp.getName();
                    if (tag_name.equals("TOILET_NM") | tag_name.equals("LOCPLC_LOTNO_ADDR") | tag_name.equals("LNG") | tag_name.equals("LAT"))
                        bSet = true;
                } else if (eventType == XmlPullParser.TEXT) {
                    if (bSet) {
                        String data = xpp.getText();
                        Toilet[z] = data;
                        z++;
                        bSet = false;
                    }
                } else if (eventType == XmlPullParser.END_TAG) ;
                eventType = xpp.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
