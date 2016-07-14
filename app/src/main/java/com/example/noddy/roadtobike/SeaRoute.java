package com.example.noddy.roadtobike;

import android.graphics.drawable.Drawable;
import android.util.Log;

import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.maps.overlay.NMapPathData;
import com.nhn.android.maps.overlay.NMapPathLineStyle;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;
import com.nhn.android.mapviewer.overlay.NMapPathDataOverlay;

/**
 * Created by noddy on 2016-07-08.
 *해안경로 paht를 관리하기 위한 클래스
 */
public class SeaRoute {
    public NGeoPoint[] forCheckedPoinSea = new NGeoPoint[8];
    public NMapPOIdata poiDataSea;
    public NMapPOIdata[] poiDataCheckedSea = new NMapPOIdata[1];
    public NMapPOIdata seaPoiData;
    public NMapPOIdataOverlay seaPoiDataOverlay;
    public int FlagForMarkerSea = 0;

    /*해안경로*/
    public void ExcuteSeaRoute(NMapOverlayManager mOverlayManager, NMapView MapViewForContext)
    {

        NMapPathLineStyle pathLineStyle = new NMapPathLineStyle(MapViewForContext.getContext());
        NMapPathData pathData = new NMapPathData(104);
        pathData.initPathData();

        pathData.addPathPoint(128.3755381, 38.5866220, NMapPathLineStyle.TYPE_SOLID);//통일전망대(출발)
        pathData.addPathPoint(128.40108, 38.55979, 0); pathData.addPathPoint(128.40095, 38.54230, 0); pathData.addPathPoint(128.41138, 38.52220, 0);
        pathData.addPathPoint(128.43236, 38.48790, 0); pathData.addPathPoint(128.42940, 38.48351, 0); pathData.addPathPoint(128.42460, 38.48337, 0);
        pathData.addPathPoint(128.42340, 38.46335, 0); pathData.addPathPoint(128.42957, 38.45112, 0); pathData.addPathPoint(128.44314, 38.44628, 0);
        pathData.addPathPoint(128.46803, 38.40593, 0);
        pathData.addPathPoint(128.46427, 38.39845, 0);//북천철교
        pathData.addPathPoint(128.48116, 38.37709, 0); pathData.addPathPoint(128.49451, 38.38053, 0); pathData.addPathPoint(128.50232, 38.37333, 0);
        pathData.addPathPoint(128.50309, 38.36256, 0); pathData.addPathPoint(128.52334, 38.33247, 0); pathData.addPathPoint(128.54854, 38.28220, 0);
        pathData.addPathPoint(128.54888, 38.27061, 0); pathData.addPathPoint(128.55506, 38.26576, 0); pathData.addPathPoint(128.55562, 38.25724, 0);
        pathData.addPathPoint(128.56326, 38.25101, 0);//봉포해변
        pathData.addPathPoint(128.57154, 38.23786, 0); pathData.addPathPoint(128.56485, 38.22586, 0);
        pathData.addPathPoint(128.56669, 38.20455, 0);//영금정
        pathData.addPathPoint(128.57778, 38.19673, 0); pathData.addPathPoint(128.58092, 38.18961, 0); pathData.addPathPoint(128.59968, 38.18967, 0);
        pathData.addPathPoint(128.60935, 38.15678, 0); pathData.addPathPoint(128.60774, 38.15108, 0); pathData.addPathPoint(128.62870, 38.11776, 0);
        pathData.addPathPoint(128.63329, 38.10401, 0); pathData.addPathPoint(128.62866, 38.09503, 0); pathData.addPathPoint(128.62780, 38.07881, 0);
        pathData.addPathPoint(128.64428, 38.06118, 0); pathData.addPathPoint(128.64480, 38.05523, 0); pathData.addPathPoint(128.65364, 38.04671, 0);
        pathData.addPathPoint(128.66128, 38.04440, 0);//동호해변
        pathData.addPathPoint(128.69046, 38.03455, 0); pathData.addPathPoint(128.69878, 38.03698, 0); pathData.addPathPoint(128.72895, 38.00950, 0);
        pathData.addPathPoint(128.75564, 37.98123, 0); pathData.addPathPoint(128.75841, 37.97146, 0); pathData.addPathPoint(128.75730, 37.96682, 0);
        pathData.addPathPoint(128.76352, 37.96496, 0); pathData.addPathPoint(128.78315, 37.94106, 0); pathData.addPathPoint(128.78315, 37.94106, 0);
        pathData.addPathPoint(128.80650, 37.91828, 0);//지경공원
        pathData.addPathPoint(128.82146, 37.89512, 0); pathData.addPathPoint(128.82032, 37.88160, 0); pathData.addPathPoint(128.83394, 37.87084, 0);
        pathData.addPathPoint(128.84334, 37.84963, 0); pathData.addPathPoint(128.84090, 37.84526, 0); pathData.addPathPoint(128.86220, 37.80196, 0);
        pathData.addPathPoint(128.86132, 37.79380, 0);
        pathData.addPathPoint(128.87452, 37.78440, 0);//경포해변
        pathData.addPathPoint(128.87199, 37.76139, 0); pathData.addPathPoint(128.89089, 37.74094, 0); pathData.addPathPoint(128.98956, 37.71542, 0);
        pathData.addPathPoint(128.99335, 37.69294, 0);
        pathData.addPathPoint(129.00814, 37.68336, 0);//정동진
        pathData.addPathPoint(128.99335, 37.69294, 0); pathData.addPathPoint(129.01940, 37.66067, 0); pathData.addPathPoint(129.01653, 37.64133, 0);
        pathData.addPathPoint(129.03543, 37.62312, 0); pathData.addPathPoint(129.03766, 37.61599, 0); pathData.addPathPoint(129.04290, 37.61384, 0);
        pathData.addPathPoint(129.05513, 37.61792, 0); pathData.addPathPoint(129.06281, 37.61548, 0); pathData.addPathPoint(129.06284, 37.61356, 0);
        pathData.addPathPoint(129.08831, 37.59211, 0);//망상해변
        pathData.addPathPoint(129.10030, 37.58442, 0); pathData.addPathPoint(129.09733, 37.57425, 0); pathData.addPathPoint(129.10093, 37.56184, 0);
        pathData.addPathPoint(129.09620, 37.54106, 0); pathData.addPathPoint(129.10504, 37.52687, 0); pathData.addPathPoint(129.10206, 37.52199, 0);
        pathData.addPathPoint(129.10440, 37.51812, 0); pathData.addPathPoint(129.10355, 37.50570, 0); pathData.addPathPoint(129.11058, 37.50171, 0);
        pathData.addPathPoint(129.11340, 37.47757, 0); pathData.addPathPoint(129.11340, 37.47757, 0);
        pathData.addPathPoint(129.14318, 37.46819, 0);//추암촛대바위
        pathData.addPathPoint(129.15300, 37.46475, 0); pathData.addPathPoint(129.15843, 37.45952, 0); pathData.addPathPoint(129.17731, 37.45342, 0);
        pathData.addPathPoint(129.17838, 37.44068, 0); pathData.addPathPoint(129.18336, 37.43601, 0); pathData.addPathPoint(129.17954, 37.43021, 0);
        pathData.addPathPoint(129.18751, 37.42727, 0); pathData.addPathPoint(129.18911, 37.42452, 0); pathData.addPathPoint(129.19156, 37.42292, 0);
        pathData.addPathPoint(129.19267, 37.41849, 0);
        pathData.addPathPoint(129.19751, 37.41380, 0);//한재공원
        pathData.addPathPoint(129.22012, 37.38473, 0); pathData.addPathPoint(129.24518, 37.34223, 0); pathData.addPathPoint(129.24827, 37.33124, 0);
        pathData.addPathPoint(129.26132, 37.32687, 0); pathData.addPathPoint(129.26681, 37.31800, 0); pathData.addPathPoint(129.29256, 37.30264, 0);
        pathData.addPathPoint(129.29703, 37.28748, 0); pathData.addPathPoint(129.30955, 37.27355, 0); pathData.addPathPoint(129.33204, 37.25811, 0);
        pathData.addPathPoint(129.33984, 37.23639, 0);//임원
        pathData.endPathData();

        /*경로 라인 두께*/
        pathLineStyle.setLineWidth(14);
        pathLineStyle.setLineColor(0x0000e6,500);

        pathData.setPathLineStyle(pathLineStyle);
        NMapPathDataOverlay pathDataOverlay = mOverlayManager.createPathDataOverlay(pathData);
        //pathDataOverlay.showAllPathData(12);

    }
    /*주요 경로 마커*/
    public void ExcuteSeaPoint(NMapOverlayManager mOverlayManager, NMapViewerResourceProvider mMapViewerResourceProvider, int markeRoute)
    {

        seaPoiData = new NMapPOIdata(12, mMapViewerResourceProvider);
        seaPoiData.beginPOIdata(12);
        seaPoiData.addPOIitem(128.3755381, 38.5866220, "통일전망대", markeRoute, 0);
        seaPoiData.addPOIitem(128.46427, 38.39845, "북천철교", markeRoute,0);
        seaPoiData.addPOIitem(128.56326, 38.25101, "봉포해변", markeRoute, 0);
        seaPoiData.addPOIitem(128.56669, 38.20455, "영금정", markeRoute,0);
        seaPoiData.addPOIitem(128.66128, 38.04440, "동호해변", markeRoute, 0);
        seaPoiData.addPOIitem(128.80650, 37.91828, "지경공원", markeRoute,0);
        seaPoiData.addPOIitem(128.87452, 37.78440, "경포해변", markeRoute, 0);
        seaPoiData.addPOIitem(129.00814, 37.68336, "정동진", markeRoute, 0);
        seaPoiData.addPOIitem(129.08831, 37.59211, "망상해변", markeRoute, 0);
        seaPoiData.addPOIitem(129.14318, 37.46819, "추암촛대바위", markeRoute, 0);
        seaPoiData.addPOIitem(129.19751, 37.41380, "한재공원", markeRoute, 0);
        seaPoiData.addPOIitem(129.33984, 37.23639, "임원", markeRoute, 0);
        seaPoiData.endPOIdata();
        seaPoiDataOverlay = mOverlayManager.createPOIdataOverlay(seaPoiData, null);
        forCheckedPoinSea[0] = new NGeoPoint(128.2599500, 37.8741320);
        forCheckedPoinSea[1] = new NGeoPoint(128.31100, 37.87288);
        forCheckedPoinSea[2] = new NGeoPoint(128.452932, 37.824684);
        forCheckedPoinSea[3] = new NGeoPoint(128.5133257, 37.8799347);
        forCheckedPoinSea[4] = new NGeoPoint(128.5033933, 37.9964677);
        forCheckedPoinSea[5] = new NGeoPoint(128.4081958, 37.9634730);
        forCheckedPoinSea[6] = new NGeoPoint(128.3375473, 37.9441227);
        forCheckedPoinSea[7] = new NGeoPoint(128.2629901, 37.8808571);

    }
    public void CheckMylocationFromMarkerSea(NMapOverlayManager mOverlayManager, NMapViewerResourceProvider mMapViewerResourceProvider, Drawable Mountdistance, double distanceFromMarker)
    {
        poiDataCheckedSea[0] = new NMapPOIdata(12, mMapViewerResourceProvider);

        if(distanceFromMarker < 200.0 && FlagForMarkerSea == 0)
        {

            poiDataCheckedSea[0].beginPOIdata(12);
            poiDataCheckedSea[0].addPOIitem(128.3755381, 38.5866220, "통일전망대", Mountdistance, 0);
            poiDataCheckedSea[0].endPOIdata();
            seaPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiDataCheckedSea[0], null);
            Log.i("TAG", ""+FlagForMarkerSea);
            FlagForMarkerSea = 1;
        }
        else if(distanceFromMarker < 200.0 && FlagForMarkerSea == 1)
        {
            poiDataCheckedSea[0].beginPOIdata(12);
            poiDataCheckedSea[0].addPOIitem(128.3755381, 38.5866220, "통일전망대", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.46427, 38.39845, "북천철교", Mountdistance,0);
            poiDataCheckedSea[0].endPOIdata();
            seaPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiDataCheckedSea[0], null);
            FlagForMarkerSea = 2;
        }
        else if(distanceFromMarker < 200.0 && FlagForMarkerSea == 2)
        {
            poiDataCheckedSea[0].beginPOIdata(12);
            poiDataCheckedSea[0].addPOIitem(128.3755381, 38.5866220, "통일전망대", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.46427, 38.39845, "북천철교", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.56326, 38.25101, "봉포해변", Mountdistance, 0);
            poiDataCheckedSea[0].endPOIdata();
            seaPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiDataCheckedSea[0], null);
            FlagForMarkerSea = 3;
        }
        else if(distanceFromMarker < 200.0 && FlagForMarkerSea == 3)
        {
            poiDataCheckedSea[0].beginPOIdata(12);
            poiDataCheckedSea[0].addPOIitem(128.3755381, 38.5866220, "통일전망대", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.46427, 38.39845, "북천철교", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.56326, 38.25101, "봉포해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.56669, 38.20455, "영금정", Mountdistance,0);
            poiDataCheckedSea[0].endPOIdata();
            seaPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiDataCheckedSea[0], null);
            FlagForMarkerSea = 4;
        }
        else if(distanceFromMarker < 200.0 && FlagForMarkerSea == 4)
        {
            poiDataCheckedSea[0].beginPOIdata(12);
            poiDataCheckedSea[0].addPOIitem(128.3755381, 38.5866220, "통일전망대", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.46427, 38.39845, "북천철교", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.56326, 38.25101, "봉포해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.56669, 38.20455, "영금정", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.66128, 38.04440, "동호해변", Mountdistance, 0);
            poiDataCheckedSea[0].endPOIdata();
            seaPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiDataCheckedSea[0], null);
            FlagForMarkerSea = 5;

        }
        else if(distanceFromMarker < 200.0 && FlagForMarkerSea == 5)
        {
            poiDataCheckedSea[0].beginPOIdata(12);
            poiDataCheckedSea[0].addPOIitem(128.3755381, 38.5866220, "통일전망대", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.46427, 38.39845, "북천철교", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.56326, 38.25101, "봉포해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.56669, 38.20455, "영금정", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.66128, 38.04440, "동호해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.80650, 37.91828, "지경공원", Mountdistance,0);
            poiDataCheckedSea[0].endPOIdata();
            seaPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiDataCheckedSea[0], null);
            FlagForMarkerSea = 6;
        }
        else if(distanceFromMarker < 200.0 && FlagForMarkerSea == 6)
        {
            poiDataCheckedSea[0].beginPOIdata(12);
            poiDataCheckedSea[0].addPOIitem(128.3755381, 38.5866220, "통일전망대", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.46427, 38.39845, "북천철교", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.56326, 38.25101, "봉포해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.56669, 38.20455, "영금정", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.66128, 38.04440, "동호해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.80650, 37.91828, "지경공원", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.87452, 37.78440, "경포해변", Mountdistance, 0);
            poiDataCheckedSea[0].endPOIdata();
            seaPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiDataCheckedSea[0], null);
            FlagForMarkerSea = 7;
        }
        else if(distanceFromMarker < 200.0 && FlagForMarkerSea == 7)
        {
            poiDataCheckedSea[0].beginPOIdata(12);
            poiDataCheckedSea[0].addPOIitem(128.3755381, 38.5866220, "통일전망대", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.46427, 38.39845, "북천철교", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.56326, 38.25101, "봉포해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.56669, 38.20455, "영금정", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.66128, 38.04440, "동호해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.80650, 37.91828, "지경공원", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.87452, 37.78440, "경포해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(129.00814, 37.68336, "정동진", Mountdistance, 0);
            poiDataCheckedSea[0].endPOIdata();
            seaPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiDataCheckedSea[0], null);
            FlagForMarkerSea = 8;
        }
        else if(distanceFromMarker < 200.0 && FlagForMarkerSea == 8)
        {
            poiDataCheckedSea[0].beginPOIdata(12);
            poiDataCheckedSea[0].addPOIitem(128.3755381, 38.5866220, "통일전망대", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.46427, 38.39845, "북천철교", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.56326, 38.25101, "봉포해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.56669, 38.20455, "영금정", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.66128, 38.04440, "동호해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.80650, 37.91828, "지경공원", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.87452, 37.78440, "경포해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(129.00814, 37.68336, "정동진", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(129.08831, 37.59211, "망상해변", Mountdistance, 0);
            poiDataCheckedSea[0].endPOIdata();
            seaPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiDataCheckedSea[0], null);
            FlagForMarkerSea = 9;
        }
        else if(distanceFromMarker < 200.0 && FlagForMarkerSea == 9)
        {
            poiDataCheckedSea[0].beginPOIdata(12);
            poiDataCheckedSea[0].addPOIitem(128.3755381, 38.5866220, "통일전망대", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.46427, 38.39845, "북천철교", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.56326, 38.25101, "봉포해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.56669, 38.20455, "영금정", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.66128, 38.04440, "동호해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.80650, 37.91828, "지경공원", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.87452, 37.78440, "경포해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(129.00814, 37.68336, "정동진", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(129.08831, 37.59211, "망상해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(129.14318, 37.46819, "추암촛대바위", Mountdistance, 0);
            poiDataCheckedSea[0].endPOIdata();
            seaPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiDataCheckedSea[0], null);
            FlagForMarkerSea = 10;
        }
        else if(distanceFromMarker < 200.0 && FlagForMarkerSea == 10)
        {
            poiDataCheckedSea[0].beginPOIdata(12);
            poiDataCheckedSea[0].addPOIitem(128.3755381, 38.5866220, "통일전망대", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.46427, 38.39845, "북천철교", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.56326, 38.25101, "봉포해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.56669, 38.20455, "영금정", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.66128, 38.04440, "동호해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.80650, 37.91828, "지경공원", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.87452, 37.78440, "경포해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(129.00814, 37.68336, "정동진", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(129.08831, 37.59211, "망상해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(129.14318, 37.46819, "추암촛대바위", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(129.19751, 37.41380, "한재공원", Mountdistance, 0);
            poiDataCheckedSea[0].endPOIdata();
            seaPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiDataCheckedSea[0], null);
            FlagForMarkerSea = 11;
        }
        else if(distanceFromMarker < 200.0 && FlagForMarkerSea == 11)
        {
            poiDataCheckedSea[0].beginPOIdata(12);
            poiDataCheckedSea[0].addPOIitem(128.3755381, 38.5866220, "통일전망대", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.46427, 38.39845, "북천철교", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.56326, 38.25101, "봉포해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.56669, 38.20455, "영금정", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.66128, 38.04440, "동호해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(128.80650, 37.91828, "지경공원", Mountdistance,0);
            poiDataCheckedSea[0].addPOIitem(128.87452, 37.78440, "경포해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(129.00814, 37.68336, "정동진", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(129.08831, 37.59211, "망상해변", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(129.14318, 37.46819, "추암촛대바위", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(129.19751, 37.41380, "한재공원", Mountdistance, 0);
            poiDataCheckedSea[0].addPOIitem(129.33984, 37.23639, "임원", Mountdistance, 0);
            poiDataCheckedSea[0].endPOIdata();
            seaPoiDataOverlay = mOverlayManager.createPOIdataOverlay(poiDataCheckedSea[0], null);
            FlagForMarkerSea = 12;
        }
    }

}