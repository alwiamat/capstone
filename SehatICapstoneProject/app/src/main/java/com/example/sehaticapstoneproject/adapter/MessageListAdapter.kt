package com.example.sehaticapstoneproject.adapter

import android.text.format.DateFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sehaticapstoneproject.R
import com.example.sehaticapstoneproject.model.MessageModel
import com.example.sehaticapstoneproject.viewmodel.MessageViewHolder
import kotlin.collections.ArrayList


class MessageListAdapter : RecyclerView.Adapter<MessageViewHolder<MessageModel>>() {
    private var listMessages = ArrayList<MessageModel>()

    companion object {
        const val TYPE_MY_MESSAGE = 0
        const val TYPE_FRIEND_MESSAGE = 1
    }

    fun setMessages(messages: List<MessageModel>?) {
        if (messages == null) return
        this.listMessages.clear()
        this.listMessages.addAll(messages)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder<MessageModel> {
        return when (viewType) {
            TYPE_MY_MESSAGE -> { val view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_chat_me, parent, false)
                SentMessageHolder(view)
            }
            TYPE_FRIEND_MESSAGE -> { val view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_chat_other, parent, false)
                ReceivedMessageHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: MessageViewHolder<MessageModel>, position: Int) {
        val item = listMessages[position]
        Log.d("adapter View", position.toString() + item.message)
        when (holder) {
            is SentMessageHolder -> holder.bind(item)
            is ReceivedMessageHolder -> holder.bind(item)
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int = listMessages.size

    override fun getItemViewType(position: Int): Int = listMessages[position].type

    internal class SentMessageHolder(itemView: View) : MessageViewHolder<MessageModel>(itemView) {
        var messageText: TextView = itemView.findViewById<View>(
            R.id.text_gchat_message_me) as TextView
        var timeText: TextView = itemView.findViewById<View>(
            R.id.text_gchat_timestamp_me) as TextView

        override fun bind(item: MessageModel) {
            messageText.text = item.message


            val dayString = DateFormat.format("hh:mm", item.createdAt)

            timeText.text = dayString
        }

    }

    internal class ReceivedMessageHolder(itemView: View) : MessageViewHolder<MessageModel>(itemView) {
        var messageText: TextView = itemView.findViewById(
            R.id.text_gchat_message_other)
        var timeText: TextView = itemView.findViewById(
            R.id.text_gchat_timestamp_other)
        var nameText: TextView = itemView.findViewById(
            R.id.text_gchat_user_other)
        var profileImage: ImageView = itemView.findViewById(
            R.id.image_gchat_profile_other) as ImageView

        override fun bind(item: MessageModel) {
            messageText.text = item.message


            val dayString = DateFormat.format("hh:mm", item.createdAt)

            timeText.text = dayString
            nameText.text = item.nickname


            Glide.with(itemView.context)
                .load(item.profileUrl)
                .apply(
                    RequestOptions.placeholderOf(
                        R.drawable.ic_baseline_refresh_24)
                        .error(R.drawable.ic_baseline_error_24))
                .into(profileImage)
        }

    }
}