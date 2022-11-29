@file:OptIn(ExperimentalAnimationApi::class)

package com.noumenon.template.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.noumenon.common.ui.navigation.navFadeIn
import com.noumenon.common.ui.navigation.navFadeOut
import com.noumenon.common.ui.navigation.navSlideIn
import com.noumenon.common.ui.navigation.navSlideOut
import com.noumenon.login.navigation.addLoginScreen
import com.noumenon.login.navigation.navigateToLoginScreen

/**
 * The NavHost responsible for displaying navigation destination content.
 *
 * @param navController the NavController this NavHost will link to host's navigation graph.
 * @param openDrawer the callback for the opening the drawer.
 * @param windowSize
 * @param modifier
 */
@Composable
fun Navigation(
  navController: NavHostController,
  openDrawer: () -> Unit,
  windowSize: WindowSizeClass,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current //use this context to get the strings for navdrawer UI items.
  AnimatedNavHost(
    navController = navController,
    startDestination = MainNavigation.route,
    modifier = modifier,
    enterTransition = { navSlideIn() },
    exitTransition = { navFadeOut() },
    popEnterTransition = { navFadeIn() },
    popExitTransition = { navSlideOut() }
  ) {

    // add destinations to this NavHost's NavGraph

    addMainScreen { loginType -> navController.navigateToLoginScreen(loginType) }

    addLoginScreen { username, password ->
      navController.navigateToMainScreen("Welcome", username)
/*
      navController.previousBackStackEntry?.savedStateHandle?.set(MainNavigation.GREETING_ARG, "Hello")
      navController.previousBackStackEntry?.savedStateHandle?.set(MainNavigation.NAME_ARG, username)
      navController.popBackStack()
*/
    }

  }
}