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
import io.chaman.im.ui.item.AddItemFragment
import io.chaman.im.utils.ImageUtils

class ItemAdapter(val context: Context): RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    private var dataSet = ArrayList<Supply>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.item_good, parent, false))
    }

    override fun getItemCount(): Int {
        return this.dataSet.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val data = this.dataSet[position]

        Glide.with(context)
                .setDefaultRequestOptions(ImageUtils.getRequestConfig(R.drawable.ic_item, R.drawable.ic_item))
                .load(data.imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.ivItemImage)

        holder.apply {
            bind(createClickListener(data), data)
            itemView.tag = data
        }
    }

    fun setSupplies(items: List<Supply>) {
        this.dataSet.clear()
        this.dataSet.addAll(items)
        notifyDataSetChanged()
    }

    fun setSupplies(item: Supply) {
        this.dataSet.clear()
        this.dataSet.add(item)
        notifyDataSetChanged()
    }

    private fun createClickListener(supply: Supply): View.OnClickListener {
        val i = Gson().toJson(supply)
        val bundle = bundleOf(AddItemFragment.ARG_ITEM_ID to i)
        return Navigation.createNavigateOnClickListener(R.id.action_itemFragment_to_addItemActivity, bundle)
    }

    class ItemHolder(private val binding: ItemGoodBinding): RecyclerView.ViewHolder(binding.root) {

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