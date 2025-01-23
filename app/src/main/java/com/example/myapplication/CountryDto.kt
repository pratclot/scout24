package com.example.myapplication

data class CountryDto(
    val name: Name,
    val continents: List<String>
) {
    data class Name(val common: String)
}