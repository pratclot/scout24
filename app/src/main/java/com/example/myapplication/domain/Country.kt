package com.example.myapplication.domain

data class Country(
    val name: String,
    val capital: String,
    val flagURL: String,
    val isEU: Boolean,
    val flagDescription: String,
)

fun Country.uniqueId() = name + capital + flagURL + isEU + flagDescription

