package com.proyecto.ev2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proyecto.ev2.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCamara.setOnClickListener{
            val intent = Intent(this, CamaraActivity::class.java)
            startActivity(intent)
        }

        binding.btnMapa.setOnClickListener {
            /*val addressUri = Uri.parse("geo:0,0?q=-12.1582295,-76.9809178")
            val intent = Intent(Intent.ACTION_VIEW, addressUri)
            intent.setPackage("com.google.android.apps.maps")
            intent.resolveActivity(packageManager).let {
                startActivity(intent)
            }*/
            val intent = Intent(this, MapaActivity::class.java)
            startActivity(intent)
        }
    }
}