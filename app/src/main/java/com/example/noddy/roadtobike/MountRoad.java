package com.example.noddy.roadtobike;
/*산악도로 페이지*/
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapItemizedOverlay;
import com.nhn.android.maps.NMapOverlay;
import com.nhn.android.maps.NMapOverlayItem;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.maps.overlay.NMapPathData;
import com.nhn.android.maps.overlay.NMapPathLineStyle;
import com.nhn.android.mapviewer.overlay.NMapCalloutOverlay;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;
import com.nhn.android.mapviewer.overlay.NMapPathDataOverlay;

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
    public NMapPOIdata poiData;
    public NMapPOIdataOverlay poiDataOverlay;
    public int markerId;
    /*마커 이미지 테스트 */
    Bitmap markerBitmap;
    Drawable markerTest;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mount_road);

        /*for Map APi*/
        Mapcontainer = (LinearLayout) findViewById(R.id.mountRoad_Btn);
        mMapView = new NMapView(this);
        mMapController = mMapView.getMapController();
        mMapView.setClientId(CLIENT_ID);
        Mapcontainer.addView(mMapView);
        mMapView.setClickable(true);
        mMapViewerResourceProvider = new NMapViewerResourceProvider(this);
        mOverlayManager = new NMapOverlayManager(this, mMapView,
                mMapViewerResourceProvider);

        mMapView.setOnMapStateChangeListener(this);

        /*
        * poiData.addPOIitem(127.0630205, 37.5091300, "위치1", markerTest, 0);
        * markerTest이 변수가 들어가는 부분인 아마 마커관련된거 같음
        * 아래보이는 두줄이용해서 markerTest에 getResources(),R.drawable.ic_net_wif를 이용해서
        * 변수에 내가 원하는 이미지를 넣음
        * */
        markerBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_net_wif);
        markerTest = new BitmapDrawable(markerBitmap);



        /*경로Test*/
        markerId = NMapPOIflagType.PIN;
        NMapPathData pathData = new NMapPathData(9);
        pathData.initPathData();
        pathData.addPathPoint(128.2599500, 37.8741320, NMapPathLineStyle.TYPE_SOLID);//상남(출발)
        pathData.addPathPoint(128.27435, 37.870822, 0);
        pathData.addPathPoint(128.269329, 37.879325, 0);
        pathData.addPathPoint(128.281002, 37.875124, 0);
        pathData.addPathPoint(128.3109455, 37.8749729, 0);//미산계곡
        pathData.addPathPoint(128.5133257, 37.8799347, 0);//구룡령
        pathData.addPathPoint(128.5033933, 37.9964677, 0);//조침령터널
        pathData.addPathPoint(128.4081958, 37.9634730, 0);//진동계곡
        pathData.addPathPoint(128.3375473, 37.9441227, 0);//방동계곡
        pathData.addPathPoint(128.2629901, 37.8808571, 0);//오미재
        pathData.addPathPoint(128.2599500, 37.8741320, NMapPathLineStyle.TYPE_SOLID);//상남(도착)
        pathData.endPathData();
        NMapPathDataOverlay pathDataOverlay = mOverlayManager.createPathDataOverlay(pathData);
        pathDataOverlay.showAllPathData(7);

        /*주요 경로 마커*/
        poiData = new NMapPOIdata(7, mMapViewerResourceProvider);
        poiData.beginPOIdata(7);
        poiData.addPOIitem(128.2599500, 37.8741320, "상남", markerId, 0);
        poiData.addPOIitem(128.3109455, 37.8749729, "미산계곡", markerId,0);
        poiData.addPOIitem(128.5133257, 37.8799347, "구룡령", markerId, 0);
        poiData.addPOIitem(128.5033933, 37.9964677, "조침터미널", markerId,0);
        poiData.addPOIitem(128.4081958, 37.9634730, "진동계곡", markerId, 0);
        poiData.addPOIitem(128.3375473, 37.9441227, "방동계곡", markerId,0);
        poiData.addPOIitem(128.2629901, 37.8808571, "오미재", markerId, 0);
        poiData.endPOIdata();
        poiDataOverlay = mOverlayManager.createPOIdataOverlay(poiData, null);


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
            Toast.makeText(MountRoad.this, "(테스트)지도 초기화 성공.", Toast.LENGTH_SHORT).show();
            //mMapController.setMapCenter(new NGeoPoint(127.0630205, 37.5091300), 11);
        } else { // fail
            //Toast.makeText(MountRoad.this, "(테스트)지도 초기화 실패.", Toast.LENGTH_SHORT).show();
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

               //poiDataOverlay.showAllPOIdata(0);
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