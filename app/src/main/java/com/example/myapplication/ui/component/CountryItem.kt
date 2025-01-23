package com.example.myapplication.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.myapplication.R
import com.example.myapplication.domain.Country
import com.example.myapplication.ui.util.imageLoader

@Composable
fun CountryItem(item: Country, modifier: Modifier = Modifier) = Row(
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically,
    modifier = modifier
        .fillMaxWidth()
        .padding(4.dp)
) {
    AsyncImage(
        contentDescription = item.flagDescription,
        model = ImageRequest.Builder(LocalContext.current)
            .data(item.flagURL)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.baseline_broken_image_24),
        contentScale = ContentScale.FillHeight,
        imageLoader = imageLoader(LocalContext.current),
        modifier = Modifier
            .width(32.dp)
            .fillMaxHeight()
    )
    Text(item.name)
    Text(item.capital)
}


@Preview
@Composable
private fun CountryItemPreview() = CountryItem(
    Country(
        name = "Germany",
        capital = "Dresden",
        flagURL = "none",
        isEU = true,
        flagDescription = "n/a"
    ),
    modifier = Modifier.background(Color.White)
)