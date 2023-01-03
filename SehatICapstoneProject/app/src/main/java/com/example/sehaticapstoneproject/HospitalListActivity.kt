package com.example.sehaticapstoneproject

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sehaticapstoneproject.adapter.HospitalListAdapter
import com.example.sehaticapstoneproject.viewmodel.HospitalListViewModel
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_channel.*
import kotlinx.android.synthetic.main.activity_hospital_list.*


class HospitalListActivity : AppCompatActivity() {

    var hospitalListViewModel : HospitalListViewModel? = null
    var recyclerView : RecyclerView? = null
    var adapter : HospitalListAdapter? = null
    var layoutmanager : LinearLayoutManager? = null
    var dialog : AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            R.layout.activity_hospital_list)

        //back home
        toolbarhospitallist.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        hospitalListViewModel = ViewModelProvider(this)[HospitalListViewModel::class.java]

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()
        dialog!!.show()

        recyclerView = findViewById(
            R.id.recylerviewcovid)
        recyclerView!!.setHasFixedSize(true)
        layoutmanager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutmanager

        hospitalListViewModel!!.getHospitalList.observe(this){covidstatModels ->
            Log.e("CovidStat", "HospitalList" + covidstatModels.get(0).name)

            if (covidstatModels != null){
                adapter = HospitalListAdapter(this,covidstatModels)
                adapter!!.notifyDataSetChanged()
                recyclerView!!.adapter = adapter
                dialog!!.dismiss()
            }
        }
    }
}