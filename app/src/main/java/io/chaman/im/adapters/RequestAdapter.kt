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
import io.chaman.im.ui.item.ReceiveItemFragment
import io.chaman.im.data.entities.Request
import io.chaman.im.databinding.ItemRequestBinding
import io.chaman.im.utils.ImageUtils

class RequestAdapter(val context: Context?): RecyclerView.Adapter<RequestAdapter.RequestHolder>() {

    private var dataSet = ArrayList<Request>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestHolder {
        return RequestHolder(DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.item_request, parent, false))
    }

    override fun getItemCount(): Int {
        return this.dataSet.size
    }

    override fun onBindViewHolder(holder: RequestHolder, position: Int) {
        val data = dataSet[position]

        Glide.with(this.context!!)
                .setDefaultRequestOptions(ImageUtils.getRequestConfig(R.drawable.ic_item, R.drawable.ic_item))
                .load(data.imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.ivRequestImage)

        holder.apply {
            bind(createClickListener(data), data)
            itemView.tag = data
        }
    }

    fun setRequests(requests: List<Request>) {
        this.dataSet.clear()
        this.dataSet.addAll(requests)
        notifyDataSetChanged()
    }

    private fun createClickListener(request: Request): View.OnClickListener {
        val i = Gson().toJson(request)
        val bundle = bundleOf(ReceiveItemFragment.ARG_ITEM_ID to i)
        return Navigation.createNavigateOnClickListener(R.id.action_requestFragment_to_receiveItem, bundle)
    }

    class RequestHolder(private val binding: ItemRequestBinding) : RecyclerView.ViewHolder(binding.root) {
        val ivRequestImage = binding.ivRequestImage

        fun bind(listener: View.OnClickListener, data: Request) {
            this.binding.apply {
                clickListener = listener
                request = data
                executePendingBindings()
            }
        }
    }

}