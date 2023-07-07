package com.proyecto.ev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.proyecto.ev2.databinding.ActivityMapaBinding

class MapaActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMapaBinding
    private lateinit var map: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentMap = supportFragmentManager.findFragmentById(R.id.fragment_map) as SupportMapFragment
        fragmentMap.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        val mallDelSur = LatLng(-12.1551628, -76.9820102591244)
        val plazaNorte = LatLng(-12.00629745, -77.0587862806646)
        val larcomar = LatLng(-12.1322691, -77.0301445867153)
        map.addMarker(MarkerOptions().title("Mall Del Sur").position(mallDelSur))
        map.addMarker(MarkerOptions().title("Larcomar").position(larcomar))
        map.addMarker(MarkerOptions().title("Plaza Norte").position(plazaNorte))

        val bounds = LatLngBounds.builder()
        bounds.include(mallDelSur)
        bounds.include(plazaNorte)
        bounds.include(larcomar)
        map.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds.build(), 150))
    }
}