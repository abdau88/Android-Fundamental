package com.example.portofoliomahasiswa


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ListPortofolio(private val listPorto:ArrayList<Portofolio>) :  RecyclerView.Adapter<ListPortofolio.ListViewHolder>() {
    private lateinit var onItemClickCallback : OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_portofolio, parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (nama, username, avatar, follower, following, company, location,  repository)  = listPorto[position]
        Glide.with(holder.itemView.context)
            .load(avatar)
            .circleCrop()
            .into(holder.imgAvatar)
        holder.imgAvatar.setOnClickListener{ onItemClickCallback.onItemClicked(listPorto[holder.adapterPosition]) }
        holder.imgAvatar.setOnClickListener {
                v ->
            val portoParcel = Portofolio(nama,username,avatar, follower, following, company, location, repository)
            val intent = Intent(v.context, DetailUser::class.java)
            intent.putExtra(DetailUser.EXTRA_PORTO, portoParcel)
            v.context.startActivity(intent)
        }
        holder.tvNama.text  = nama
        holder.tvUsername.text = username

    }

    override fun getItemCount(): Int =listPorto.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar:  ImageView = itemView.findViewById(R.id.avatars)
        var tvNama  : TextView  = itemView.findViewById(R.id.tv_nama)
        var tvUsername : TextView = itemView.findViewById(R.id.tv_username)
    }
    interface OnItemClickCallback{
        fun onItemClicked(data:Portofolio)
    }

}