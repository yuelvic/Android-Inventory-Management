package io.chaman.im.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.gson.Gson
import io.chaman.im.R
import io.chaman.im.data.entities.Item
import io.chaman.im.data.entities.Supply
import io.chaman.im.databinding.ItemGoodBinding
import io.chaman.im.ui.item.SupplyFragment

class IssueAdapter(val context: Context): RecyclerView.Adapter<IssueAdapter.IssueHolder>() {

    val dataSet = ArrayList<Supply>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueHolder {
        return IssueHolder(DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.item_good, parent, false))
    }

    override fun getItemCount(): Int {
        return this.dataSet.size
    }

    override fun onBindViewHolder(holder: IssueHolder, position: Int) {
        val data = this.dataSet[position]

        Glide.with(context)
                .load(data.imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.ivItemImage)

        holder.apply {
            bind(createClickListener(data), data)
            itemView.tag = data
        }
    }

    fun setItems(items: List<Supply>) {
        this.dataSet += items
        notifyDataSetChanged()
    }

    private fun createClickListener(item: Supply): View.OnClickListener {
        val i = Gson().toJson(item)
        val bundle = bundleOf(SupplyFragment.ARG_ITEM_ID to i)
        return Navigation.createNavigateOnClickListener(
                R.id.action_issueFragment_to_supplyActivity, bundle)
    }

    class IssueHolder(private val binding: ItemGoodBinding):
            RecyclerView.ViewHolder(binding.root) {

        val ivItemImage = binding.ivItemImage

        fun bind(listener: View.OnClickListener, data: Supply) {
            this.binding.apply {
                clickListener = listener
                item = data
                executePendingBindings()
            }
        }
    }

}