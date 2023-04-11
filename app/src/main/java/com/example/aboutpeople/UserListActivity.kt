package com.example.aboutpeople

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aboutpeople.databinding.ActivityUserListBinding
import com.google.firebase.database.*

class UserListActivity : AppCompatActivity() {
    lateinit var binding:ActivityUserListBinding
    private lateinit var dbref:DatabaseReference
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userArrayList:ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userRecyclerView=binding.userList

        userRecyclerView.layoutManager=LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf<User>()
        getUserData()

        binding.buttonkullaniciekle.setOnClickListener {
            val intent= Intent(this@UserListActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun getUserData() {
        dbref= FirebaseDatabase.getInstance().getReference("Users")
        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for(userSnapshot in snapshot.children){
                        val user = userSnapshot.getValue(User::class.java)
                        userArrayList.add(user!!)
                    }
                    userRecyclerView.adapter = CustomAdapter(userArrayList,this@UserListActivity)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}