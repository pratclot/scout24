package com.example.myapplication.usecase

import com.example.myapplication.domain.Country
import com.example.myapplication.repo.CountryRepo

class GetCountries(
    private val countryRepo: CountryRepo = CountryRepo(),
) {
    suspend operator fun invoke(): List<Country> {
        return countryRepo.getCountries()
    }

}