package com.example.noddy.roadtobike;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;

/**
 * Created by noddy on 2016-07-11.
 */
public class MarkerByCategory extends Activity {

    private int flaggW = 0,flaggT = 0,flaggB = 0;
    public NMapPOIdata testFordata[] = new NMapPOIdata[40];
    public NMapPOIdata bikeFordata[] = new NMapPOIdata[40];
    public NMapPOIdata toiletFordata[] = new NMapPOIdata[40];
    public NMapPOIdataOverlay testPOIdataOverlay;
    public DbForPublicDataParsing wifi = new DbForPublicDataParsing();
    public DbForPublicDataParsing bike = new DbForPublicDataParsing();

    public int j = 0;
    public double a = 0 , b = 0;

    public void ExcutWifiPoint(NMapOverlayManager mOverlayManagerMarker, NMapViewerResourceProvider mMapViewerResourceProviderMarker, int markeRoute) {



        if (flaggW == 0) {
            for(int i = 0; i <120 ; i = i +4) {
                a = Double.parseDouble(wifi.Wifi[i+3]);
                b = Double.parseDouble(wifi.Wifi[i+2]);
                testFordata[j] = new NMapPOIdata(30, mMapViewerResourceProviderMarker);
                testFordata[j].beginPOIdata(30);
                testFordata[j].addPOIitem(a, b, wifi.Wifi[i] + wifi.Wifi[i + 1], markeRoute, 0);
                testFordata[j].endPOIdata();
                testPOIdataOverlay = mOverlayManagerMarker.createPOIdataOverlay(testFordata[j], null);
                j++;
            }
            j = 0;
            flaggW = 1;
        }else if(flaggW == 1) {
            for(int i =0 ; i < 30 ; i++) {
                testFordata[i].removeAllPOIdata();
                testPOIdataOverlay = mOverlayManagerMarker.createPOIdataOverlay(testFordata[i], null);
            }
            flaggW = 0;
            j = 0;
        }
    }

    public void ExcutToiletPoint(NMapOverlayManager mOverlayManagerMarker, NMapViewerResourceProvider mMapViewerResourceProviderMarker, int markeRoute){


        if (flaggT == 0) {
            for(int i = 0; i <120 ; i = i +4) {
                a = Double.parseDouble(wifi.Toilet[i+3]);
                b = Double.parseDouble(wifi.Toilet[i+2]);
                testFordata[j] = new NMapPOIdata(30, mMapViewerResourceProviderMarker);
                testFordata[j].beginPOIdata(30);
                testFordata[j].addPOIitem(a, b, wifi.Toilet[i] + wifi.Toilet[i + 1], markeRoute, 0);
                testFordata[j].endPOIdata();
                testPOIdataOverlay = mOverlayManagerMarker.createPOIdataOverlay(testFordata[j], null);
                j++;
            }
            flaggT = 1;
        }else if(flaggT == 1) {
            for(int i =0 ; i < 30 ; i++) {
                testFordata[i].removeAllPOIdata();
                testPOIdataOverlay = mOverlayManagerMarker.createPOIdataOverlay(testFordata[i], null);
            }
            flaggT = 0;
            j = 0;
        }
    }
    public void ExcutBikePoint(NMapOverlayManager mOverlayManagerMarker, NMapViewerResourceProvider mMapViewerResourceProviderMarker, int markeRoute){

        Toast.makeText(MarkerByCategory.this, "(테스트)화장실정상적인 클릭."+bike.Bike[0], Toast.LENGTH_SHORT).show();

        /*
        if (flaggB == 0) {
            for(int i = 0; i < 20 ; i = i +4) {
                a = Double.parseDouble(wifi.Bike[i+3]);
                b = Double.parseDouble(wifi.Bike[i+2]);
                bikeFordata[j] = new NMapPOIdata(6, mMapViewerResourceProviderMarker);
                bikeFordata[j].beginPOIdata(6);
                bikeFordata[j].addPOIitem(a, b, wifi.Bike[i] + wifi.Bike[i + 1], markeRoute, 0);
                bikeFordata[j].endPOIdata();
                testPOIdataOverlay = mOverlayManagerMarker.createPOIdataOverlay(bikeFordata[j], null);
                j++;
            }
            flaggB = 1;
        }else if(flaggB == 1) {
            for(int i =0 ; i < 5 ; i++) {
                bikeFordata[i].removeAllPOIdata();
                testPOIdataOverlay = mOverlayManagerMarker.createPOIdataOverlay(bikeFordata[i], null);
            }
            flaggB = 0;
            j = 0;
        }*/
    }

}
