package com.noumenon.login

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class LoginViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle
) : ViewModel() {

  val state = savedStateHandle.getStateFlow("NAV_ARG", "").map {
    "Hello $it"
  }.stateIn(viewModelScope, SharingStarted.Eagerly, "Hello")

}