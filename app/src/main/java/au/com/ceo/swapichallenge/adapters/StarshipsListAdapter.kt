package au.com.ceo.swapichallenge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import au.com.ceo.swapichallenge.database.dbo.StarshipDBO
import au.com.ceo.swapichallenge.databinding.StarshipItemBinding
import au.com.ceo.swapichallenge.models.viewmodels.StarshipsViewModel

class StarshipsListAdapter(private val viewModel: StarshipsViewModel) : RecyclerView.Adapter<StarshipsListAdapter.ViewHolder>() {

    class ViewHolder private constructor(val binding: StarshipItemBinding) : RecyclerView.ViewHolder(binding.root) {

        //Even though we should use domain models but in this case we dont have much of funcitonaliry and differences going on so this works for now
        fun bind(viewModel: StarshipsViewModel, item: StarshipDBO?) {
            binding.starshipViewModel = viewModel
            binding.starship = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = StarshipItemBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = viewModel.starships.value?.get(position)
        holder.bind(viewModel, item)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return viewModel.starships.value?.size ?: 0
    }

}