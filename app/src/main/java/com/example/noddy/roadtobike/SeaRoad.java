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
import android.widget.LinearLayout;
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
        mSeaRoute.ExcuteRoute(mOverlayManager,mMapView);

        /*주요 경로 마커*/
        poiData = new NMapPOIdata(12, mMapViewerResourceProvider);
        poiData.beginPOIdata(12);
        poiData.addPOIitem(128.3755381, 38.5866220, "통일전망대", markerId, 0);
        poiData.addPOIitem(128.4742254, 38.4014101, "북천철교", markerId,0);
        poiData.addPOIitem(128.5659670, 38.2528608, "봉포해변", markerId, 0);
        poiData.addPOIitem(128.6015368, 38.2118321, "영금정", markerId,0);
        poiData.addPOIitem(128.6837662, 38.0579154, "동호해변", markerId, 0);
        poiData.addPOIitem(128.8078130, 37.9186260, "지경공원", markerId,0);
        poiData.addPOIitem(128.9082081, 37.8054954, "경포해변", markerId, 0);
        poiData.addPOIitem(129.0317609, 37.6925307, "정동진", markerId, 0);
        poiData.addPOIitem(129.0900515, 37.5940179, "망상해변", markerId, 0);
        poiData.addPOIitem(129.1600848, 37.4791928, "추암촛대바위", markerId, 0);
        poiData.addPOIitem(129.1965547, 37.4134425, "한재공원", markerId, 0);
        poiData.addPOIitem(129.3440000, 37.2342850, "임원", markerId, 0);
        poiData.endPOIdata();
        poiDataOverlay = mOverlayManager.createPOIdataOverlay(poiData, null);

        /*Button MountRoadpage*/
        Wifi_Btn = (Button) findViewById(R.id.seawifi_btn);
        Toilet_Btn = (Button) findViewById(R.id.seatoilet_btn);
        Light_Btn = (Button) findViewById(R.id.sealight_btn);
        back_Btn = (Button) findViewById(R.id.seaback_btn);
        Wifi_Btn.setOnClickListener(this);
        Toilet_Btn.setOnClickListener(this);
        Light_Btn.setOnClickListener(this);
        back_Btn.setOnClickListener(this);

    }

    public void onMapInitHandler(NMapView mapView, NMapError errorInfo) {
        if (errorInfo == null) { // success
            Toast.makeText(SeaRoad.this, "(테스트)지도 초기화 성공.", Toast.LENGTH_SHORT).show();
            stopMyLocation();

            mMapController.setMapCenter(new NGeoPoint(128.8078130, 37.9186260), 5);
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
                Toast.makeText(SeaRoad.this, "(테스트)와이파이정상적인 클릭.", Toast.LENGTH_SHORT).show();
                startMyLocation();
                //poiDataOverlay.showAllPOIdata(0);
                break;
            case R.id.seatoilet_btn:
                ////여기다 버튼 이벤트 코딩
                stopMyLocation();
                Toast.makeText(SeaRoad.this, "(테스트)화장실정상적인 클릭.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sealight_btn:
                //여기다 버튼 이벤트 코딩
                Toast.makeText(SeaRoad.this, "(테스트)전기시간정상적인 클릭.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.seaback_btn:
                //여기다 버튼 이벤트 코딩
                Toast.makeText(SeaRoad.this, "(테스트)뒤로가기정상적인 클릭.", Toast.LENGTH_SHORT).show();
                break;
        }
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