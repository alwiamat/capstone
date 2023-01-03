package com.example.sehaticapstoneproject.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.sehaticapstoneproject.network.APIHospital
import com.example.sehaticapstoneproject.network.Common
import com.example.sehaticapstoneproject.model.HospitalListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HospitalListRepo {
    private val apiCovid: APIHospital

    companion object {
        private const val TAG = "CovidRepo"
    }

    init {
        apiCovid = Common.getAPIHospital
    }

    val getCovidStatModelLiveData: MutableLiveData<MutableList<HospitalListModel>>
        get() {
            val data: MutableLiveData<MutableList<HospitalListModel>> =
                MutableLiveData<MutableList<HospitalListModel>>()
            apiCovid.getHospitalList().enqueue(object : Callback<MutableList<HospitalListModel>> {
                override fun onResponse(
                    call: Call<MutableList<HospitalListModel>>,
                    response: Response<MutableList<HospitalListModel>>
                ) {
                    Log.e(TAG, "OnResponse: " + response.code())
                    if (response.isSuccessful) {
                        data.value = response.body()
                    } else {
                        data.value = null!!
                    }
                }

                override fun onFailure(
                    call: Call<MutableList<HospitalListModel>>, t: Throwable) {
                    Log.e(TAG, "OnResponse" + t.message)
                    data.value = null!!
                }
            })
            return data

        }
}