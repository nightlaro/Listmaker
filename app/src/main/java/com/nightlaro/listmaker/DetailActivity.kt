package com.nightlaro.listmaker

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.EditText
import android.widget.Toast
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

    private lateinit var taskListAdapter: TaskListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val list: Tasklist = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY)!!
        title = list.name

        val taskListRecyclerView = findViewById<RecyclerView>(R.id.task_list_recyclerview)
        taskListRecyclerView.layoutManager = LinearLayoutManager(this)
        taskListAdapter = TaskListAdapter(list)
        taskListRecyclerView.adapter = taskListAdapter
        val addTaskButton = findViewById<FloatingActionButton>(R.id.add_task_button)
        addTaskButton.setOnClickListener {
            showCreateTaskDialog()
        }
    }

    override fun onBackPressed() {
        val bundle = Bundle() //"A bundle is for storing things" - Tutorial
        bundle.putParcelable(MainActivity.INTENT_LIST_KEY, taskListAdapter.list)
        val intent = Intent()
        intent.putExtras(bundle)
        setResult(Activity.RESULT_OK, intent)
        
        // how to show a toast
        Toast.makeText(this, "Saving list", Toast.LENGTH_LONG).show()
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
                val oldList = taskListAdapter.list
                val newList = oldList.copy(tasks = oldList.tasks + task)
                taskListAdapter.list = newList
                dialog.dismiss()
            }
            .create()
            .show()
    }
}