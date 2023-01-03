package com.example.sehaticapstoneproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sehaticapstoneproject.R
import com.example.sehaticapstoneproject.model.ImagesMenu

class ImagesAdapter(private val menuList: List<ImagesMenu>, private val ct: Context) :
    RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {
    lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(
                R.layout.images_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menu: ImagesMenu = menuList[position]

        Glide.with(ct)
            .load(menu.image)
            .apply(
                RequestOptions.placeholderOf(
                    R.drawable.ic_baseline_refresh_24).error(R.drawable.ic_baseline_error_24))
            .into(holder.imageView)

        holder.imageView.setOnClickListener {
            onItemClickCallback.onItemClick(menu.type)
        }
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById<View>(R.id.image) as ImageView
    }

    interface OnItemClickCallback {
        fun onItemClick(typeMenu: String)
    }
}
