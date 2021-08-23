package com.nightlaro.listmaker

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoListAdapter(lists: List<Tasklist>,
                      private val clickListener: ToDoListClickListener): RecyclerView.Adapter<ToDoListAdapter.ToDoListViewHolder>() {
    var currentLists = lists
        set(value) {
            if (value == field) return
            field = value
            notifyDataSetChanged()
        }
    //ok now we're doing interface... (?)
    interface ToDoListClickListener {
        fun listItemClicked(list: Tasklist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_list_view_holder, parent, false)
        val viewHolder = ToDoListViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder : ToDoListViewHolder, position: Int) {
        holder.listPositionTextView.text = (position + 1).toString()
        holder.listTitleTextView.text = currentLists[position].name
        holder.itemView.setOnClickListener {
            clickListener.listItemClicked(currentLists[position])
        }
    }

    override fun getItemCount(): Int {
        return currentLists.size
    }

    fun addList(list : Tasklist) {
        val oldList = currentLists
        currentLists = oldList + list
        notifyDataSetChanged()
    }

    class ToDoListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var listPositionTextView = itemView.findViewById<TextView>(R.id.itemNumber)
        var listTitleTextView = itemView.findViewById<TextView>(R.id.itemString)
    }

}
