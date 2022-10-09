package com.ad.primarydetailflow.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SecondStage(
    val block: Int,
    val payloads: List<Payload>
) : Parcelable