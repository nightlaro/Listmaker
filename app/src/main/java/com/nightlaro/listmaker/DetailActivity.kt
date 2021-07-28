package com.nightlaro.listmaker

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailActivity : AppCompatActivity() {

    companion object {
        fun launchDetailActivity(activity: AppCompatActivity, list: Tasklist) {
            val taskListItem = Intent(activity, DetailActivity::class.java)
            taskListItem.putExtra(MainActivity.INTENT_LIST_KEY, list)
            activity.startActivityForResult(taskListItem, MainActivity.LIST_DETAIL_REQUEST_CODE)
        }
    }

    private lateinit var list : Tasklist
    private lateinit var taskListRecyclerView: RecyclerView
    private lateinit var addTaskButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        list = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY)!!
        title = list.name

        taskListRecyclerView = findViewById(R.id.task_list_recyclerview)
        taskListRecyclerView.layoutManager = LinearLayoutManager(this)
        taskListRecyclerView.adapter = TaskListAdapter(list)
        addTaskButton = findViewById(R.id.add_task_button)
        addTaskButton.setOnClickListener {
            showCreateTaskDialog()
        }
    }

    override fun onBackPressed() {
        Log.d("OnBackPressed", "LIST: $list")
        val bundle = Bundle() //"A bundle is for storing things" - Tutorial
        bundle.putParcelable(MainActivity.INTENT_LIST_KEY, list)
        val intent = Intent()
        intent.putExtras(bundle)
        setResult(Activity.RESULT_OK, intent)
        super.onBackPressed()
    }

    private fun showCreateTaskDialog() {
        val taskEditText = EditText(this)
        taskEditText.inputType = InputType.TYPE_CLASS_TEXT
        AlertDialog.Builder(this)
            .setTitle(R.string.task_to_add)
            .setView(taskEditText)
            .setPositiveButton(R.string.add_task) { dialog, _ ->
                val task = taskEditText.text.toString()
                val oldList = list
                list = oldList.copy(tasks = oldList.tasks + task)
                taskListRecyclerView.adapter = TaskListAdapter(list) //Yeah... :c
                Log.d("ADD_TASK", "Current task list: ${list.tasks}")
                dialog.dismiss()
            }
            .create()
            .show()
    }
}