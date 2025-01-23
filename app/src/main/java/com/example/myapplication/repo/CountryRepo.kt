package com.example.myapplication.repo

import com.example.myapplication.CountriesService
import com.example.myapplication.data.toDomain
import com.example.myapplication.domain.Country

class CountryRepo(
    private val countriesService: CountriesService = CountriesService.provide(),
) {
    suspend fun getCountries(): List<Country> {
        return countriesService.getCountriesNamesFlags()
            .map { it.toDomain() }
    }
}