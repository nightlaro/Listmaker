package com.nightlaro.listmaker

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class TodoListFragment : Fragment() {
    companion object {
        fun newInstance(): TodoListFragment {
            return TodoListFragment()
        }
    }

    interface OnFragmentInteractionListener {
        fun onTodoListClicked(list: Tasklist)
    }

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo_list, container, false)
    }


}