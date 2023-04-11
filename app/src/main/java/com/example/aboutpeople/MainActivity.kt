package com.example.aboutpeople

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.aboutpeople.databinding.ActivityMainBinding
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonKaydet.setOnClickListener {
            var etadsoyad = binding.etadsoyad.text.toString().trim()   // eğer girilen verinin başında sonunda boşluk varsa onu temizler.
            var etyas = binding.etyas.text.toString().trim()
            var etkendinitanit = binding.etkendinitanit.text.toString().trim()

            if (TextUtils.isEmpty(etadsoyad)){
                binding.etadsoyad.error="Lütfen boş bırakmayınız."
            }

            if (TextUtils.isEmpty(etyas)){
                binding.etyas.error="Lütfen boş bırakmayınız."
            }

            if (TextUtils.isEmpty(etkendinitanit)){
                binding.etkendinitanit.error="Lütfen boş bırakmayınız."
            }

            else{
                var database = FirebaseDatabase.getInstance()
                var databaseReference = database.reference.child("Users")
                var id = databaseReference.push()

                id.child("id").setValue(id.key.toString())
                id.child("adisoyadi").setValue(etadsoyad)
                id.child("yasi").setValue(etyas)
                id.child("kendinitanit").setValue(etkendinitanit)
                Toast.makeText(this,"Kayıt Başarılı",Toast.LENGTH_SHORT).show()
            }
        }
        binding.buttonKayitlariGoster.setOnClickListener {
            val intent=Intent(this@MainActivity,UserListActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}