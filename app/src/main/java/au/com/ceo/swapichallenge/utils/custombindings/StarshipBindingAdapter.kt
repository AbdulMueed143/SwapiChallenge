package au.com.ceo.swapichallenge.utils.custombindings

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import au.com.ceo.swapichallenge.adapters.StarshipsListAdapter
import au.com.ceo.swapichallenge.database.dbo.StarshipDBO


@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<StarshipDBO>?) {
    items?.let {
        (listView.adapter as StarshipsListAdapter).notifyDataSetChanged()
    }
}

@BindingAdapter("bind:visibility")
fun setVisibility(view: ProgressBar, isLoading: MutableLiveData<Boolean>) {
    if (isLoading.value == true)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}