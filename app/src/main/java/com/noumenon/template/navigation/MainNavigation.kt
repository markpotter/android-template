package com.noumenon.template.navigation

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
import com.noumenon.template.MainScreen

object MainNavigation : NavInfo() {

  const val GREETING_ARG = "GREETING_ARG"
  const val NAME_ARG = "NAME_ARG"

  // Routes can include path variables or optional variables
  // Path example:
  override val route: String = "main/{$GREETING_ARG}?$NAME_ARG={${NAME_ARG}}"
  // Optional example:
  // override val route: String = "main?$GREETING_ARG={${GREETING_ARG}}&$NAME_ARG={${NAME_ARG}}"

  override val navArguments = listOf(
    navArgument(GREETING_ARG) { type = NavType.StringType },
    navArgument(NAME_ARG) { type = NavType.StringType }
  )

  fun getRouteWithArgs(greeting: String, name: String) = getRouteWithArgs(mapOf(GREETING_ARG to greeting, NAME_ARG to name))
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addMainScreen(onClickButton: (loginType: Int) -> Unit) {
  composable(
    route = MainNavigation.route,
    arguments = MainNavigation.navArguments,
    enterTransition = { navFadeIn() },
    exitTransition = { navFadeOut() },
    popEnterTransition = { navFadeIn() },
    popExitTransition = { navFadeOut() }
  ) {
    MainScreen(onClickButton)
  }
}

fun NavController.navigateToMainScreen(greeting: String, name: String, builder: (NavOptionsBuilder.() -> Unit)? = null) {
  navigate(route = MainNavigation.getRouteWithArgs(greeting, name)) {
    builder?.let { apply(it) }
  }
}