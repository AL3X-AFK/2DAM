package com.example.ejemplolistado

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TasksAdapter (private val tasks: List<Task>): RecyclerView.Adapter<TasksViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TasksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_listado_task, parent, false)
        return TasksViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: TasksViewHolder,
        position: Int
    ){
        holder.render((tasks[position]))
    }

    override fun  getItemCount(): Int = tasks.size
}