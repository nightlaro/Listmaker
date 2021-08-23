package com.nightlaro.listmaker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalArgumentException

class TaskListAdapter(initialList: Tasklist) : RecyclerView.Adapter<TaskListAdapter.TaskListViewHolder>() {
    var list: Tasklist = initialList
        set(newValue) {
            // example things you can do in a setter

            // check for equality. If nothing's changed, don't execute more code (such as
            // calling "notifyDataSetChanged()"
            if (newValue == field) return

            // Check new value is valid
            if (newValue.name.isBlank()) throw IllegalArgumentException("Name was blank")

            // update backing field of the property
            field = newValue

            notifyDataSetChanged()
        }

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