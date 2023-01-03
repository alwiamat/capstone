package com.example.sehaticapstoneproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sehaticapstoneproject.adapter.TipsAdapter
import com.example.sehaticapstoneproject.model.TipsModel
import kotlinx.android.synthetic.main.activity_hospital_list.*
import kotlinx.android.synthetic.main.activity_tips.*

class TipsActivity : AppCompatActivity() {

    private lateinit var rv : RecyclerView
    private lateinit var list : ArrayList<TipsModel>


    lateinit var img : Array<Int>
    lateinit var title : Array<String>
    lateinit var des : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips)

        img = arrayOf(
            R.drawable.forum_polahidupsehat,
            R.drawable.tips_begadang,
            R.drawable.tips_vaksin,
            R.drawable.tips_olahraga,
            R.drawable.tips_istirahat

        )

        title = arrayOf(
            "Pentingnya Hidup Sehat",
            "Hindari Begadang",
            "Vaksin Itu Penting",
            "Pentingnya Olahraga Bagi Tubuh Dan Kesehatan",
            "Istirahat yang Cukup"

        )

        des = arrayOf(
            getString(R.string.tips_polahidup),
            getString(R.string.tips_begadang),
            getString(R.string.tips_vaksin),
            getString(R.string.tips_olahraga),
            getString(R.string.tips_itirahat)
        )

        rv = findViewById(R.id.recylerviewTips)
        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)


        list = arrayListOf<TipsModel>()
        getUserData()

        //back home
        toolbartips.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun getUserData() {
        for (i in img.indices){
            val forum = TipsModel(img[i],title[i],des[i])
            list.add(forum)
        }
        val adapter = TipsAdapter(list)
        rv.adapter = adapter
    }

}