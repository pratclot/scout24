package com.example.myapplication.usecase

import com.example.myapplication.CountryDto

const val CONTINENT_EU = "Europe"

class GetCountriesEU(
    private val getCountries: GetCountries = GetCountries()
) {
    suspend operator fun invoke(): List<CountryDto> {
        return getCountries()
            .filter { it.continents.contains(CONTINENT_EU) }
    }

}