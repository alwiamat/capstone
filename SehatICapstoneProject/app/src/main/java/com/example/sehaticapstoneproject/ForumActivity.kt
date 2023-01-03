package com.example.sehaticapstoneproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sehaticapstoneproject.R
import com.example.sehaticapstoneproject.adapter.ForumAdapter
import com.example.sehaticapstoneproject.adapter.TipsAdapter
import com.example.sehaticapstoneproject.model.ForumModel
import com.example.sehaticapstoneproject.model.TipsModel
import kotlinx.android.synthetic.main.activity_forum.*
import kotlinx.android.synthetic.main.activity_hospital_list.*

class ForumActivity : AppCompatActivity() {
    private lateinit var rvforum : RecyclerView
    private lateinit var list : ArrayList<ForumModel>


    lateinit var imgf : Array<Int>
    lateinit var titlef : Array<String>
    lateinit var desf : Array<String>
    lateinit var likesf : Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum)

        imgf = arrayOf(
            R.drawable.forum_merokok,
            R.drawable.forum_olahraga,
            R.drawable.forum_tidur,
            R.drawable.forum_covid,
            R.drawable.forum_stres
        )

        titlef = arrayOf(
            "Merokok Sebaiknya Ditinggalkan",
            "Olahraga Banyak Manfaatnya,Harus Setiap Hari?",
            "Tidur di Kamar Terang Berbahaya untuk Kesehatan",
            "COVID-19 RI diprediksi 'Ngegas' Lagi Gegara Ada Varian Baru",
            "Mengenal Burnout, Stres Kerja Melulu Sampai Lupa Bahagia"
        )

        desf = arrayOf(
            "Banyak perokok yang terus merokok karena " +
                    "\nbelum mengetahui bahaya zat yang terkandung",
            "Kebugaran fisik kerap kali menjadi prioritas, " +
                    "\ntetapi seberapa sering kita harus berolahraga? ",
            "Ada beberapa variabel yang dapat membuat " +
                    "\n tidur yang lebih baik,lebih nyaman",
            "Peningkatan kasus harian COVID-19 pada"  +
                    "\n Daerah Istimewa Yogyakarta, Banten, Jawa" +
                    "\nTimur ,DKI Jakarta, dan Jawa Barat.",
            "Burnout merupakan salah satu jenis kelelahan yang " +
                    "\nberkaitan dengan pekerjaan."


        )

        likesf = arrayOf(
            131,
            231,
            69,
            300,
            170
        )

        rvforum = findViewById(R.id.recylerviewForum)
        rvforum.layoutManager = LinearLayoutManager(this)
        rvforum.setHasFixedSize(true)


        list = arrayListOf<ForumModel>()
        getUserData()

        //back home
        toolbarforunmlist.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun getUserData() {
        for (i in imgf.indices){
            val forum = ForumModel(imgf[i],titlef[i],desf[i],likesf[i])
            list.add(forum)
        }
        val adapter = ForumAdapter(list)
        rvforum.adapter = adapter
    }

}