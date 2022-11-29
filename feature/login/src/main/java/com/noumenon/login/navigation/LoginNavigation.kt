package com.noumenon.login.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import com.noumenon.common.ui.navigation.NavInfo
import com.noumenon.common.ui.navigation.navFadeIn
import com.noumenon.common.ui.navigation.navFadeOut
import com.noumenon.login.LoginScreen

object LoginNavigation : NavInfo() {
  const val LOGIN_TYPE_PASSWORD = 1
  const val LOGIN_TYPE_THIRD_PARTY = 2
  const val LOGIN_TYPE_NONE = 3
  const val LOGIN_TYPE_ARG = "LOGIN_TYPE_ARG"
  override val route: String = "login/{$LOGIN_TYPE_ARG}"

  override val navArguments = listOf(
    navArgument(LOGIN_TYPE_ARG) {
      type = NavType.IntType
      defaultValue = LOGIN_TYPE_PASSWORD
    }
  )

  fun getRouteWithArgs(loginType: Int) = getRouteWithArgs(mapOf(LOGIN_TYPE_ARG to loginType))

}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addLoginScreen(onClickButton: (userName: String, password: String?) -> Unit) {
  composable(
    route = LoginNavigation.route,
    arguments = LoginNavigation.navArguments,
    enterTransition = { navFadeIn() },
    exitTransition = { navFadeOut() },
    popEnterTransition = { navFadeIn() },
    popExitTransition = { navFadeOut() }
  ) {
    LoginScreen(onClickButton)
  }
}

fun NavController.navigateToLoginScreen(loginType: Int, builder: (NavOptionsBuilder.() -> Unit)? = null) {
  navigate(route = LoginNavigation.getRouteWithArgs(loginType)) {
    builder?.let { apply(it) }
  }
}