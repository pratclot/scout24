package com.example.myapplication.data

import com.example.myapplication.domain.Country

private const val CONTINENT_EU = "Europe"

data class CountryDto(
    val name: Name,
    val continents: List<String>,
    val capital: List<String>,
    val flags: Flags,
) {
    data class Name(val common: String)
    data class Flags(
        val png: String,
        val alt: String,
    )
}

fun CountryDto.toDomain() = Country(
    name = name.common,
    capital = capital.firstOrNull() ?: "n/a",
    flagURL = flags.png,
    isEU = continents.contains(CONTINENT_EU),
    flagDescription = flags.alt,
)