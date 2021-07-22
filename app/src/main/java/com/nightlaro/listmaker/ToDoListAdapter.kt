package com.nightlaro.listmaker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ToDoListAdapter(private val lists: MutableList<Tasklist>,
                      val clickListener: ToDoListClickListener): RecyclerView.Adapter<ToDoListViewHolder>() {

    //ok now we're doing interface... (?)
    interface ToDoListClickListener {
        fun listItemClicked(list : Tasklist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_list_view_holder, parent, false)
        return ToDoListViewHolder(view)
    }

    override fun onBindViewHolder(holder : ToDoListViewHolder, position: Int) {
        holder.listPositionTextView.text = (position + 1).toString()
        holder.listTitleTextView.text = lists[position].name
        holder.itemView.setOnClickListener {
            clickListener.listItemClicked(lists[position])
        }
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    fun addList(list : Tasklist) {
        lists.add(list)
        notifyItemInserted(lists.size - 1)
    }

}
