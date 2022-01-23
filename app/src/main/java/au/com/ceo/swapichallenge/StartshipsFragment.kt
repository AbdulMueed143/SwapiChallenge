package au.com.ceo.swapichallenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import au.com.ceo.swapichallenge.adapters.StarshipsListAdapter
import au.com.ceo.swapichallenge.databinding.FragmentStartshipsBinding
import au.com.ceo.swapichallenge.models.viewmodels.StarshipsViewModel
import au.com.ceo.swapichallenge.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class StartshipsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    val viewModel by viewModels<StarshipsViewModel>()
    private var _binding: FragmentStartshipsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStartshipsBinding.inflate(inflater, container, false).apply {
            starshipViewModel = viewModel
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObserver()
    }

    private fun setupRecyclerView() {
        _binding?.starshipViewModel?.let {
            binding.rcyStarships.adapter = StarshipsListAdapter(it)
        }
    }

    private fun setupObserver() {
        binding.starshipViewModel?._starships?.observe(viewLifecycleOwner,  {
            when(it.status) {
                Resource.Status.LOADING -> {}
                Resource.Status.SUCCESS -> {
                    //refresh the data
                    if(!it.data.isNullOrEmpty()) {
                        it.data.let {
                            viewModel.starships = it.sortedByDescending {
                                it.name.length
                            }

                            binding.rcyStarships.adapter?.notifyDataSetChanged()
                        }
                    }
                }
                Resource.Status.ERROR -> {}
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null //ready for garbage collection mate!
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StartshipsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StartshipsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}