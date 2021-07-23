package com.nightlaro.listmaker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskListAdapter(var list : Tasklist): RecyclerView.Adapter<TaskListAdapter.TaskListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_view_holder, parent, false)
        return TaskListViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        holder.taskListTextView.text = list.tasks[position]
    }

    override fun getItemCount(): Int {
        return list.tasks.size
    }
    class TaskListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val taskListTextView = itemView.findViewById<TextView>(R.id.textview_task)
    }
}