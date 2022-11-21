package com.noumenon.common.ui.preview

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview



@Preview(
  name = "Light Theme",
  group = "theme group",
  uiMode = UI_MODE_NIGHT_NO
)
@Preview(
  name = "Dark Theme",
  group = "theme group",
  uiMode = UI_MODE_NIGHT_YES
)
annotation class ThemeGroupPreviews
