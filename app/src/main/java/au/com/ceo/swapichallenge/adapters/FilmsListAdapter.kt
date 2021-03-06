package au.com.ceo.swapichallenge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import au.com.ceo.swapichallenge.databinding.FilmItemBinding
import au.com.ceo.swapichallenge.models.domainmodels.FilmDomainModel
import au.com.ceo.swapichallenge.models.viewmodels.FilmsViewModel

class FilmsListAdapter(private val viewModel: FilmsViewModel) : RecyclerView.Adapter<FilmsListAdapter.ViewHolder>() {

    class ViewHolder private constructor(val binding: FilmItemBinding) : RecyclerView.ViewHolder(binding.root) {

        //Even though we should use domain models but in this case we dont have much of funcitonaliry and differences going on so this works for now
        fun bind(viewModel: FilmsViewModel, item: FilmDomainModel?) {
            binding.filmViewModel = viewModel
            binding.film = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = FilmItemBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = viewModel.films.value?.get(position)
        holder.bind(viewModel, item)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return viewModel.films.value?.size ?: 0
    }

}