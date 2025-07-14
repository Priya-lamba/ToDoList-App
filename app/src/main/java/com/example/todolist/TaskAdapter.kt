package com.example.todolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.BaseAdapter

class TaskAdapter(private val context: Context, private val tasks: List<Task>) : BaseAdapter() {

    override fun getCount(): Int = tasks.size

    override fun getItem(position: Int): Any = tasks[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
        val task = tasks[position]
        val textView = view.findViewById<TextView>(android.R.id.text1)

        if (task.isDone) {
            textView.text = "✔ ${task.text}"
        } else {
            textView.text = task.text
        }

        return view
    }
}
