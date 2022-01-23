package au.com.ceo.swapichallenge.utils.custombindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import au.com.ceo.swapichallenge.adapters.FilmsListAdapter
import au.com.ceo.swapichallenge.models.domainmodels.FilmDomainModel


@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<FilmDomainModel>?) {
    items?.let {
        (listView.adapter as FilmsListAdapter).notifyDataSetChanged()
    }
}
