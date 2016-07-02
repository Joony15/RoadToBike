package com.example.noddy.roadtobike;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;

public class MountRoad extends NMapActivity {

    private static final String CLIENT_ID = "QYEl8bJjw912O8_ZRLJ9";


    private NMapView mMapView = null;
    private NMapController mMapController;
    LinearLayout Mapcontainer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mount_road);
        Mapcontainer = (LinearLayout)findViewById(R.id.mountRoad_Btn);
        mMapView = new NMapView(this);
        mMapView.setClientId(CLIENT_ID);
        Mapcontainer.addView(mMapView);




        //setContentView(mMapView);


    }
    public void onMapInitHandler(NMapView mapView, NMapError errorInfo) {
        if (errorInfo == null) { // success
            mMapController.setMapCenter(new NGeoPoint(126.978371, 37.5666091), 11);
        } else { // fail
            //Log.e(LOG_TAG, "onMapInitHandler: error=" + errorInfo.toString());
        }
    }
}
