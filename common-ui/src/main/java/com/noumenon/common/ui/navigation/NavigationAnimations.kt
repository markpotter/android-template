@file:OptIn(ExperimentalAnimationApi::class, ExperimentalAnimationApi::class, ExperimentalAnimationApi::class)

package com.noumenon.common.ui.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut

const val NAVIGATION_ANIMATION_DURATION = 250

fun navFadeOut() = fadeOut(tween(NAVIGATION_ANIMATION_DURATION))
fun navFadeIn() = fadeIn(tween(NAVIGATION_ANIMATION_DURATION))

@OptIn(ExperimentalAnimationApi::class)
fun <T> AnimatedContentScope<T>.navSlideIn() = slideIntoContainer(AnimatedContentScope.SlideDirection.Start, animationSpec = tween(NAVIGATION_ANIMATION_DURATION))
fun <T> AnimatedContentScope<T>.navSlideOut() = slideOutOfContainer(AnimatedContentScope.SlideDirection.End, animationSpec = tween(NAVIGATION_ANIMATION_DURATION))