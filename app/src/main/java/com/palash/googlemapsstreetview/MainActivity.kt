package com.palash.googlemapsstreetview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback
import com.google.android.gms.maps.StreetViewPanorama
import com.google.android.gms.maps.StreetViewPanoramaView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.StreetViewPanoramaCamera
import com.google.android.gms.maps.model.StreetViewSource

class MainActivity : AppCompatActivity(), OnStreetViewPanoramaReadyCallback {

    private lateinit var panoramaView: StreetViewPanoramaView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        panoramaView = findViewById(R.id.streetViewPanoramaView)
        panoramaView.onCreate(savedInstanceState)

        // Initialize the StreetViewPanorama asynchronously
        panoramaView.getStreetViewPanoramaAsync(this)

    }

    override fun onStreetViewPanoramaReady(panorama: StreetViewPanorama) {
        // Set the initial location (e.g., Times Square, New York)
        val location = LatLng(22.329571, 87.686303)
        panorama.setPosition(location, StreetViewSource.OUTDOOR)

        // Set other configurations (e.g., zoom level)
        val camera = StreetViewPanoramaCamera.Builder().zoom(15f).build()
        panorama.animateTo(camera, 1000)
    }

    override fun onResume() {
        super.onResume()
        panoramaView.onResume()
    }

    override fun onPause() {
        super.onPause()
        panoramaView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        panoramaView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        panoramaView.onSaveInstanceState(outState)
    }
}