package com.example.noddy.roadtobike;
/*
*
* 메인 페이지
*
*
*/
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.StringReader;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NumberPicker.OnValueChangeListener {

    public static String[] Wifi = new String[150];//무료와이파이 정보 들어갈 배열
    public static String[] Bike = new String[50];//자전거인증소 정보 들어갈 배열
    static String[] Toilet = new String[2000];//공중화장실 정보 들어갈 배열
    public MarkerByCategory mMarkerByCategory;
    Button MountGo;
    Button SeaGo;
    private  int pickRoute = 0;
    //Button WhereGo;
    int i =0;
    int j =0;
    int z =0;//i,j,z 변수는 위에서 선언한 배열에 차례차례 들어가도록 선언한 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        // roadtobike 이미지 띄우기 코드
        Drawable drawable = getResources().getDrawable(
                R.drawable.rtb);
        ImageView imageView = (ImageView) findViewById(R.id.imageView01);
        imageView.setImageDrawable(drawable);

        /*Button for main menu*/
        MountGo = (Button) findViewById(R.id.mountchoice_btn);
        SeaGo = (Button) findViewById(R.id.seachoice_btn);
        MountGo.setOnClickListener(this);
        SeaGo.setOnClickListener(this);
        //공공데이터 파싱해주는 부분
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

        mMarkerByCategory = new MarkerByCategory();
        mMarkerByCategory.searchResultList.addAll(Arrays.asList(Bike));
        mMarkerByCategory.searchResultListToilet.addAll(Arrays.asList(Toilet));


    }
    /* for Button event when it is pushed */
    @Override
    public void onClick(View v) {

        /* for choice menu */
        Intent intent;

        if(v.getId() == R.id.mountchoice_btn)
        {
            show();
            //intent =new Intent(this, MountRoad.class);
            //startActivity(intent);

        }
        else if(v.getId() == R.id.seachoice_btn)
        {
            switch(pickRoute) {
                case 0:
                    intent = new Intent(this, MountRoad.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(this, SeaRoad.class);
                    startActivity(intent);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
        }


    }
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

        Log.i("value is",""+newVal);

    }
    public void show()
    {

        final Dialog d = new Dialog(MainActivity.this);
        d.setTitle("경로선택");
        d.setContentView(R.layout.activity_forpicker);
        Button b1 = (Button) d.findViewById(R.id.button11);
        Button b2 = (Button) d.findViewById(R.id.button21);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        np.setMaxValue(7); // max value 100
        np.setMinValue(1);   // min value 0
        //순서대로 0~7까지 값이 적용됨
        np.setDisplayedValues( new String[] { "대한민국최고의 해안도로", "설악 그란폰도 라이딩코스", "몰라","어디할지","안정했어","뭐할지 정해서 알려주삼","!!!!!!!!끝" } );
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(this);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //getValue를 톨해 적용된 갑을 불러옴
                pickRoute = np.getValue();
                d.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.cancel(); // dismiss the dialog
            }
        });
        d.show();


    }

}
