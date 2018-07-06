package io.chaman.im.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import io.chaman.im.R
import io.chaman.im.data.Item
import io.chaman.im.databinding.ItemGoodBinding

class ItemAdapter(val context: Context): RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    private var dataSet = ArrayList<Item>()

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
                .load(data.imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.ivItemImage)

        holder.apply {
            bind(data)
            itemView.tag = data
        }
    }

    fun setItems(items: List<Item>) {
        this.dataSet.addAll(items)
        notifyDataSetChanged()
    }

    class ItemHolder(private val binding: ItemGoodBinding): RecyclerView.ViewHolder(binding.root) {

        val ivItemImage = binding.ivItemImage

        fun bind(data: Item) {
            this.binding.apply {
                item = data
                executePendingBindings()
            }
        }

    }

}