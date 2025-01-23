package com.example.myapplication.data

import com.example.myapplication.domain.Country

private const val CONTINENT_EU = "Europe"
private const val MAGIC_LAT_LNG = 20.0

data class CountryDto(
    val name: Name,
    val continents: List<String>,
    val capital: List<String>,
    val flags: Flags,
    val capitalInfo: CapitalInfo,
) {
    data class Name(val common: String)
    data class Flags(
        val png: String,
        val alt: String,
    )
    data class CapitalInfo(
        val latlng: List<Double>
    )
}

fun CountryDto.toDomain() = Country(
    name = name.common,
    capital = capital.firstOrNull() ?: "n/a",
    flagURL = flags.png,
    isEU = continents.contains(CONTINENT_EU),
    flagDescription = flags.alt,
    lat = capitalInfo.latlng.firstOrNull() ?: MAGIC_LAT_LNG,
    lng = capitalInfo.latlng.lastOrNull() ?: MAGIC_LAT_LNG,
)