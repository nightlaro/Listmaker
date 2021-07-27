package com.nightlaro.listmaker

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TodoListFragment : Fragment(), ToDoListAdapter.ToDoListClickListener {
    companion object {
        fun newInstance(): TodoListFragment {
            return TodoListFragment()
        }
    }

    interface OnFragmentInteractionListener {
        fun onTodoListClicked(list: Tasklist)
    }

    private var listener: OnFragmentInteractionListener? = null
    private lateinit var todoListRecyclerView: RecyclerView
    private lateinit var dataManager: ListDataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lists = dataManager.readList()
        todoListRecyclerView = view.findViewById(R.id.lists_recyclerview)
        todoListRecyclerView.layoutManager = LinearLayoutManager(activity)
        todoListRecyclerView.adapter = ToDoListAdapter(lists, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo_list, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener)  {
            listener = context
            dataManager = ListDataManager(context)
        }
    }

    override fun listItemClicked(list: Tasklist) {
        listener?.onTodoListClicked(list)
    }

    fun addList(list: Tasklist) {
        dataManager.saveList(list)
        val todoAdapter = todoListRecyclerView.adapter as ToDoListAdapter
        todoAdapter.addList(list)
    }

    fun saveList(list: Tasklist) {
        dataManager.saveList(list)
        updateList()
    }

    private fun updateList() {
        val lists = dataManager.readList()
        todoListRecyclerView.adapter = ToDoListAdapter(lists, this) //refreshes recycler view
    }

}