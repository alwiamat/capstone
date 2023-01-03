package com.example.sehaticapstoneproject.network

import com.example.sehaticapstoneproject.model.HospitalListModel
import retrofit2.Call
import retrofit2.http.GET

interface APIHospital {
    @GET(
        "hospitals")
    fun getHospitalList() :
            Call<MutableList<HospitalListModel>>
}