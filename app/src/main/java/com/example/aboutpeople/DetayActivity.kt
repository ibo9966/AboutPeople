package com.example.aboutpeople

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aboutpeople.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {
    lateinit var binding:ActivityDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        var adisoyadi = intent.getStringExtra("putadisoyadi")
        var yasi = intent.getStringExtra("putyasi")
        var kendinitanit = intent.getStringExtra("putkendinitanit")

        //tasarim elemanlarımıza aktaralım
        binding.detayadsoyad.text = adisoyadi.toString()
        binding.detayyasi.text=yasi.toString()
        binding.detaykendinitanit.text=kendinitanit.toString()
    }
}