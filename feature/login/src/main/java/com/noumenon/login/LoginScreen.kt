@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class, ExperimentalLayoutApi::class)

package com.noumenon.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.hilt.navigation.compose.hiltViewModel
import com.noumenon.common.ui.preview.ThemeGroupPreviews
import com.noumenon.common.ui.theme.AndroidTemplateTheme

@Composable
fun LoginScreen(onClickButton: (username: String, password: String?) -> Unit) {
  AndroidTemplateTheme {
    LoginContent(onClickButton)
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(onClickButton: (username: String, password: String?) -> Unit) {
  val viewModel: LoginViewModel = hiltViewModel()
  val loginState = viewModel.loginTypeState.collectAsState()
  val usernameState = viewModel.username.collectAsState()
  Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
    Column(modifier = Modifier.fillMaxSize()) {
      Text(text = "Login")
      val keyboardController = LocalSoftwareKeyboardController.current
      OutlinedTextField(
        value = usernameState.value,
        singleLine = true,
        label = {
          Text(text = "username")
        },
        onValueChange = viewModel::updateUsername,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go),
        keyboardActions = KeyboardActions(
          onGo = {
            if (usernameState.value.isNotBlank()) {
              onClickButton(usernameState.value, null)
            }
            keyboardController?.hide()
          }
        ))
      Button(onClick = { onClickButton(usernameState.value, null) }) {
        Text(text = "Continue")
      }
    }
  }
}

@ThemeGroupPreviews
@Composable
private fun PreviewLogin() {
  LoginScreen { _, _ -> }
}