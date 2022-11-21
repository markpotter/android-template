package com.noumenon.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.noumenon.template.ui.theme.AndroidTemplateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      AndroidTemplateTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          MainScreen("Android")
        }
      }
    }
  }
}

@Composable
fun MainScreen(name: String) {
  val viewModel: MainViewModel = hiltViewModel()
  val state by viewModel.greeting.collectAsState()
  Text(text = "$state $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  AndroidTemplateTheme {
    MainScreen("Android")
  }
}