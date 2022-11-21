package com.noumenon.common.ui.preview

import androidx.compose.ui.tooling.preview.Preview


@Preview(
  name = "Show Background",
  showBackground = true,
  group = "background group"
)
@Preview(
  name = "No Background",
  showBackground = false,
  group = "background group"
)
annotation class BackgroundGroupPreviews
