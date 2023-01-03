package com.example.sehaticapstoneproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.sehaticapstoneproject.R
import com.example.sehaticapstoneproject.model.ForumModel

import com.google.android.material.imageview.ShapeableImageView

class ForumAdapter (
    private var forumList: ArrayList<ForumModel>) : RecyclerView.Adapter<ForumAdapter.ForumViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
        ): ForumAdapter.ForumViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.forum_list_layout,parent,false)
            return ForumViewHolder(itemView)
        }

        override fun onBindViewHolder(
            holder: ForumAdapter.ForumViewHolder, position: Int) {
            val currentItem = forumList[position]
            holder.forumImg.setImageResource(currentItem.imgforum)
            holder.forumTitle.text = currentItem.nameforum
            holder.forumDesc.text = currentItem.descforum
            holder.forumLikes.text = currentItem.likesforum.toString()


            holder.forumTitle.setOnClickListener{

            }
        }

        override fun getItemCount(): Int {
            return forumList.size
        }

        class ForumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val forumImg : ImageView = itemView.findViewById(
                R.id.forumimg)
            val forumTitle : TextView = itemView.findViewById(
                R.id.forumtitle)
            val forumDesc : TextView = itemView.findViewById(
                R.id.forumdesc)
            val forumLikes : Button = itemView.findViewById(
                R.id.forumlikes)
        }
    }
