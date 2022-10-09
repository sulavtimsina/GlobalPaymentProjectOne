package com.ad.primarydetailflow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.ad.primarydetailflow.databinding.FragmentItemListBinding
import com.ad.primarydetailflow.ui.RocketLaunchAdapter
import com.ad.primarydetailflow.ui.RocketLaunchViewModel
import com.ad.primarydetailflow.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemListFragment : Fragment() {
  private var _binding: FragmentItemListBinding? = null
  private val binding get() = _binding!!

  private val viewModel: RocketLaunchViewModel by viewModels()
  private lateinit var adapter: RocketLaunchAdapter

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?,
  ): View {
    _binding = FragmentItemListBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val recyclerView: RecyclerView = binding.itemList
    val itemDetailNavContainer: View? = view.findViewById(R.id.item_detail_nav_container)

    setupRecyclerView(recyclerView, itemDetailNavContainer)

    observeLaunchList()
  }

  private fun observeLaunchList() {
    lifecycleScope.launchWhenCreated {
      viewModel.getLaunchList(requireActivity())

      viewModel.launchList.observe(viewLifecycleOwner) { responseResource ->
        when (responseResource) {
          is Resource.Success -> {
            binding.progressBar.visibility = View.GONE
            responseResource.data?.let { launch ->
              adapter.updateDataSet(launch)
            }
          }
          is Resource.Error -> {
            binding.progressBar.visibility = View.VISIBLE
            Toast.makeText(requireActivity(),
                           responseResource.message.toString(),
                           Toast.LENGTH_SHORT).show()
          }
          is Resource.Loading -> {
            binding.progressBar.visibility = View.VISIBLE
          }
        }
      }
    }
  }

  private fun setupRecyclerView(
    recyclerView: RecyclerView, itemDetailNavContainer: View?,
  ) {
    adapter = RocketLaunchAdapter(itemDetailNavContainer)
    recyclerView.adapter = adapter
  }


  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}