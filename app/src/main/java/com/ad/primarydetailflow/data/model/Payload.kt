package com.ad.primarydetailflow.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Payload(
    val cap_serial: String,
    val cargo_manifest: String,
    val customers: List<String>,
    val flight_time_sec: Int,
    val manufacturer: String,
    val mass_returned_kg: Double,
    val mass_returned_lbs: Double,
    val nationality: String,
    val norad_id: List<Int>,
    val orbit: String,
    val orbit_params: OrbitParams,
    val payload_id: String,
    val payload_mass_kg: Double,
    val payload_mass_lbs: Double,
    val payload_type: String,
    val reused: Boolean,
    val uid: String
) : Parcelable