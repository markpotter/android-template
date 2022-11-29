package com.noumenon.template

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.noumenon.common.ui.preview.ThemeGroupPreviews
import com.noumenon.common.ui.theme.AndroidTemplateTheme
import com.noumenon.login.navigation.LoginNavigation

@Composable
fun MainScreen(buttonClick: (loginType: Int) -> Unit) {
  val viewModel: MainViewModel = hiltViewModel()
  val greeting by viewModel.greetingState.collectAsState()
  val name by viewModel.nameState.collectAsState()
  AndroidTemplateTheme {
    // A surface container using the 'background' color from the theme
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
      Column(modifier = Modifier.fillMaxSize()) {
        // Display the greeting and name emitted by the ViewModel. These values are part
        // of the navigation route to this screen. They can be null which will be the case if this
        // screen is used as the NavHost's default content.
        Text(text = "$greeting $name")
        // This is an example of a click handler that needs to navigate to a new destination. In
        // such a case the handler should be passed to the screen composable when it is navigated
        // to, and the lambda should have access to the NavController.
        Button(onClick = { buttonClick(LoginNavigation.LOGIN_TYPE_PASSWORD) }) {
          Text(text = "button")
        }
      }
    }
  }
}

@ThemeGroupPreviews
@Composable
private fun PreviewMainScreen() {
  MainScreen({})
}