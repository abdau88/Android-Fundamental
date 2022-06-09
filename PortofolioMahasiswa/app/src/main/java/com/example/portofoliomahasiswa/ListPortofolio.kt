package com.example.portofoliomahasiswa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ListPortofolio(private val listPorto:ArrayList<Portofolio>) :  RecyclerView.Adapter<ListPortofolio.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_portofolio, parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (nama, username, avatar)  = listPorto[position]
        holder.imgAvatar.setImageResource(avatar)
        holder.tvNama.text  = nama
        holder.tvUsername.text = username
    }

    override fun getItemCount(): Int =listPorto.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar:  ImageView = itemView.findViewById(R.id.avatars)
        var tvNama  : TextView  = itemView.findViewById(R.id.tv_nama)
        var tvUsername : TextView = itemView.findViewById(R.id.tv_username)
    }
}