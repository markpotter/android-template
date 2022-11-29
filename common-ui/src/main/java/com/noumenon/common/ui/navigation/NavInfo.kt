package com.noumenon.common.ui.navigation

import androidx.navigation.NamedNavArgument

abstract class NavInfo {

  abstract val route: String
  open val navArguments: List<NamedNavArgument> = emptyList()

  /**
   * Inserts all supplied arguments into the base route. Strips optional args and re-appends them as needed.
   *
   * Note: This function assumes the caller has supplied all REQUIRED arguments
   */
  fun getRouteWithArgs(args: Map<String, Any?>): String {
    var argRoute = route.substringBefore("?")
    var hasOptionals = false
    args.map { arg ->
      if (!argRoute.contains(arg.key) && arg.value != null) {
        argRoute += if (hasOptionals) "&" else "?" + "${arg.key}=${arg.value}"
        hasOptionals = true
      } else {
        argRoute = argRoute.replace("{${arg.key}}", arg.value.toString())
      }
    }
    return argRoute
  }
}
