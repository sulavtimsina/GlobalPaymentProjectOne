package com.ad.primarydetailflow.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ad.primarydetailflow.ItemDetailFragment
import com.ad.primarydetailflow.R
import com.ad.primarydetailflow.data.model.LaunchItem
import com.ad.primarydetailflow.databinding.ItemListContentBinding
import com.bumptech.glide.Glide

class RocketLaunchAdapter(private val itemDetailNavContainer: View?) :
  RecyclerView.Adapter<RocketLaunchAdapter.ViewHolder>() {
  private val launchList = mutableListOf<LaunchItem>()

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

  override fun getItemCount(): Int = launchList.size

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding = ItemListContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(binding.root)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val binding = ItemListContentBinding.bind(holder.itemView)

    with(holder.itemView) {
      setOnClickListener { p0 ->
        val bundle = Bundle()
        val launchItem = launchList[position]
        val launchDetailData = launchItem.toLaunchDetailData()
        bundle.putParcelable(ItemDetailFragment.ARG_ITEM_ID, launchDetailData)

        if (itemDetailNavContainer != null) {
          itemDetailNavContainer.findNavController().navigate(R.id.fragment_item_detail, bundle)
        } else {
          p0?.findNavController()
            ?.navigate(R.id.show_item_detail, bundle)
        }
      }

    }
    val launchDetailItem = launchList[position].toLaunchDetailData()

    binding.tvMissionName.text = launchDetailItem.missionName
    binding.tvRocketName.text = launchDetailItem.rocketName
    binding.launchDate.text = launchDetailItem.launchYear
    binding.siteName.text = launchDetailItem.siteName

    Glide.with(holder.itemView.context).load(launchDetailItem.missionPatchUrl)
      .into(binding.ivThumbnail)
  }

  fun updateDataSet(newList: List<LaunchItem>) {
    launchList.clear()
    launchList.addAll(newList)
    notifyDataSetChanged()
  }
}