package com.example.myapplication.data

import org.junit.Test

/**
 * This test might not look like much, but it actually tests a little piece of logic hidden in `CountryDto.toDomain()` method - the processing of `capital` field.
 */
class CountryDtoKtTest {
    /**
     * Written almost entirely by Gemini :)
     */
    @Test
    fun `make sure empty fields are converted properly`() {
        val dto = CountryDto(
            name = CountryDto.Name(common = ""),
            continents = emptyList(),
            capital = emptyList(),
            flags = CountryDto.Flags(png = "png", alt = "alt"),
        )

        dto.toDomain().run {
            assert(name == "")
            assert(capital == "n/a")
            assert(flagURL == "png")
            assert(!isEU)
            assert(flagDescription == "alt")
        }
    }
}