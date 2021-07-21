package com.nightlaro.listmaker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ToDoListAdapter(val lists: MutableList<Tasklist>) : RecyclerView.Adapter<ToDoListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_list_view_holder, parent, false)
        return ToDoListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoListViewHolder, position: Int) {
        holder.listPositionTextView.text = (position + 1).toString()
        holder.listTitleTextView.text = lists[position].name
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    fun addList(list: Tasklist) {
        lists.add(list)
        notifyItemInserted(lists.size - 1)
    }

}
