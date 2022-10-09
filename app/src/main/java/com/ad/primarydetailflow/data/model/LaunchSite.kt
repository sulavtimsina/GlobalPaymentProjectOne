package com.ad.primarydetailflow.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LaunchSite(
    val site_id: String,
    val site_name: String,
    val site_name_long: String
): Parcelable