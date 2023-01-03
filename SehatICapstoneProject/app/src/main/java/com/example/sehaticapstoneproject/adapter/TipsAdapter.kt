package com.example.sehaticapstoneproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.sehaticapstoneproject.R
import com.example.sehaticapstoneproject.model.TipsModel
import com.google.android.material.imageview.ShapeableImageView

class TipsAdapter (
    private var tipsList: ArrayList<TipsModel>) : RecyclerView.Adapter<TipsAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): TipsAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.tips_list_layout,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: TipsAdapter.MyViewHolder, position: Int) {
        val currentItem = tipsList[position]
        holder.tipsImg.setImageResource(currentItem.img)
        holder.tipsTitle.text = currentItem.name
        holder.tipsDesc.text = currentItem.description

        val isVisible : Boolean = currentItem.expand
        holder.constraintLayout.visibility = if (isVisible) View.VISIBLE else View.GONE

        holder.tipsTitle.setOnClickListener{
            currentItem.expand = !currentItem.expand
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return tipsList.size
    }

    class MyViewHolder(itemView: View ) : RecyclerView.ViewHolder(itemView){

        val tipsImg : ShapeableImageView = itemView.findViewById(
            R.id.tipsimg)
        val tipsTitle : TextView = itemView.findViewById(
            R.id.tipstitle)
        val tipsDesc : TextView = itemView.findViewById(
            R.id.tipsdesc)
        val constraintLayout : ConstraintLayout = itemView.findViewById(
            R.id.expandedlayout)
    }
}