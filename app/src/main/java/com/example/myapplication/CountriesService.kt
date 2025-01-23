package com.example.myapplication

import com.example.myapplication.data.CountryDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface CountriesService {

    @Headers("Content-Type: application/json")
    @GET("v3.1/all")
    suspend fun getCountries(): List<CountryDto>

    @Headers("Content-Type: application/json")
    @GET("v3.1/all?fields=name,flags,continents,capital,capitalInfo")
    suspend fun getCountriesNamesFlags(): List<CountryDto>

    companion object {
        fun provide(): CountriesService {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://restcountries.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(CountriesService::class.java)
        }
    }
}
