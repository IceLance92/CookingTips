package com.example.cookingtips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cookingtips.model.ReceptRepository
import com.example.cookingtips.ui.theme.CookingTipsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CookingTipsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    CookingTipsApp()
                }
                }
            }
        }
    }

@Composable
fun CookingTipsApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar()
        }
    ) { val recepts = ReceptRepository.recepts
        ReceptList(recepts = recepts, contentPadding = it)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge,
            )
        },
        modifier = modifier
    )
}
@Preview
@Composable
fun SuperReceptsPreview() {
    CookingTipsTheme(darkTheme = false) {
        CookingTipsApp()
    }
}

@Preview
@Composable
fun SuperReceptsDarkThemePreview() {
    CookingTipsTheme(darkTheme = true) {
        CookingTipsApp()
    }
}
