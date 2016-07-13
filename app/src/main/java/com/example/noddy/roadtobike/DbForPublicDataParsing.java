package com.example.noddy.roadtobike;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Arrays;


public class DbForPublicDataParsing extends AppCompatActivity implements View.OnClickListener{

    private SQLiteDatabase db;
    DBHelper dbHelper;
    Button DBgo;
    public static String[] Wifi = new String[150];//무료와이파이 정보 들어갈 배열
    public static String[] Bike = new String[50];//자전거인증소 정보 들어갈 배열
    static String[] Toilet = new String[2000];//공중화장실 정보 들어갈 배열
    public MarkerByCategory mMarkerByCategory;
    int i =0;
    int j =0;
    int z =0;//i,j,z 변수는 위에서 선언한 배열에 차례차례 들어가도록 선언한 변수

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_db_for_public_data_parsing);



         //여기서부터 같은 포맷으로 3번 들어감. 와이파이,자전거,공중화장실. xml파일로부터 공공데이터 읽어오는 부분
        //클래스 선언해서 변수값만 넣어서 함수 호출식으로 해도 될거같은데 한번 해봤는데 파일을 못읽어왔음 내가 잘못한건지..
        String file= "Wifi.xml";
        String result="";
        try {
            InputStream is=getAssets().open(file);
            int size=is.available();
            byte[] buffer=new byte[size];
            is.read(buffer);
            is.close();
            result=new String(buffer,"utf-8");

            XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true); //xml 네임스페이스 지원 여부 설정
            XmlPullParser xpp=factory.newPullParser();
            xpp.setInput(new StringReader(result));
            int eventType=xpp.getEventType();

            boolean bSet=false;
            while(eventType!=XmlPullParser.END_DOCUMENT){
                if(eventType== XmlPullParser.START_TAG){
                    String tag_name=xpp.getName();
                    if(tag_name.equals("INIT_AREA_NM")|tag_name.equals("INIT_AREA_DETAIL")|tag_name.equals("LAT")|tag_name.equals("LNG"))
                        //이 if문은 xml파일에서 필요한 부분만 추출해서 읽어오는 코드
                        bSet=true;
                }else if(eventType==XmlPullParser.TEXT){
                    if(bSet){
                        String data=xpp.getText();
                        Wifi[i] = data;
                        i++;
                        bSet=false;
                    }
                }else if(eventType==XmlPullParser.END_TAG);
                eventType=xpp.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        String file1= "BikeL.xml";
        String result1="";
        try {
            InputStream is=getAssets().open(file1);
            int size=is.available();
            byte[] buffer=new byte[size];
            is.read(buffer);
            is.close();
            result1=new String(buffer,"utf-8");

            XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true); //xml 네임스페이스 지원 여부 설정
            XmlPullParser xpp=factory.newPullParser();
            xpp.setInput(new StringReader(result1));
            int eventType=xpp.getEventType();

            boolean bSet=false;
            while(eventType!=XmlPullParser.END_DOCUMENT){
                if(eventType== XmlPullParser.START_TAG){
                    String tag_name=xpp.getName();
                    if(tag_name.equals("SISUL_NM")|tag_name.equals("INIT_AREA")|tag_name.equals("LNG")|tag_name.equals("LAT"))
                        bSet=true;
                }else if(eventType==XmlPullParser.TEXT){
                    if(bSet){
                        String data=xpp.getText();
                        Bike[j] = data;
                        j++;
                        bSet=false;
                    }
                }else if(eventType==XmlPullParser.END_TAG);
                eventType=xpp.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        String file2= "Toilet.xml";
        String result2="";
        try {
            InputStream is=getAssets().open(file2);
            int size=is.available();
            byte[] buffer=new byte[size];
            is.read(buffer);
            is.close();
            result2=new String(buffer,"utf-8");

            XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true); //xml 네임스페이스 지원 여부 설정
            XmlPullParser xpp=factory.newPullParser();
            xpp.setInput(new StringReader(result2));
            int eventType=xpp.getEventType();

            boolean bSet=false;
            while(eventType!=XmlPullParser.END_DOCUMENT){
                if(eventType== XmlPullParser.START_TAG){
                    String tag_name=xpp.getName();
                    if(tag_name.equals("TOILET_NM")|tag_name.equals("LOCPLC_LOTNO_ADDR")|tag_name.equals("LNG")|tag_name.equals("LAT"))
                        bSet=true;
                }else if(eventType==XmlPullParser.TEXT){
                    if(bSet){
                        String data=xpp.getText();
                        Toilet[z] = data;
                        z++;
                        bSet=false;
                    }
                }else if(eventType==XmlPullParser.END_TAG);
                eventType=xpp.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //여기서부터 DB불러오는 코드
        //DBHelper에서 맨처음 만든 테이블이 R_Wifi 테이블이라 DB이름도 R_Wifi
        //R_Wifi.db 안에 3개 테이블이 들어있다.
        String dbName = "H_Wifi.db";
        int dbVersion = 1;
        dbHelper = new DBHelper(this);
        DBgo = (Button)this.findViewById(R.id.test2);
        DBgo.setOnClickListener(this);
        //테스트용으로 화면에 띄워볼라고 만든 텍스트뷰어. 없어도됨

        //DB에 데이터 집어넣는 코드 for문 3번 써서 차례대로 DB에 저장시킴

        DBgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    db = dbHelper.getWritableDatabase();
                    for(int x=0;x<i;x++){
                        String sql = String.format("INSERT INTO H_Wifi VALUES('%s','%s','%s','%s')",Wifi[x],Wifi[x+1],Wifi[x+2],Wifi[x+3]);
                        x=x+3;
                        db.execSQL(sql);
                    }
                    for(int x=0;x<j;x++){
                        String sql1 = String.format("INSERT INTO H_Bike VALUES('%s','%s','%s','%s')",Bike[x],Bike[x+1],Bike[x+3],Bike[x+2]);
                        x=x+3;
                        db.execSQL(sql1);
                    }
                    for(int x=0;x<z;x++){
                        String sql2 = String.format("INSERT INTO H_Toilet VALUES('%s','%s','%s','%s')",Toilet[x],Toilet[x+1],Toilet[x+3],Toilet[x+2]);
                        x=x+3;
                        db.execSQL(sql2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
         mMarkerByCategory = new MarkerByCategory();
         mMarkerByCategory.MarkerBike[0] = Bike[3];
         mMarkerByCategory.searchResultList.addAll(Arrays.asList(Bike));
         Toast.makeText(DbForPublicDataParsing.this, "(테스트)화장실정상적인 클릭."+mMarkerByCategory.searchResultList.get(0).toString(), Toast.LENGTH_SHORT).show();
     }
    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.test1){
            Intent intent =new Intent(this, MountRoad.class);
            startActivity(intent);
        }
    }
 }
