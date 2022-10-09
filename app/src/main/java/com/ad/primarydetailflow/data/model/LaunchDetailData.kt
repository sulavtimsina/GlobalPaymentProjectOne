package com.ad.primarydetailflow.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LaunchDetailData(
  val missionName: String,
  val launchYear: String,
  val rocketName: String,
  val siteName: String,
  val siteNameLong: String,
  val missionPatchUrl: String,
  val details: String = ""
) : Parcelable {

  // override fun toString(): String {
  //   return "LaunchDetailData(missionName='$missionName', launchYear='$launchYear', rocketName='$rocketName', siteName='$siteName', missionPatchUrl='$missionPatchUrl')"
  // }
}
