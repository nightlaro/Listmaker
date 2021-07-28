package com.nightlaro.listmaker

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailFragment : Fragment() {

//    companion object {
//        fun newInstance(): DetailFragment {
////            val taskListItem = Intent(activity, DetailActivity::class.java)
////            taskListItem.putExtra(MainActivity.INTENT_LIST_KEY, list)
//            return DetailFragment()
//        }
//    }
//
//    interface OnFragmentInteractionListener {
//        fun onTodoListClicked(list: Tasklist)
//    }
//
//    private var listener: OnFragmentInteractionListener? = null
//    private lateinit var list : Tasklist
//    private lateinit var taskListRecyclerView: RecyclerView
//    private lateinit var addTaskButton: FloatingActionButton
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        list = activity?.intent?.getParcelableExtra(MainActivity.INTENT_LIST_KEY)!!
//        activity.title = list.name
//
//        taskListRecyclerView = view.findViewById(R.id.task_list_recyclerview)
//        taskListRecyclerView.layoutManager = LinearLayoutManager(activity)
//        taskListRecyclerView.adapter = TaskListAdapter(list)
//        addTaskButton = view.findViewById(R.id.add_task_button)
//        addTaskButton.setOnClickListener {
//            showCreateTaskDialog()
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_detail, container, false)
//    }
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener
//        }
//    }
//
//    private fun showCreateTaskDialog() {
//        val taskEditText = EditText(activity)
//        taskEditText.inputType = InputType.TYPE_CLASS_TEXT
//        AlertDialog.Builder(activity)
//            .setTitle(R.string.task_to_add)
//            .setView(taskEditText)
//            .setPositiveButton(R.string.add_task) { dialog, _ ->
//                val task = taskEditText.text.toString()
//                list.tasks.add(task)
//                dialog.dismiss()
//            }
//            .create()
//            .show()
//    }

}