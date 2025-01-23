package com.example.myapplication.usecase

import com.example.myapplication.CountriesService
import com.example.myapplication.CountryDto

class GetCountries(
    private val countriesService: CountriesService = CountriesService.provide()
) {
    suspend operator fun invoke(): List<CountryDto> {
        return countriesService.getCountriesNamesFlags()
    }

}