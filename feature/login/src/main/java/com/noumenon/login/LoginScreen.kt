package com.noumenon.login

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.noumenon.common.ui.preview.ThemeGroupPreviews
import com.noumenon.common.ui.theme.AndroidTemplateTheme

@Composable
fun LoginScreen() {
  AndroidTemplateTheme {
    LoginContent()
  }
}

@Composable
fun LoginContent() {
  val viewModel: LoginViewModel = hiltViewModel()
  val state = viewModel.state.collectAsState()
  Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
    Text(text = "$state")
  }
}

@ThemeGroupPreviews
@Composable
private fun PreviewLogin() {
  LoginScreen()
}