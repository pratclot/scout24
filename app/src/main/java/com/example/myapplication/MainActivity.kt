package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.domain.Country
import com.example.myapplication.ui.activity.COUNTRY_TAG
import com.example.myapplication.ui.activity.SecondScreen
import com.example.myapplication.ui.component.CountryItem
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.usecase.GetCountriesEU
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val countriesList = MutableStateFlow(listOf<Country>())

    private val navigateToSecondScreen = { country: Country ->
        Intent(this, SecondScreen::class.java).apply {
            putExtra(COUNTRY_TAG, country)
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            countriesList.update {
                GetCountriesEU()()
            }
        }

        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val countries = countriesList.collectAsState()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyColumn(modifier = Modifier.padding(innerPadding)) {
                        items(
                            items = countries.value,
//                            key = { it.uniqueId() }
                        ) { item ->
                            CountryItem(
                                item = item,
                                onClick = { navigateToSecondScreen(item) }
                            )
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}