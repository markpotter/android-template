package com.noumenon.common.ui.preview

import androidx.compose.ui.tooling.preview.Preview


// inspired by Android's Preview Devices object (androidx.compose.ui.tooling.preview.Device.kt)
const val PHONE_PORTRAIT = "spec:id=reference_phone,shape=Normal,width=411,height=891,unit=dp,dpi=420"
const val PHONE_LANDSCAPE = "spec:id=reference_phone,shape=Normal,width=891,height=411,unit=dp,dpi=420"
const val TABLET_PORTRAIT = "spec:shape=Normal,width=800,height=1280,unit=dp,dpi=420"
const val TABLET_LANDSCAPE = "spec:shape=Normal,width=1280,height=800,unit=dp,dpi=420"

@Preview(
  name = "Phone Portrait",
  device = PHONE_PORTRAIT,
  group = "device group"
)
@Preview(
  name = "Phone Landscape",
  device = PHONE_LANDSCAPE,
  group = "device group"
)
@Preview(
  name = "Tablet Portrait",
  device = TABLET_PORTRAIT,
  group = "device group"
)
@Preview(
  name = "Device Tablet Landscape",
  device = TABLET_LANDSCAPE,
  group = "device group"
)
annotation class DeviceGroupPreviews
