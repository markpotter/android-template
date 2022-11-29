package com.noumenon.login

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noumenon.login.navigation.LoginNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class LoginViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle
) : ViewModel() {

  val loginTypeState = savedStateHandle.getStateFlow(LoginNavigation.LOGIN_TYPE_ARG, LoginNavigation.LOGIN_TYPE_PASSWORD).stateIn(viewModelScope, SharingStarted.Eagerly, LoginNavigation.LOGIN_TYPE_PASSWORD)
  private val _username = MutableStateFlow("")
  val username = _username.stateIn(viewModelScope, SharingStarted.Eagerly, "")
  fun updateUsername(usernameText: String) {
    _username.value = usernameText
  }

}