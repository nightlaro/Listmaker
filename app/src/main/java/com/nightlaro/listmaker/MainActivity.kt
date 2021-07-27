package com.nightlaro.listmaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity: AppCompatActivity(), TodoListFragment.OnFragmentInteractionListener {

    companion object {
        const val INTENT_LIST_KEY = "list"
        const val LIST_DETAIL_REQUEST_CODE = 420
    }

    private val todoListFragment = TodoListFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val fab = findViewById<FloatingActionButton>(R.id.add_button)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { _ ->
            showCreateToDoListDialog()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == LIST_DETAIL_REQUEST_CODE) {
            data?.let {
                val list = data.getParcelableExtra<Tasklist>(INTENT_LIST_KEY)!!
                todoListFragment.saveList(list)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showCreateToDoListDialog() {
        val dialogTitle = getString(R.string.name_of_list)
        val positiveButtonTitle = getString(R.string.create_list)
        val negativeButtonTitle = "Cancel"
        val myDialog = AlertDialog.Builder(this)
        val toDoTitleEditText = EditText(this)

        toDoTitleEditText.inputType = InputType.TYPE_CLASS_TEXT

        myDialog.setTitle(dialogTitle)
            .setView(toDoTitleEditText)
            .setPositiveButton(positiveButtonTitle) { dialog, _ ->
                val input = toDoTitleEditText.text.toString()
                val list = Tasklist(input)
                todoListFragment.addList(list)
                dialog.dismiss()
                showTaskListItems(list)
            }
            .setNegativeButton(negativeButtonTitle) { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }

    private fun showTaskListItems(list : Tasklist) {
        DetailActivity.launchDetailActivity(this, list)
    }

    override fun onTodoListClicked(list: Tasklist) {
        showTaskListItems(list)
    }

}