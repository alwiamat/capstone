package com.example.sehaticapstoneproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sehaticapstoneproject.model.HospitalListModel
import com.example.sehaticapstoneproject.repositories.HospitalListRepo

class HospitalListViewModel : ViewModel() {
    private val hospitalRepo: HospitalListRepo
    val getHospitalList : LiveData<MutableList<HospitalListModel>>
        get() = hospitalRepo.getCovidStatModelLiveData

    init{
        hospitalRepo = HospitalListRepo()
    }
}