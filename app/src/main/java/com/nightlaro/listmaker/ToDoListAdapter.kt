package com.nightlaro.listmaker

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoListAdapter(private var lists: List<Tasklist>,
                      private val clickListener: ToDoListClickListener): RecyclerView.Adapter<ToDoListAdapter.ToDoListViewHolder>() {

    //ok now we're doing interface... (?)
    interface ToDoListClickListener {
        fun listItemClicked(list: Tasklist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_list_view_holder, parent, false)
        val viewHolder = ToDoListViewHolder(view)
        Log.d("Something_COOL", "onCreateViewHolder ${viewHolder.hashCode()}")
        return viewHolder
    }

    override fun onBindViewHolder(holder : ToDoListViewHolder, position: Int) {
        holder.listPositionTextView.text = (position + 1).toString()
        Log.d("Something_COOL", "onBindViewHolder $position HASHCODE: ${holder.hashCode()}")
        holder.listTitleTextView.text = lists[position].name
        holder.itemView.setOnClickListener {
            clickListener.listItemClicked(lists[position])
        }
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    fun addList(list : Tasklist) {
        val oldList = lists
        lists = oldList + list
        notifyDataSetChanged()
    }

    class ToDoListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var listPositionTextView = itemView.findViewById<TextView>(R.id.itemNumber)
        var listTitleTextView = itemView.findViewById<TextView>(R.id.itemString)
    }

}
