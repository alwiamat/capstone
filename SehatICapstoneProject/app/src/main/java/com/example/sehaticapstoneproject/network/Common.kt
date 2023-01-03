package com.example.sehaticapstoneproject.network

object Common {
    private const val BASE_URL = "https://dekontaminasi.com/api/id/covid19/"
    val getAPIHospital : APIHospital
        get() = Retrofit.getRetrofitClient(BASE_URL).create(APIHospital::class.java)
}