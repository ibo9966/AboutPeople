package com.example.aboutpeople

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CustomAdapter(private val userList: ArrayList<User>,val context: Context) :
        RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
           val tvadsoyad : TextView = view.findViewById(R.id.tvadsoyad)
           val tvyas : TextView = view.findViewById(R.id.tvyas)
           val tvhakkinda : TextView = view.findViewById(R.id.tvhakkinda)
        }


        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.user_item_list, viewGroup, false)

            return ViewHolder(view)
        }

        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
           viewHolder.tvadsoyad.text= userList[position].adisoyadi
           viewHolder.tvyas.text= userList[position].yasi
           viewHolder.tvhakkinda.text= userList[position].kendinitanit

            viewHolder.itemView.setOnClickListener{
                //Seçili pozisyonu alalım
                var user = userList[position]
                var adisoyadi:String?= user.adisoyadi
                var yasi:String?= user.yasi
                var kendinitanit:String?= user.kendinitanit

                var intent = Intent(context,DetayActivity::class.java)
                intent.putExtra("putadisoyadi",adisoyadi)
                intent.putExtra("putyasi",yasi)
                intent.putExtra("putkendinitanit",kendinitanit)
                // Activity sayfamızı başlatalım
                context.startActivity(intent)
            }


        }

        override fun getItemCount() = userList.size

    }

