package com.nightlaro.listmaker

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class ListDataManager(private val context: Context) {
    private val sharedPrefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    fun saveList(list : Tasklist) {
        sharedPrefs.edit(commit = true) {
            putStringSet(list.name, list.tasks.toHashSet())
        }

    }
    fun readList(): MutableList<Tasklist> {
        val contents = sharedPrefs.all
        val taskLists = mutableListOf<Tasklist>()

        for (taskList in contents) {
            val taskItems = mutableListOf(taskList.value as HashSet<String>)
            val list = Tasklist(taskList.key, taskItems as MutableList<String>)
            taskLists.add(list)
        }
        return taskLists
    }
}