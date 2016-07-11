package com.example.noddy.roadtobike;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.Toast;

import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.maps.overlay.NMapPOIitem;
import com.nhn.android.maps.overlay.NMapPathData;
import com.nhn.android.maps.overlay.NMapPathLineStyle;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;
import com.nhn.android.mapviewer.overlay.NMapPathDataOverlay;

/**
 * Created by noddy on 2016-07-08.
 *산악경로 paht를 관리하기 위한 클래스
 */
public class MountRoute {
    public NGeoPoint[] forCheckedPoin = new NGeoPoint[8];
    public NMapPOIdata poiData;
    public NMapPOIdata[] poiDataChecked = new NMapPOIdata[1];
    public NMapPOIdataOverlay mountPoiDataOverlay;
    public int FlagForMarker = 0;

    public void ExcuteMountRoute(NMapOverlayManager mOverlayManager,NMapView MapViewForContext)
    {
        /*산악경로*/
        NMapPathLineStyle pathLineStyle = new NMapPathLineStyle(MapViewForContext.getContext());
        NMapPathData pathData = new NMapPathData(109);
        pathData.initPathData();

        pathData.addPathPoint(128.2599500, 37.8741320, NMapPathLineStyle.TYPE_SOLID);//상남(출발)
        pathData.addPathPoint(128.25903, 37.87258, 0);pathData.addPathPoint(128.25975, 37.87187, 0);pathData.addPathPoint(128.26337, 37.87292, 0);
        pathData.addPathPoint(128.27435, 37.870822, 0);pathData.addPathPoint(128.27308, 37.87514, 0);pathData.addPathPoint(128.26872, 37.87959, 0);pathData.addPathPoint(128.27612, 37.87949, 0);

        pathData.addPathPoint(128.276947, 37.879342, 0);pathData.addPathPoint(128.280466, 37.875226, 0);pathData.addPathPoint(128.297567, 37.876818, 0);
        pathData.addPathPoint(128.298769, 37.869636, 0);pathData.addPathPoint(128.307867, 37.86801, 0);pathData.addPathPoint(128.31100, 37.87288, 0);//미산계곡
        pathData.addPathPoint(128.31229, 37.86888, 0);pathData.addPathPoint(128.31581, 37.86678, 0);pathData.addPathPoint(128.31988, 37.87223, 0);

        pathData.addPathPoint(128.322372, 37.871059, 0);pathData.addPathPoint(128.341942, 37.85561, 0);pathData.addPathPoint(128.34819, 37.85579, 0);//
        pathData.addPathPoint(128.34568, 37.84973, 0);pathData.addPathPoint(128.34688, 37.84635, 0);pathData.addPathPoint(128.34894, 37.84600, 0);
        pathData.addPathPoint(128.34969, 37.84303, 0);pathData.addPathPoint(128.35148, 37.84163, 0);pathData.addPathPoint(128.36153, 37.84086, 0);

        pathData.addPathPoint(128.35864, 37.83543, 0);pathData.addPathPoint(128.36743, 37.84013, 0);pathData.addPathPoint(128.37185, 37.83313, 0);//
        pathData.addPathPoint(128.37593, 37.83482, 0);pathData.addPathPoint(128.37520, 37.83170, 0);pathData.addPathPoint(128.37795, 37.83364, 0);
        pathData.addPathPoint(128.37924, 37.83143, 0);pathData.addPathPoint(128.38670, 37.83187, 0);pathData.addPathPoint(128.38838, 37.82937, 0);

        pathData.addPathPoint(128.39163, 37.83022, 0);pathData.addPathPoint(128.40123, 37.82824, 0);pathData.addPathPoint(128.39842, 37.83125, 0);
        pathData.addPathPoint(128.40335, 37.83333, 0);pathData.addPathPoint(128.40305, 37.83553, 0);pathData.addPathPoint(128.41696, 37.82760, 0);
        pathData.addPathPoint(128.42305, 37.83484, 0);pathData.addPathPoint(128.43687, 37.82610, 0);pathData.addPathPoint(128.44691, 37.82859, 0);

        pathData.addPathPoint(128.45600, 37.82488, 0);pathData.addPathPoint(128.45953, 37.82872, 0);pathData.addPathPoint(128.46863, 37.82259, 0);
        pathData.addPathPoint(128.46966, 37.83272, 0);pathData.addPathPoint(128.47489, 37.83106, 0);pathData.addPathPoint(128.48386, 37.84584, 0);
        pathData.addPathPoint(128.51373, 37.85265, 0);pathData.addPathPoint(128.50931, 37.85917, 0);pathData.addPathPoint(128.51369, 37.86003, 0);

        pathData.addPathPoint(128.51382, 37.86237, 0);pathData.addPathPoint(128.51721, 37.86352, 0);pathData.addPathPoint(128.51309, 37.86759, 0);
        pathData.addPathPoint(128.51523, 37.87206, 0);pathData.addPathPoint(128.51326, 37.87347, 0);pathData.addPathPoint(128.51635, 37.88289, 0);
        pathData.addPathPoint(128.52141, 37.88648, 0);pathData.addPathPoint(128.52004, 37.89149, 0);pathData.addPathPoint(128.52485, 37.89278, 0);

        pathData.addPathPoint(128.52502, 37.89657, 0);pathData.addPathPoint(128.53000, 37.89698, 0);pathData.addPathPoint(128.53137, 37.90050, 0);
        pathData.addPathPoint(128.53444, 37.90380, 0);pathData.addPathPoint(128.53279, 37.90213, 0);pathData.addPathPoint(128.53261, 37.90446, 0);
        pathData.addPathPoint(128.52581, 37.90670, 0);pathData.addPathPoint(128.52813, 37.90411, 0);pathData.addPathPoint(128.51978, 37.90682, 0);

        pathData.addPathPoint(128.51017, 37.91127, 0);pathData.addPathPoint(128.50708, 37.90632, 0);pathData.addPathPoint(128.49283, 37.93440, 0);
        pathData.addPathPoint(128.52734, 37.98326, 0);pathData.addPathPoint(128.52150, 37.99072, 0);pathData.addPathPoint(128.51223, 37.99110, 0);pathData.addPathPoint(128.50914, 37.99760, 0);
        pathData.addPathPoint(128.49506, 37.99435, 0);pathData.addPathPoint(128.48996, 37.98267, 0);pathData.addPathPoint(128.47961, 37.97568, 0);pathData.addPathPoint(128.46125, 37.98123, 0);

        pathData.addPathPoint(128.40099, 37.96188, 0);pathData.addPathPoint(128.38932, 37.94956, 0);pathData.addPathPoint(128.36700, 37.95809, 0);
        pathData.addPathPoint(128.35533, 37.95240, 0);pathData.addPathPoint(128.34280, 37.95714, 0);pathData.addPathPoint(128.33387, 37.94550, 0);
        pathData.addPathPoint(128.31774, 37.94793, 0);pathData.addPathPoint(128.31263, 37.93591, 0);pathData.addPathPoint(128.30285, 37.93280, 0);pathData.addPathPoint(128.29954, 37.94062, 0);

        pathData.addPathPoint(128.29268, 37.92630, 0);pathData.addPathPoint(128.29062, 37.92379, 0);pathData.addPathPoint(128.29173, 37.91391, 0);
        pathData.addPathPoint(128.28418, 37.91005, 0);pathData.addPathPoint(128.26744, 37.88885, 0);pathData.addPathPoint(128.26718, 37.88737, 0);
        pathData.addPathPoint(128.26435, 37.88554, 0);pathData.addPathPoint(128.26246, 37.88636, 0);pathData.addPathPoint(128.26439, 37.88259, 0);

        pathData.addPathPoint(128.26534, 37.88250, 0);pathData.addPathPoint(128.26233, 37.88155, 0);pathData.addPathPoint(128.26053, 37.88263, 0);
        pathData.addPathPoint(128.25843, 37.87691, 0);pathData.addPathPoint(128.25650, 37.87494, 0);pathData.addPathPoint(128.25695, 37.87385, 0);
        pathData.addPathPoint(128.25885, 37.87268, 0);pathData.addPathPoint(128.2599500, 37.8741320, NMapPathLineStyle.TYPE_SOLID);//상남(도착)
        pathData.endPathData();

        /*경로 라인 두께*/
        pathLineStyle.setLineWidth(14);
        pathData.setPathLineStyle(pathLineStyle);
        NMapPathDataOverlay pathDataOverlay = mOverlayManager.createPathDataOverlay(pathData);
        pathDataOverlay.showAllPathData(7);
    }

    public void ExcuteMountPoint(NMapOverlayManager mOverlayManager, NMapViewerResourceProvider mMapViewerResourceProvider, int markeRoute)
    {

        /*주요 경로 마커*/
        poiData = new NMapPOIdata(8, mMapViewerResourceProvider);
        poiData.beginPOIdata(8);
        poiData.addPOIitem(128.2599500, 37.8741320, "상남", markeRoute, 0);
        poiData.addPOIitem(128.31100, 37.87288, "미산계곡", markeRoute,0);
        poiData.addPOIitem(128.452932, 37.824684,"칡소 폭포",markeRoute,0);
        poiData.addPOIitem(128.5133257, 37.8799347, "구룡령", markeRoute, 0);
        poiData.addPOIitem(128.5033933, 37.9964677, "조침터미널", markeRoute,0);
        poiData.addPOIitem(128.4081958, 37.9634730, "진동계곡", markeRoute, 0);
        poiData.addPOIitem(128.3375473, 37.9441227, "방동계곡", markeRoute,0);
        poiData.addPOIitem(128.2629901, 37.8808571, "오미재", markeRoute, 0);
        poiData.endPOIdata();
        mountPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiData, null);
        forCheckedPoin[0] = new NGeoPoint(128.2599500, 37.8741320);
        forCheckedPoin[1] = new NGeoPoint(128.31100, 37.87288);
        forCheckedPoin[2] = new NGeoPoint(128.452932, 37.824684);
        forCheckedPoin[3] = new NGeoPoint(128.5133257, 37.8799347);
        forCheckedPoin[4] = new NGeoPoint(128.5033933, 37.9964677);
        forCheckedPoin[5] = new NGeoPoint(128.4081958, 37.9634730);
        forCheckedPoin[6] = new NGeoPoint(128.3375473, 37.9441227);
        forCheckedPoin[7] = new NGeoPoint(128.2629901, 37.8808571);

    }


    public void CheckMylocationFromMarker(NMapOverlayManager mOverlayManager, NMapViewerResourceProvider mMapViewerResourceProvider,  Drawable Mountdistance,double distanceFromMarker)
    {
        poiDataChecked[0] = new NMapPOIdata(8, mMapViewerResourceProvider);

        if(distanceFromMarker >200.0 && FlagForMarker == 0)
        {

            poiDataChecked[0].beginPOIdata(8);
            poiDataChecked[0].addPOIitem(128.2599500, 37.8741320, "상남", Mountdistance, 0);
            poiDataChecked[0].endPOIdata();
            mountPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiDataChecked[0], null);
            Log.i("TAG", ""+FlagForMarker);

            FlagForMarker = 1;
        }
        else if(distanceFromMarker < 200.0 && FlagForMarker == 1)
        {
            poiDataChecked[0].beginPOIdata(8);
            poiDataChecked[0].addPOIitem(128.2599500, 37.8741320, "상남", Mountdistance, 0);
            poiDataChecked[0].addPOIitem(128.31100, 37.87288, "미산계곡", Mountdistance,0);
            poiDataChecked[0].endPOIdata();
            mountPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiDataChecked[0], null);
            FlagForMarker = 2;
        }
        else if(distanceFromMarker < 200.0 && FlagForMarker == 2)
        {
            poiDataChecked[0].beginPOIdata(8);
            poiDataChecked[0].addPOIitem(128.2599500, 37.8741320, "상남", Mountdistance, 0);
            poiDataChecked[0].addPOIitem(128.31100, 37.87288, "미산계곡", Mountdistance,0);
            poiDataChecked[0].addPOIitem(128.452932, 37.824684,"칡소 폭포",Mountdistance,0);
            poiDataChecked[0].endPOIdata();
            mountPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiData, null);
            FlagForMarker = 3;
        }
        else if(distanceFromMarker < 200.0 && FlagForMarker == 3)
        {
            poiDataChecked[0].beginPOIdata(8);
            poiDataChecked[0].addPOIitem(128.2599500, 37.8741320, "상남", Mountdistance, 0);
            poiDataChecked[0].addPOIitem(128.31100, 37.87288, "미산계곡", Mountdistance,0);
            poiDataChecked[0].addPOIitem(128.452932, 37.824684,"칡소 폭포",Mountdistance,0);
            poiDataChecked[0].addPOIitem(128.5133257, 37.8799347, "구룡령", Mountdistance, 0);
            poiDataChecked[0].endPOIdata();
            mountPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiData, null);
            FlagForMarker = 4;
        }
        else if(distanceFromMarker < 200.0 && FlagForMarker == 4)
        {
            poiDataChecked[0].beginPOIdata(8);
            poiDataChecked[0].addPOIitem(128.2599500, 37.8741320, "상남", Mountdistance, 0);
            poiDataChecked[0].addPOIitem(128.31100, 37.87288, "미산계곡", Mountdistance,0);
            poiDataChecked[0].addPOIitem(128.452932, 37.824684,"칡소 폭포",Mountdistance,0);
            poiDataChecked[0].addPOIitem(128.5133257, 37.8799347, "구룡령", Mountdistance, 0);
            poiDataChecked[0].addPOIitem(128.5033933, 37.9964677, "조침터미널", Mountdistance,0);
            poiDataChecked[0].endPOIdata();
            mountPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiData, null);
            FlagForMarker = 5;

        }
        else if(distanceFromMarker < 200.0 && FlagForMarker == 5)
        {
            poiDataChecked[0].beginPOIdata(8);
            poiDataChecked[0].addPOIitem(128.2599500, 37.8741320, "상남", Mountdistance, 0);
            poiDataChecked[0].addPOIitem(128.31100, 37.87288, "미산계곡", Mountdistance,0);
            poiDataChecked[0].addPOIitem(128.452932, 37.824684,"칡소 폭포",Mountdistance,0);
            poiDataChecked[0].addPOIitem(128.5133257, 37.8799347, "구룡령", Mountdistance, 0);
            poiDataChecked[0].addPOIitem(128.5033933, 37.9964677, "조침터미널", Mountdistance,0);
            poiDataChecked[0].addPOIitem(128.4081958, 37.9634730, "진동계곡", Mountdistance, 0);
            poiDataChecked[0].endPOIdata();
            mountPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiData, null);
            FlagForMarker = 6;
        }
        else if(distanceFromMarker < 200.0 && FlagForMarker == 6)
        {
            poiDataChecked[0].beginPOIdata(8);
            poiDataChecked[0].addPOIitem(128.2599500, 37.8741320, "상남", Mountdistance, 0);
            poiDataChecked[0].addPOIitem(128.31100, 37.87288, "미산계곡", Mountdistance,0);
            poiDataChecked[0].addPOIitem(128.452932, 37.824684,"칡소 폭포",Mountdistance,0);
            poiDataChecked[0].addPOIitem(128.5133257, 37.8799347, "구룡령", Mountdistance, 0);
            poiDataChecked[0].addPOIitem(128.5033933, 37.9964677, "조침터미널", Mountdistance,0);
            poiDataChecked[0].addPOIitem(128.4081958, 37.9634730, "진동계곡", Mountdistance, 0);
            poiDataChecked[0].addPOIitem(128.3375473, 37.9441227, "방동계곡", Mountdistance,0);
            poiDataChecked[0].endPOIdata();
            mountPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiData, null);
            FlagForMarker = 7;
        }
        else if(distanceFromMarker < 200.0 && FlagForMarker == 7)
        {
            poiDataChecked[0].beginPOIdata(8);
            poiDataChecked[0].addPOIitem(128.2599500, 37.8741320, "상남", Mountdistance, 0);
            poiDataChecked[0].addPOIitem(128.31100, 37.87288, "미산계곡", Mountdistance,0);
            poiDataChecked[0].addPOIitem(128.452932, 37.824684,"칡소 폭포",Mountdistance,0);
            poiDataChecked[0].addPOIitem(128.5133257, 37.8799347, "구룡령", Mountdistance, 0);
            poiDataChecked[0].addPOIitem(128.5033933, 37.9964677, "조침터미널", Mountdistance,0);
            poiDataChecked[0].addPOIitem(128.4081958, 37.9634730, "진동계곡", Mountdistance, 0);
            poiDataChecked[0].addPOIitem(128.3375473, 37.9441227, "방동계곡", Mountdistance,0);
            poiDataChecked[0].addPOIitem(128.2629901, 37.8808571, "오미재", Mountdistance, 0);
            poiDataChecked[0].endPOIdata();
            mountPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiData, null);
            FlagForMarker = 8;
        }
    }
}