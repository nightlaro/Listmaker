package com.nightlaro.listmaker

import android.content.Context
import androidx.core.content.edit
import androidx.preference.PreferenceManager


class ListDataManager(private val context: Context) {
    fun saveList(list : Tasklist) {
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
        sharedPrefs.edit {
            putStringSet(list.name, list.tasks.toHashSet())
        }

    }
    fun readList(): MutableList<Tasklist> {
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
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