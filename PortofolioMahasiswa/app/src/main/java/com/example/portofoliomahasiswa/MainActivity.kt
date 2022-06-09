package com.example.portofoliomahasiswa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPortofolio: RecyclerView
    private val list= ArrayList<Portofolio>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPortofolio=findViewById(R.id.rv_portofolio)
        rvPortofolio.setHasFixedSize(true)

        list.addAll(listPorto)
        showRecyclerlist()
    }
    private val listPorto :  ArrayList<Portofolio>
        get() {
            val  dataNama  = resources.getStringArray(R.array.data_nama)
            val dataUsername = resources.getStringArray(R.array.data_username)
            val dataAvatar  = resources.obtainTypedArray(R.array.data_avatar)
            val listPorto = ArrayList<Portofolio>()
            for (i in dataNama.indices){
                val portofolio  = Portofolio(dataNama[i],dataUsername[i],dataAvatar.getResourceId(i, -1))
                listPorto.add(portofolio)
            }
            return listPorto
        }
    private fun showRecyclerlist(){
        rvPortofolio.layoutManager=LinearLayoutManager(this)
        val listPortofolio = ListPortofolio(list)
        rvPortofolio.adapter = listPortofolio
    }
}