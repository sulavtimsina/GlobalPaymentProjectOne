package com.ad.primarydetailflow

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ad.primarydetailflow.data.model.LaunchDetailData
import com.ad.primarydetailflow.databinding.FragmentItemDetailBinding
import com.bumptech.glide.Glide

class ItemDetailFragment : Fragment() {

  private var _binding: FragmentItemDetailBinding? = null
  private val binding get() = _binding!!

  @RequiresApi(Build.VERSION_CODES.TIRAMISU)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?,
  ): View {

    _binding = FragmentItemDetailBinding.inflate(inflater, container, false)
    arguments?.let {
      if (it.containsKey(ARG_ITEM_ID)) {
        val a = it.getParcelable<LaunchDetailData>(ARG_ITEM_ID)
        (context as AppCompatActivity).supportActionBar?.title = a?.missionName
        binding.missionName.text = a?.missionName
        Glide.with(requireContext()).load(a?.missionPatchUrl)
          .into(binding.launchThumbnail)
        a?.details?.let {
          binding.missionDescription.text = it
        } ?: kotlin.run {
          binding.missionDescription.visibility = View.GONE
        }
        binding.locationText.text = "Location: " + a?.siteName
        binding.locationTextLong.text = a?.siteNameLong
        binding.rocketName.text = a?.rocketName
      }
    }
    return binding.root
  }

  companion object {
    const val ARG_ITEM_ID = "item_id"
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}