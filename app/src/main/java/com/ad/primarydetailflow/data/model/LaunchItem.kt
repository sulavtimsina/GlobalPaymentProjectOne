package com.ad.primarydetailflow.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LaunchItem(
  // val crew: List<Int>,
  val details: String?=null,
  // val flight_number: Int,
  // val is_tentative: Boolean,
  // val last_date_update: String,
  // val last_ll_launch_date: String,
  // val last_ll_update: String,
  // val last_wiki_launch_date: String,
  // val last_wiki_revision: String,
  // val last_wiki_update: String,
  // val launch_date_local: String,
  // val launch_date_source: String,
  // val launch_date_unix: Int,
  // val launch_date_utc: String,
  // val launch_failure_details: LaunchFailureDetails,
  val launch_site: LaunchSite,
  // val launch_success: Boolean,
  // val launch_window: Int,
  val launch_year: String,
  val links: Links,
  // val mission_id: List<String>,
  val mission_name: String,
  val rocket: Rocket,
  // val ships: List<String>,
  // val static_fire_date_unix: Int,
  // val static_fire_date_utc: String,
  // val tbd: Boolean,
  // val telemetry: Telemetry,
  // val tentative_max_precision: String,
  // val timeline: Timeline,
  // val upcoming: Boolean,
) : Parcelable {
  override fun toString(): String {
    return mission_name
  }

  fun toLaunchDetailData() = LaunchDetailData(missionName = mission_name,
                                              launchYear = launch_year,
                                              rocketName = rocket.rocket_name,
                                              siteName = launch_site.site_name,
                                              siteNameLong = launch_site.site_name_long,
                                              missionPatchUrl = links.mission_patch,
                                              details = details?:""
  )
}