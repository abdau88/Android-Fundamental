package com.example.portofoliomahasiswa

import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class DetailUser : AppCompatActivity() {

    companion object{
        const val EXTRA_PORTO="extra_porto"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val avaTemp: ImageView = findViewById(R.id.imageView2)
        val namaTemp: TextView = findViewById(R.id.tv_nama_detail)
        val userTemp: TextView = findViewById(R.id.tv_username_detail)
        val followerTemp: TextView = findViewById(R.id.tv_follower)
        val followingTemp: TextView = findViewById(R.id.tv_followwing)
        val companyTemp: TextView = findViewById(R.id.tv_company)
        val locationTemp: TextView = findViewById(R.id.tv_location)
        val repoTemp: TextView = findViewById(R.id.tv_repository)

        val getPorto = intent.getParcelableExtra<Portofolio>(EXTRA_PORTO) as Portofolio

        Glide.with(avaTemp)
            .load(getPorto.avatar)
            .circleCrop()
            .into(avaTemp)

        val getNama = getPorto.nama
        namaTemp.setText(getNama)

        val getUser = getPorto.username
        userTemp.setText(getUser)

        val getFlwr = getPorto.follower
        followerTemp.setText(getFlwr)

        val getFlwng = getPorto.following
        followingTemp.setText(getFlwng)

        val getComp = getPorto.company
        companyTemp.setText(getComp)

        val getLoc = getPorto.location
        locationTemp.setText(getLoc)

        val getRepo = getPorto.repository
        repoTemp.setText(getRepo)
    }
}