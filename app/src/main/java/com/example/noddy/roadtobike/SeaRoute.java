package com.example.noddy.roadtobike;

import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.overlay.NMapPathData;
import com.nhn.android.maps.overlay.NMapPathLineStyle;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPathDataOverlay;

/**
 * Created by noddy on 2016-07-08.
 *해안경로 paht를 관리하기 위한 클래스
 */
public class SeaRoute {
    public void ExcuteRoute(NMapOverlayManager mOverlayManager, NMapView MapViewForContext)
    {
        /*해안경로*/
        NMapPathLineStyle pathLineStyle = new NMapPathLineStyle(MapViewForContext.getContext());
        NMapPathData pathData = new NMapPathData(12);
        pathData.initPathData();

        pathData.addPathPoint(128.3755381, 38.5866220, NMapPathLineStyle.TYPE_SOLID);//통일전망대(출발)
        pathData.addPathPoint(128.4742254, 38.4014101, 0);//북천철교
        pathData.addPathPoint(128.5659670, 38.2528608, 0);//봉포해변
        pathData.addPathPoint(128.6015368, 38.2118321, 0);//영금정
        pathData.addPathPoint(128.6837662, 38.0579154, 0);//동호해변
        pathData.addPathPoint(128.8078130, 37.9186260, 0);//지경공원
        pathData.addPathPoint(128.9082081, 37.8054954, 0);//경포해변
        pathData.addPathPoint(129.0317609, 37.6925307, 0);//정동진
        pathData.addPathPoint(129.0900515, 37.5940179, 0);//망상해변
        pathData.addPathPoint(129.1600848, 37.4791928, 0);//추암촛대바위
        pathData.addPathPoint(129.1965547, 37.4134425, 0);//한재공원
        pathData.addPathPoint(129.3440000, 37.2342850, 0);//임원
        pathData.endPathData();

        /*경로 라인 두께*/
        pathLineStyle.setLineWidth(14);
        pathData.setPathLineStyle(pathLineStyle);
        NMapPathDataOverlay pathDataOverlay = mOverlayManager.createPathDataOverlay(pathData);
        pathDataOverlay.showAllPathData(12);
    }
}