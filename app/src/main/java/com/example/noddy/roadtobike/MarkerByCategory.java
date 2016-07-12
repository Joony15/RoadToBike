package com.example.noddy.roadtobike;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;

import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;

/**
 * Created by noddy on 2016-07-11.
 */
public class MarkerByCategory extends Activity {

    /*for DB*/
    public NMapPOIdata testFordata[] = new NMapPOIdata[40];
    public NMapPOIdataOverlay testPOIdataOverlay;
    public int flagg = 0;
    String nameMount, locationMount, WiMount, KyungMount;
    public DbForPublicDataParsing wifi = new DbForPublicDataParsing();
    DBHelper dbHelper;
    SQLiteDatabase db;
    public int i,j = 0;
    public double a = 0 , b = 0;

    public void ExcutWifiPoint(NMapOverlayManager mOverlayManagerMarker, NMapViewerResourceProvider mMapViewerResourceProviderMarker, int markeRoute) {


        if (flagg == 0) {

            for(i = 0; i <120 ; i = i +4) {

                a = Double.parseDouble(wifi.Wifi[i+3]);
                b = Double.parseDouble(wifi.Wifi[i+2]);
                testFordata[j] = new NMapPOIdata(30, mMapViewerResourceProviderMarker);
                testFordata[j].beginPOIdata(30);
                testFordata[j].addPOIitem(a, b, wifi.Wifi[i] + wifi.Wifi[i + 1], markeRoute, 0);
                testFordata[j].endPOIdata();
                testPOIdataOverlay = mOverlayManagerMarker.createPOIdataOverlay(testFordata[j], null);
                j++;

            }

            flagg = 1;

        }else if(flagg == 1) {


            for(i =0 ; i < 30 ; i++) {

                testFordata[i].removeAllPOIdata();
                testPOIdataOverlay = mOverlayManagerMarker.createPOIdataOverlay(testFordata[i], null);

            }

            flagg = 0;

        }
    }

    public void ExcutToiletPoint(NMapOverlayManager mOverlayManagerMarker, NMapViewerResourceProvider mMapViewerResourceProviderMarker, int markeRoute) {

    }
    public void ExcutBikePoint(){

    }


}
