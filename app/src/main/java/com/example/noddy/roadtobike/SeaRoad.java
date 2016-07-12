package com.example.noddy.roadtobike;
/*해안가도로 페이지*/
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapCompassManager;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapLocationManager;
import com.nhn.android.maps.NMapOverlay;
import com.nhn.android.maps.NMapOverlayItem;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.maps.overlay.NMapPathData;
import com.nhn.android.maps.overlay.NMapPathLineStyle;
import com.nhn.android.mapviewer.overlay.NMapCalloutOverlay;
import com.nhn.android.mapviewer.overlay.NMapMyLocationOverlay;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;
import com.nhn.android.mapviewer.overlay.NMapPathDataOverlay;

public class SeaRoad extends NMapActivity implements View.OnClickListener,
        NMapView.OnMapStateChangeListener, NMapView.OnMapViewTouchEventListener, NMapOverlayManager.OnCalloutOverlayListener {

    private static final String CLIENT_ID = "QYEl8bJjw912O8_ZRLJ9";
    private NMapView mMapView = null;
    private NMapController mMapController;
    private NMapMyLocationOverlay mMyLocationOverlay;
    private NMapLocationManager mMapLocationManager;
    private NMapCompassManager mMapCompassManager;
    NMapOverlayManager mOverlayManager;
    NMapPOIdataOverlay.OnStateChangeListener onPOIdataStateChangeListener;
    NMapViewerResourceProvider mMapViewerResourceProvider = null;
    SeaRoute mSeaRoute;
    private ImageButton Wifi_Btn;
    private ImageButton Toilet_Btn;
    private ImageButton Bike_Btn;
    private ImageButton Gps_Btn;
    private ImageButton Back_Btn;
    private ImageButton Camera_Btn;


    //마커 경로 테스트용도
    private double disMylocationFromMarkerSea = 0;
    private NGeoPoint myLocationSea;
    LinearLayout Mapcontainer;
    public NMapPOIdata poiData;
    public NMapPOIdataOverlay poiDataOverlay;
    public int markerId;
    /*마커 이미지 테스트 */
    Bitmap markerBitmap;
    Drawable markerTest;
    Intent intentSea;
    int flagForLocationSea = 0;
    private TextView textview;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sea_road);

        /*for Map APi*/
        Mapcontainer = (LinearLayout) findViewById(R.id.seaRoad_Btn);
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
        markerId = NMapPOIflagType.PIN;

        /*my location*/
        mMapLocationManager = new NMapLocationManager(this);
        mMapLocationManager.enableMyLocation(false);
        mMapLocationManager.setOnLocationChangeListener(onMyLocationChangeListener);
        mMyLocationOverlay = mOverlayManager.createMyLocationOverlay(mMapLocationManager, mMapCompassManager);

        /*MountRoute에서 경로를 위해 불러온 함수*/
        mSeaRoute = new SeaRoute();
        mSeaRoute.ExcuteSeaRoute(mOverlayManager,mMapView);

        //현재 나의 위치 받아오기
        myLocationSea = new NGeoPoint();
        myLocationSea = mMapLocationManager.getMyLocation();

        /*SeaRoute에서 마커를 위해 불러온 함수*/
        mSeaRoute.ExcuteSeaPoint(mOverlayManager,mMapViewerResourceProvider,markerId);

        /*Button MountRoadpage*/
        Wifi_Btn = (ImageButton) findViewById(R.id.seawifi_btn);
        Toilet_Btn = (ImageButton) findViewById(R.id.seatoilet_btn);
        Bike_Btn = (ImageButton) findViewById(R.id.seabike_btn);
        Gps_Btn = (ImageButton) findViewById(R.id.seagps_btn);
        Back_Btn = (ImageButton) findViewById(R.id.seaback_btn);
        Camera_Btn = (ImageButton) findViewById(R.id.seacamera_btn);
        Wifi_Btn.setOnClickListener(this);
        Toilet_Btn.setOnClickListener(this);
        Bike_Btn.setOnClickListener(this);
        Gps_Btn.setOnClickListener(this);
        Back_Btn.setOnClickListener(this);
        Camera_Btn.setOnClickListener(this);
        textview = (TextView)findViewById(R.id.textview2);

    }

    public void onMapInitHandler(NMapView mapView, NMapError errorInfo) {
        if (errorInfo == null) { // success
            //Toast.makeText(SeaRoad.this, "(테스트)지도 초기화 성공.", Toast.LENGTH_SHORT).show();

            mMapController.setMapCenter(new NGeoPoint(128.46427, 38.39845), 5);
            //startMyLocation();
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
            case R.id.seawifi_btn:
                //여기다 버튼 이벤트 코딩
                textview.setText("무료 와이파이");
                if(flagForLocationSea == 0)
                {
                    Toast.makeText(SeaRoad.this, "(테스트)현재 위치 해제.", Toast.LENGTH_SHORT).show();
                    stopMyLocation();

                }else if(flagForLocationSea == 1){


                    Toast.makeText(SeaRoad.this, "(테스트)현재 위치 설정..", Toast.LENGTH_SHORT).show();
                    startMyLocation();
                }
                break;
            case R.id.seatoilet_btn:
                ////여기다 버튼 이벤트 코딩
                textview.setText("공용 화장실");
                stopMyLocation();
                Toast.makeText(SeaRoad.this, "(테스트)화장실정상적인 클릭.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.seabike_btn:
                //여기다 버튼 이벤트 코딩
                textview.setText("자전거 대여소");
                Toast.makeText(SeaRoad.this, "(테스트)전기시간정상적인 클릭.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.seagps_btn:
                //여기다 버튼 이벤트 코딩
                textview.setText("현재위치");
                Toast.makeText(SeaRoad.this, "(테스트)현재위치정상적인 클릭.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.seaback_btn:
                //여기다 버튼 이벤트 코딩
                Toast.makeText(SeaRoad.this, "(테스트)뒤로가기정상적인 클릭.", Toast.LENGTH_SHORT).show();
                intentSea =new Intent(this, MainActivity.class);
                startActivity(intentSea);
                break;

            case R.id.seacamera_btn:
                //여기다 버튼 이벤트 코딩
                Toast.makeText(SeaRoad.this, "(테스트)카메라정상적인 클릭.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
                break;
        }
    }
    public double distanceFromMarkerSea(){

        if(myLocationSea != null)
        {
            disMylocationFromMarkerSea = myLocationSea.getDistance(mSeaRoute.forCheckedPoinSea[mSeaRoute.FlagForMarkerSea],myLocationSea);
            //Toast.makeText(SeaRoad.this, "(테스트)거리계산성공.", Toast.LENGTH_SHORT).show();

        }
        else
        {
            //Toast.makeText(SeaRoad.this, "(테스트)거리계산실패.", Toast.LENGTH_SHORT).show();

        }
        return disMylocationFromMarkerSea;
    }

    private void startMyLocation() {

        if (mMyLocationOverlay != null) {
            if (!mOverlayManager.hasOverlay(mMyLocationOverlay)) {
                mOverlayManager.addOverlay(mMyLocationOverlay);
            }

            if (mMapLocationManager.isMyLocationEnabled()) {

                if (!mMapView.isAutoRotateEnabled()) {
                    mMyLocationOverlay.setCompassHeadingVisible(true);

                    mMapCompassManager.enableCompass();

                    mMapView.setAutoRotateEnabled(true, false);

                    Mapcontainer.requestLayout();
                } else {
                    stopMyLocation();
                }

                mMapView.postInvalidate();
            } else {
                boolean isMyLocationEnabled = mMapLocationManager.enableMyLocation(true);
                if (!isMyLocationEnabled) {
                    Toast.makeText(SeaRoad.this, "Please enable a My Location source in system settings",
                            Toast.LENGTH_LONG).show();

                    Intent goToSettings = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(goToSettings);

                    return;
                }
            }
        }
    }

    private void stopMyLocation() {
        if (mMyLocationOverlay != null) {
            mMapLocationManager.disableMyLocation();

            if (mMapView.isAutoRotateEnabled()) {
                mMyLocationOverlay.setCompassHeadingVisible(false);

                mMapCompassManager.disableCompass();

                mMapView.setAutoRotateEnabled(false, false);

                Mapcontainer.requestLayout();
            }
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

    /* MyLocation Listener */
    private final NMapLocationManager.OnLocationChangeListener onMyLocationChangeListener = new NMapLocationManager.OnLocationChangeListener() {

        @Override
        public boolean onLocationChanged(NMapLocationManager locationManager, NGeoPoint myLocation) {

            if (mMapController != null) {
                mMapController.animateTo(myLocation);
                //Toast.makeText(SeaRoad.this, "(테스트)위치 변화.", Toast.LENGTH_SHORT).show();
                mSeaRoute.CheckMylocationFromMarkerSea(mOverlayManager,mMapViewerResourceProvider,markerTest, distanceFromMarkerSea());

            }
            return true;
        }

        @Override
        public void onLocationUpdateTimeout(NMapLocationManager locationManager) {

            Toast.makeText(SeaRoad.this, "Your current location is temporarily unavailable.", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onLocationUnavailableArea(NMapLocationManager locationManager, NGeoPoint myLocation) {

            Toast.makeText(SeaRoad.this, "Your current location is unavailable area.", Toast.LENGTH_LONG).show();

            stopMyLocation();
        }

    };
}