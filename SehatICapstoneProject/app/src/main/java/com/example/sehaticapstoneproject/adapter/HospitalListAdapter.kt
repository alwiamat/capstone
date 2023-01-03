package com.example.sehaticapstoneproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sehaticapstoneproject.R
import com.example.sehaticapstoneproject.model.HospitalListModel
import kotlinx.android.synthetic.main.hospital_list_layout.view.*

class HospitalListAdapter(var context: Context,
                          var hospitalModelList : MutableList<HospitalListModel>):
    RecyclerView.Adapter<HospitalListAdapter.MyViewModel>(){
    inner class MyViewModel(itemView: View) : RecyclerView.ViewHolder(itemView){
        var txtHospitalName : TextView
        var txtHospitalAdress : TextView
        var txtHospitalRegion : TextView
        var txtHospitalPhone : TextView

        init {
            txtHospitalName = itemView.findViewById(
                R.id.txtName)
            txtHospitalAdress = itemView.findViewById(
                R.id.txtAddress)
            txtHospitalRegion = itemView.findViewById(
                R.id.txtRegion)
            txtHospitalPhone = itemView.findViewById(
                R.id.txtPhone)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        return MyViewModel(LayoutInflater.from(context).inflate(
            R.layout.hospital_list_layout,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        holder.txtHospitalName.text = hospitalModelList[position].name
        holder.txtHospitalAdress.text = hospitalModelList[position].address
        holder.txtHospitalRegion.text = hospitalModelList[position].region
        holder.txtHospitalPhone.text = hospitalModelList[position].phone
    }

    override fun getItemCount(): Int {
        return hospitalModelList.size
    }
}