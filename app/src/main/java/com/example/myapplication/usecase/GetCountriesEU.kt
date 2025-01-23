package com.example.myapplication.usecase

import com.example.myapplication.domain.Country


class GetCountriesEU(
    private val getCountries: GetCountries = GetCountries()
) {
    suspend operator fun invoke(): List<Country> {
        return getCountries()
            .filter { it.isEU }
    }

}