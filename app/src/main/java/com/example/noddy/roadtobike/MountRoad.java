package com.example.noddy.roadtobike;
/*산악도로 페이지*/
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapOverlay;
import com.nhn.android.maps.NMapOverlayItem;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.mapviewer.overlay.NMapCalloutOverlay;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;

public class MountRoad extends NMapActivity implements View.OnClickListener,
    NMapView.OnMapStateChangeListener, NMapView.OnMapViewTouchEventListener, NMapOverlayManager.OnCalloutOverlayListener {

    private static final String CLIENT_ID = "QYEl8bJjw912O8_ZRLJ9";
    private NMapView mMapView = null;
    private NMapController mMapController;
    NMapOverlayManager mOverlayManager;
    NMapPOIdataOverlay.OnStateChangeListener onPOIdataStateChangeListener;
    NMapViewerResourceProvider mMapViewerResourceProvider = null;
    private Button Wifi_Btn;
    private Button Toilet_Btn;
    private Button Light_Btn;
    private Button back_Btn;
    LinearLayout Mapcontainer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mount_road);
        /*for Map APi*/
        Mapcontainer = (LinearLayout) findViewById(R.id.mountRoad_Btn);
        mMapView = new NMapView(this);
        mMapView.setClientId(CLIENT_ID);
        Mapcontainer.addView(mMapView);
        mMapView.setClickable(true);
        mMapViewerResourceProvider = new NMapViewerResourceProvider(this);
        mOverlayManager = new NMapOverlayManager(this, mMapView,
                mMapViewerResourceProvider);

        int markerId = NMapPOIflagType.PIN;

        NMapPOIdata poiData = new NMapPOIdata(2, mMapViewerResourceProvider);
        poiData.beginPOIdata(2);
        poiData.addPOIitem(127.0630205, 37.5091300, "위치1", markerId, 0);
        poiData.addPOIitem(127.061, 37.51, "위치2", markerId, 0);
        poiData.endPOIdata();

        NMapPOIdataOverlay poiDataOverlay
                = mOverlayManager.createPOIdataOverlay(poiData, null);

        poiDataOverlay.showAllPOIdata(0);


        /*Button MountRoadpage*/
        Wifi_Btn = (Button) findViewById(R.id.wifi_btn);
        Toilet_Btn = (Button) findViewById(R.id.toilet_btn);
        Light_Btn = (Button) findViewById(R.id.light_btn);
        back_Btn = (Button) findViewById(R.id.back_btn);
        Wifi_Btn.setOnClickListener(this);
        Toilet_Btn.setOnClickListener(this);
        Light_Btn.setOnClickListener(this);
        back_Btn.setOnClickListener(this);

    }

    public void onMapInitHandler(NMapView mapView, NMapError errorInfo) {
        if (errorInfo == null) { // success
            //mMapController.setMapCenter(new NGeoPoint(126.978371, 37.5666091), 11);
        } else { // fail
            android.util.Log.e("NMAP", "onMapInitHandler: error="
                    + errorInfo.toString());
        }
    }

    @Override
    public void onMapCenterChange(NMapView nMapView, NGeoPoint nGeoPoint) {

    }

    @Override
    public void onMapCenterChangeFine(NMapView nMapView) {

    }

    @Override
    public void onZoomLevelChange(NMapView nMapView, int i) {

    }

    @Override
    public void onAnimationStateChange(NMapView nMapView, int i, int i1) {

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.wifi_btn:
                //여기다 버튼 이벤트 코딩
                Toast.makeText(MountRoad.this, "(테스트)와이파이정상적인 클릭.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toilet_btn:
                ////여기다 버튼 이벤트 코딩
                Toast.makeText(MountRoad.this, "(테스트)화장실정상적인 클릭.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.light_btn:
                //여기다 버튼 이벤트 코딩
                Toast.makeText(MountRoad.this, "(테스트)전기시간정상적인 클릭.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.back_btn:
                //여기다 버튼 이벤트 코딩
                Toast.makeText(MountRoad.this, "(테스트)뒤로가기정상적인 클릭.", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public NMapCalloutOverlay onCreateCalloutOverlay(NMapOverlay nMapOverlay, NMapOverlayItem nMapOverlayItem, Rect rect) {
        return null;
    }

    @Override
    public void onLongPress(NMapView nMapView, MotionEvent motionEvent) {

    }

    @Override
    public void onLongPressCanceled(NMapView nMapView) {

    }

    @Override
    public void onTouchDown(NMapView nMapView, MotionEvent motionEvent) {

    }

    @Override
    public void onTouchUp(NMapView nMapView, MotionEvent motionEvent) {

    }

    @Override
    public void onScroll(NMapView nMapView, MotionEvent motionEvent, MotionEvent motionEvent1) {

    }

    @Override
    public void onSingleTapUp(NMapView nMapView, MotionEvent motionEvent) {

    }
}