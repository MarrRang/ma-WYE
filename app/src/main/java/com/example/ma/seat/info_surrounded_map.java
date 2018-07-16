package com.example.ma.seat;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapOverlay;
import com.nhn.android.maps.NMapOverlayItem;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.maps.overlay.NMapPOIitem;
import com.nhn.android.mapviewer.overlay.NMapCalloutOverlay;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;

public class info_surrounded_map extends NMapActivity implements NMapPOIdataOverlay.OnStateChangeListener, NMapOverlayManager.OnCalloutOverlayListener {

    private NMapView mMapView;// 지도 화면 View
    private final String CLIENT_ID = "k5demHHl_LQIBQixdhi2";// 애플리케이션 클라이언트 아이디 값
    private NMapViewerResourceProvider mMapViewerResourceProvider;
    private NMapOverlayManager mOverlayManager;
    NMapPOIdataOverlay.OnStateChangeListener onPOIdataStateChangeListener; // 출처 : https://blog.naver.com/sojeong721/130157310831
    NMapOverlayManager.OnCalloutOverlayListener onCalloutOverlayListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMapView = new NMapView(this);
        setContentView(mMapView);
        mMapView.setClientId(CLIENT_ID); // 클라이언트 아이디 값 설정
        mMapView.setClickable(true);
        mMapView.setEnabled(true);
        mMapView.setFocusable(true);
        mMapView.setFocusableInTouchMode(true);
        mMapView.requestFocus();

        // create resource provider
        mMapViewerResourceProvider = new NMapViewerResourceProvider(this);

        // create overlay manager
        mOverlayManager = new NMapOverlayManager(this, mMapView, mMapViewerResourceProvider);

        int markerId = NMapPOIflagType.PIN;

        // set POI data
        NMapPOIdata poiData = new NMapPOIdata(2, mMapViewerResourceProvider);
        poiData.beginPOIdata(2);
        poiData.addPOIitem(127.0630205, 37.5091300, "Pizza 777-111", markerId, 0);
        poiData.addPOIitem(127.061, 37.70, "Pizza 123-456", markerId, 0);
        poiData.endPOIdata();

        // create POI data overlay
        NMapPOIdataOverlay poiDataOverlay = mOverlayManager.createPOIdataOverlay(poiData, null);

        poiDataOverlay.selectPOIitem(0, true);

        // show all POI data
        poiDataOverlay.showAllPOIdata(0);

        // set event listener to the overlay
        poiDataOverlay.setOnStateChangeListener(onPOIdataStateChangeListener);

        // register callout overlay listener to customize it.
        mOverlayManager.setOnCalloutOverlayListener(onCalloutOverlayListener);

        mOverlayManager.setOnCalloutOverlayViewListener(onCalloutOverlayViewListener);

    }

    public void onCalloutClick(NMapPOIdataOverlay poiDataOverlay, NMapPOIitem item) {
        // [[TEMP]] handle a click event of the callout
        Toast.makeText(info_surrounded_map.this, "onCalloutClick: " + item.getTitle(), Toast.LENGTH_LONG).show();

    }

    public void onFocusChanged(NMapPOIdataOverlay poiDataOverlay, NMapPOIitem item) {
        if (item != null) {
            Log.i("NMap", "onFocusChanged: " + item.toString());
        } else {
            Log.i("NMap", "onFocusChanged: ");
        }
    }

    public NMapCalloutOverlay onCreateCalloutOverlay(NMapOverlay itemOverlay, NMapOverlayItem overlayItem, Rect itemBounds) {
        // set your callout overlay
        return new NMapCalloutBasicOverlay(itemOverlay, overlayItem, itemBounds);
    }

    private final NMapOverlayManager.OnCalloutOverlayViewListener onCalloutOverlayViewListener =
            new NMapOverlayManager.OnCalloutOverlayViewListener() {

                @Override
                public View onCreateCalloutOverlayView(NMapOverlay itemOverlay,
                                                       NMapOverlayItem overlayItem, Rect itemBounds) {

                    if (overlayItem != null) {
                        // [TEST] 말풍선 오버레이를 뷰로 설정함
                        String title = overlayItem.getTitle();
                        if (title != null && title.length() > 5) {
                            return new NMapCalloutCustomOverlayView(info_surrounded_map.this,
                                    itemOverlay, overlayItem, itemBounds);
                        }
                    }
                    // null을 반환하면 말풍선 오버레이를 표시하지 않음
                    return null;
                }

            };
}