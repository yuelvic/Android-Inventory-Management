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
import io.chaman.im.data.entities.Employee
import io.chaman.im.databinding.ItemEmployeeBinding
import io.chaman.im.ui.employee.EmployeeDetailsFragment

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
            bind(createClickListener(data), data)
            itemView.tag = data
        }
    }

    fun setEmployees(employees: List<Employee>) {
        this.dataSet += employees
        notifyDataSetChanged()
    }

    private fun createClickListener(employee: Employee): View.OnClickListener {
        val e = Gson().toJson(employee)
        val bundle = bundleOf(EmployeeDetailsFragment.ARG_ITEM_ID to e)
        return Navigation.createNavigateOnClickListener(
                R.id.action_employeeFragment_to_employeeDetailsActivity, bundle)
    }

    class EmployeeHolder(private val binding: ItemEmployeeBinding):
            RecyclerView.ViewHolder(binding.root) {

        val ivEmployeeImage = binding.ivEmployeeImage

        fun bind(listener: View.OnClickListener, data: Employee) {
            this.binding.apply {
                clickListener = listener
                employee = data
                executePendingBindings()
            }
        }

    }

}