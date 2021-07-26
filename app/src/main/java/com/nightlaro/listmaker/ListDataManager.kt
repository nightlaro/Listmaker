package com.nightlaro.listmaker

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class ListDataManager(private val context: Context) {
    fun saveList(list : Tasklist) {
        val sharedPrefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        sharedPrefs.edit() {
            putStringSet(list.name, list.tasks.toHashSet())
        }

    }
    fun readList(): MutableList<Tasklist> {
        val sharedPrefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val contents = sharedPrefs.all
        val taskLists = mutableListOf<Tasklist>()

        for (taskList in contents) {
            val taskItems = (taskList.value as HashSet<String>).toMutableList() // Actually convert (create) it and not just cast it at the end
            val list = Tasklist(taskList.key, taskItems)
            taskLists.add(list)
        }
        return taskLists
    }
}