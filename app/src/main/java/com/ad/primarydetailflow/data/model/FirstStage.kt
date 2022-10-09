package com.ad.primarydetailflow.data.model

import android.os.Parcelable
import com.ad.primarydetailflow.data.model.Core
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FirstStage(
  val cores: List<Core>,
) : Parcelable