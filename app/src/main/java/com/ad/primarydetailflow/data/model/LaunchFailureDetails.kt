package com.ad.primarydetailflow.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LaunchFailureDetails(
    val altitude: Int,
    val reason: String,
    val time: Int,
) : Parcelable