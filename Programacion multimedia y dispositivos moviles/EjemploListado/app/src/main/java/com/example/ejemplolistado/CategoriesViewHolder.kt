package com.example.ejemplolistado

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider : View = view.findViewById(R.id.divider)

    fun render(taskCategory: TaskCategory){
        when(taskCategory){
            TaskCategory.Futbol -> {
                tvCategoryName.text ="Futbol"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.listado_futbol_category)
                )
            }
            TaskCategory.Rugby -> {
                tvCategoryName.text ="Rugby"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.listado_rugby_category)
                )
            }
            TaskCategory.Tennis -> {
                tvCategoryName.text ="Tennis"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.listado_tennis_category)
                )
            }
            TaskCategory.Other -> {
                tvCategoryName.text ="Other"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.listado_other_category)
                )
            }
        }
    }
}