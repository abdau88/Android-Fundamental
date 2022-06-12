package com.example.portofoliomahasiswa


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), View.OnClickListener {
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
            val dataNama  = resources.getStringArray(R.array.data_nama)
            val dataUsername = resources.getStringArray(R.array.data_username)
            val dataAvatar  = resources.getStringArray(R.array.data_avatar)
            val dataFollower = resources.getStringArray(R.array.data_follower)
            val dataFollowing = resources.getStringArray(R.array.data_following)
            val dataCompany = resources.getStringArray(R.array.data_company)
            val dataLocation = resources.getStringArray(R.array.data_location)
            val dataRepository = resources.getStringArray(R.array.data_repository)

            val listPorto = ArrayList<Portofolio>()
            for (i in dataNama.indices){
                val portofolio  = Portofolio(dataNama[i],dataUsername[i],dataAvatar[i],dataFollower[i],
                                    dataFollowing[i],dataCompany[i],dataLocation[i],dataRepository[i])
                listPorto.add(portofolio)
            }
            return listPorto
        }
    private fun showRecyclerlist(){
        rvPortofolio.layoutManager=LinearLayoutManager(this)
        val listPortofolio = ListPortofolio(list)
        rvPortofolio.adapter = listPortofolio

        listPortofolio.setOnItemClickCallback(object : ListPortofolio.OnItemClickCallback{
           override fun onItemClicked(data: Portofolio) {

           }
        })
    }

    override fun onClick(v: View?) {

    }
}




