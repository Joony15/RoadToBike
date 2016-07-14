package com.example.noddy.roadtobike;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Toast;

import com.nhn.android.maps.NMapOverlay;
import com.nhn.android.maps.NMapOverlayItem;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.maps.overlay.NMapPOIitem;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noddy on 2016-07-11.
 */

public class MarkerByCategory extends Activity {

    private int flaggW = 0,flaggT = 0,flaggB = 0;
    public NMapPOIdata testFordata[] = new NMapPOIdata[40];
    public NMapPOIdata bikeFordata[] = new NMapPOIdata[40];
    public NMapPOIdata toilet[] = new NMapPOIdata[40];
    public NMapPOIdata toiletFordata[] = new NMapPOIdata[40];
    public NMapPOIdataOverlay testPOIdataOverlay;
    public MainActivity wifi = new MainActivity();
    public MainActivity bike = new MainActivity();
    NMapPOIitem mNMapPOIitem;
    public String[] MarkerBike = new String[50];//자전거인증소 정보 들어갈 배열
    public int j = 0;
    public double a = 0 , b = 0;
    public static List<String> searchResultList = new ArrayList<String>();
    public static List<String> searchResultListToilet = new ArrayList<String>();

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
            testPOIdataOverlay.showAllPOIdata(4);
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
            for(int i = 0; i <148 ; i = i +4) {
                a = Double.parseDouble(searchResultListToilet.get(i+2).toString());
                b = Double.parseDouble(searchResultListToilet.get(i+3).toString());
                toilet[j] = new NMapPOIdata(40, mMapViewerResourceProviderMarker);
                toilet[j].beginPOIdata(40);
                toilet[j].addPOIitem(a, b, searchResultListToilet.get(i).toString() + searchResultListToilet.get(i+1).toString(), markeRoute, 0);
                toilet[j].endPOIdata();
                testPOIdataOverlay = mOverlayManagerMarker.createPOIdataOverlay(toilet[j], null);
                j++;
            }
            testPOIdataOverlay.showAllPOIdata(4);
            j = 0;
            flaggT = 1;
        }else if(flaggT == 1) {
            for(int i =0 ; i < 37 ; i++) {
                toilet[i].removeAllPOIdata();
                testPOIdataOverlay = mOverlayManagerMarker.createPOIdataOverlay(toilet[i], null);
            }
            flaggT = 0;
            j = 0;
        }
    }
    public void ExcutBikePoint(NMapOverlayManager mOverlayManagerMarker, NMapViewerResourceProvider mMapViewerResourceProviderMarker, int markeRoute){

        if (flaggB == 0) {
            for(int i = 0; i < 20 ; i = i +4) {

                a = Double.parseDouble(searchResultList.get(i+2).toString());
                b = Double.parseDouble(searchResultList.get(i+3).toString());
                bikeFordata[j] = new NMapPOIdata(6, mMapViewerResourceProviderMarker);
                bikeFordata[j].beginPOIdata(6);
                bikeFordata[j].addPOIitem(a, b, searchResultList.get(i).toString() + searchResultList.get(i+1).toString(), markeRoute, 0);
                bikeFordata[j].endPOIdata();
                testPOIdataOverlay = mOverlayManagerMarker.createPOIdataOverlay(bikeFordata[j], null);
                j++;
            }
            testPOIdataOverlay.showAllPOIdata(4);
            mOverlayManagerMarker.setOnCalloutOverlayViewListener(onCalloutOverlayViewListener);
            j = 0;
            flaggB = 1;
        }else if(flaggB == 1) {
            for(int i =0 ; i < 5 ; i++) {
                bikeFordata[i].removeAllPOIdata();
                testPOIdataOverlay = mOverlayManagerMarker.createPOIdataOverlay(bikeFordata[i], null);
            }
            flaggB = 0;
            j = 0;
        }
    }
    private final NMapOverlayManager.OnCalloutOverlayViewListener onCalloutOverlayViewListener = new NMapOverlayManager.OnCalloutOverlayViewListener() {

        @Override
        public View onCreateCalloutOverlayView(NMapOverlay itemOverlay, NMapOverlayItem overlayItem, Rect itemBounds) {

            if (overlayItem != null) {
                // [TEST] 말풍선 오버레이를 뷰로 설정함
                String title = overlayItem.getTitle();
                if (title != null && title.length() > 5) {
                    return new NMapCalloutCustomOverlayView(MarkerByCategory.this, itemOverlay, overlayItem, itemBounds);
                }
            }

            // null을 반환하면 말풍선 오버레이를 표시하지 않음
            return null;
        }

    };
    public void showLoginDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select");
        builder.setCancelable(false);
        builder.create();
        builder.show();
    }


}
