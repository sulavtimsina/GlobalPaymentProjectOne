package com.ad.primarydetailflow.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Telemetry(
    val flight_club: String
) : Parcelable