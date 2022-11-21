package com.noumenon.common.ui.preview

import androidx.compose.ui.tooling.preview.Preview


@Preview(
  name = "Show System UI",
  showSystemUi = true,
  group = "system ui group"
)
@Preview(
  name = "No System UI",
  showSystemUi = false,
  group = "system ui group"
)
annotation class SystemGroupPreviews
