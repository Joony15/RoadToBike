package com.example.noddy.roadtobike;

import com.nhn.android.maps.overlay.NMapPathData;
import com.nhn.android.maps.overlay.NMapPathLineStyle;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPathDataOverlay;

/**
 * Created by noddy on 2016-07-08.
 *산악경로 paht를 관리하기 위한 클래스
 */
public class MountRoute {

    public void ExcuteRoute(NMapOverlayManager mOverlayManager)
    {
        /*산악경로*/
        NMapPathData pathData = new NMapPathData(9);
        pathData.initPathData();
        pathData.addPathPoint(128.2599500, 37.8741320, NMapPathLineStyle.TYPE_SOLID);//상남(출발)
        pathData.addPathPoint(128.27435, 37.870822, 0);
        pathData.addPathPoint(128.269329, 37.879325, 0);
        pathData.addPathPoint(128.281002, 37.875124, 0);
        pathData.addPathPoint(128.276947, 37.879342, 0);
        pathData.addPathPoint(128.280466, 37.875226, 0);
        pathData.addPathPoint(128.297567, 37.876818, 0);
        pathData.addPathPoint(128.298769, 37.869636, 0);
        pathData.addPathPoint(128.307867, 37.86801, 0);
        pathData.addPathPoint(128.3109455, 37.8749729, 0);//미산계곡
        pathData.addPathPoint(128.311729, 37.872211, 0);
        pathData.addPathPoint(128.315849, 37.866858, 0);
        pathData.addPathPoint(128.322372, 37.871059, 0);
        pathData.addPathPoint(128.341942, 37.85561, 0);
        pathData.addPathPoint(128.348379, 37.853102, 0);
        pathData.addPathPoint(128.347692, 37.845579, 0);
        pathData.addPathPoint(128.360224, 37.84097, 0);
        pathData.addPathPoint(128.452932, 37.824684, 0);//칡소 폭포
        pathData.addPathPoint(128.5133257, 37.8799347, 0);//구룡령
        pathData.addPathPoint(128.5033933, 37.9964677, 0);//조침령터널
        pathData.addPathPoint(128.4081958, 37.9634730, 0);//진동계곡
        pathData.addPathPoint(128.3375473, 37.9441227, 0);//방동계곡
        pathData.addPathPoint(128.2629901, 37.8808571, 0);//오미재
        pathData.addPathPoint(128.2599500, 37.8741320, NMapPathLineStyle.TYPE_SOLID);//상남(도착)
        pathData.endPathData();
        NMapPathDataOverlay pathDataOverlay = mOverlayManager.createPathDataOverlay(pathData);
        pathDataOverlay.showAllPathData(7);
    }
}
