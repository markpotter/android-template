package com.noumenon.template

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.noumenon.template.navigation.MainNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val handle: SavedStateHandle) : ViewModel() {
  val greetingState = handle.getStateFlow(MainNavigation.GREETING_ARG, "")
  val nameState = handle.getStateFlow(MainNavigation.NAME_ARG, "")
}