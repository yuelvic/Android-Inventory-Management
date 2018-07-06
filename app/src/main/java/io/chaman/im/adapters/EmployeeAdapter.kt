package io.chaman.im.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import io.chaman.im.R
import io.chaman.im.data.Employee
import io.chaman.im.databinding.ItemEmployeeBinding

class EmployeeAdapter(val context: Context?): RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder>() {

    private val dataSet = ArrayList<Employee>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeHolder {
        return EmployeeHolder(DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.item_employee, parent, false))
    }

    override fun getItemCount(): Int {
        return this.dataSet.size
    }

    override fun onBindViewHolder(holder: EmployeeHolder, position: Int) {
        val data = this.dataSet[position]

        Glide.with(this.context!!)
                .load(data.imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.ivEmployeeImage)

        holder.apply {
            bind(data)
            itemView.tag = data
        }
    }

    fun setEmployees(employees: List<Employee>) {
        this.dataSet += employees
        notifyDataSetChanged()
    }

    class EmployeeHolder(private val binding: ItemEmployeeBinding):
            RecyclerView.ViewHolder(binding.root) {

        val ivEmployeeImage = binding.ivEmployeeImage

        fun bind(data: Employee) {
            this.binding.apply {
                employee = data
                executePendingBindings()
            }
        }

    }

}