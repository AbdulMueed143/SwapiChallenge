package au.com.ceo.swapichallenge

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import au.com.ceo.swapichallenge.adapters.FilmsListAdapter
import au.com.ceo.swapichallenge.adapters.StarshipsListAdapter
import au.com.ceo.swapichallenge.databinding.FragmentFilmsBinding
import au.com.ceo.swapichallenge.models.viewmodels.FilmsViewModel
import au.com.ceo.swapichallenge.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class FilmsFragment : Fragment() {

    val viewModel by viewModels<FilmsViewModel>()
    private var _binding: FragmentFilmsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFilmsBinding.inflate(inflater, container, false).apply {
            filmsViewModel = viewModel
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObserver()
    }

    private fun setupRecyclerView() {
        _binding?.filmsViewModel?.let {
            binding.rcyFilms.adapter = FilmsListAdapter(it)
        }
    }

    private fun setupObserver() {
        binding.filmsViewModel?._films?.observe(viewLifecycleOwner, {
            when(it.status) {
                Resource.Status.LOADING -> {}
                Resource.Status.SUCCESS -> {

                    viewModel.films = it.data?.map {
                        it.toDomainModel()
                    }?.sortedByDescending {
                        it.releaseDate
                    }?.toList()

                    binding.rcyFilms.adapter?.notifyDataSetChanged()
                }
                Resource.Status.ERROR -> {}
            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        //remove any bindings or remove observers or anything that shall be done
        _binding = null //ready for garbage collection mate!
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FilmsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}