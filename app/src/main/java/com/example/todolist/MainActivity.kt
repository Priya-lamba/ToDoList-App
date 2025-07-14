package com.example.todolist

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var buttonAdd: Button
    private lateinit var listView: ListView
    private val taskList = ArrayList<Task>()
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       //  val fakeTextView: TextView? = null
        // fakeTextView!!.text = "Crash here" // NullPointerException

       //  val intent = Intent(this, Class.forName("com.example.todolist.FakeActivity"))
        // startActivity(intent)  // ActivityNotFoundException Crash

        editText = findViewById(R.id.editTextTask)
        buttonAdd = findViewById(R.id.buttonAdd)
        listView = findViewById(R.id.listViewTasks)

        adapter = TaskAdapter(this, taskList)
        listView.adapter = adapter

        buttonAdd.setOnClickListener {
            val taskText = editText.text.toString()
            if (taskText.isNotBlank()) {
                taskList.add(Task(taskText))
                adapter.notifyDataSetChanged()
                editText.text.clear()
            }
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val task = taskList[position]
            task.isDone = !task.isDone
            adapter.notifyDataSetChanged()
        }
    }
}
