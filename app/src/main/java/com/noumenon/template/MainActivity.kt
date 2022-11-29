@file:OptIn(ExperimentalMaterial3WindowSizeClassApi::class, ExperimentalAnimationApi::class)

package com.noumenon.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.noumenon.template.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val navController = rememberAnimatedNavController() // hoist the NavController to the top of the composition graph
      // The content will be managed by the app's NavHost that is configured by our Navigation() composable
      Navigation(navController = navController, openDrawer = { /*TODO*/ }, windowSize = calculateWindowSizeClass(activity = this))
    }
  }
}
