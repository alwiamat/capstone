package com.example.sehaticapstoneproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.sehaticapstoneproject.adapter.ImagesAdapter

import com.example.sehaticapstoneproject.model.ImagesMenu
import kotlinx.android.synthetic.main.activity_hospital_list.*


class MainActivity : AppCompatActivity() {

    private var imageList =
        ArrayList<ImagesMenu>()
    private lateinit var rv:
            RecyclerView
    private lateinit var adapter:
            ImagesAdapter

    companion object {
        const val MENU_CHATBOT =
            "menu_chatbot"
        const val MENU_FORUM =
            "menu_forum"
        const val MENU_HOSPITALS =
            "menu_hospitals"
        const val MENU_TIPS =
            "menu_tips"
        const val MENU_PROFILE =
            "menu_profile"
        const val MENU_SETTINGS =
            "menu_settings"
    }

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById<View>(R.id.rec) as RecyclerView
        rv.setHasFixedSize(true)
        rv.layoutManager = GridLayoutManager(
            this, 2)

        getData()


    }

    private fun getData() {
        imageList.add(ImagesMenu(
            image = R.drawable.chatbot_menu_logo, type = MENU_CHATBOT)
        )
        imageList.add(ImagesMenu(
            image = R.drawable.forum_menu_logo, type = MENU_FORUM))
        imageList.add(ImagesMenu(
            image = R.drawable.hospitals_menu_logo, type = MENU_HOSPITALS))
        imageList.add(ImagesMenu(
            image = R.drawable.tips_menu_logo, type = MENU_TIPS))
        imageList.add(ImagesMenu(
            image = R.drawable.profil_menu_logo, type = MENU_PROFILE))
        imageList.add(ImagesMenu(
            image = R.drawable.setting_menu_logo, type = MENU_SETTINGS))

        adapter = ImagesAdapter(imageList, this)
        rv.adapter = adapter

        adapter.onItemClickCallback = (object : ImagesAdapter.OnItemClickCallback {
            override fun onItemClick(typeMenu: String) {
                runOnUiThread {
                    when (typeMenu) {
                        MENU_CHATBOT -> { val i = Intent(
                            this@MainActivity, ChannelActivity::class.java)
                            .apply {
                                putExtra(ChannelActivity.EXTRA_CHANNEL_USER_ID, ChannelActivity.CHATBOT_USER_ID)
                            }
                            // start activity, to chatbot page
                            startActivity(i)
                        }
                        MENU_FORUM -> { val i = Intent(
                            this@MainActivity, ForumActivity::class.java)

                            // start activity, to forum page
                            startActivity(i)
                        }
                        MENU_HOSPITALS -> { val i = Intent(
                            this@MainActivity, HospitalListActivity::class.java)

                            // start activity, to professional page
                            startActivity(i)
                        }
                        MENU_TIPS -> { val i = Intent(
                            this@MainActivity, TipsActivity::class.java)

                            // start activity, to info page
                            startActivity(i)
                        }
                        else -> { Toast.makeText(
                            this@MainActivity, "Fitur sedang dalam pengembangan",
                            Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        })
    }


}