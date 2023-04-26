package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        var todoList = mutableListOf(
            Todo("Follo AndroidDevs",false),
            Todo("Learn About Recycle View",true),
            Todo("Learn Layouts",true)
        )

        val adapter = ToDoAdapter(todoList, object : OnItemClickListener {
            override fun onItemClick(todo: Any) {
                Toast.makeText(applicationContext, todo.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        var rvTodos = findViewById<RecyclerView>(R.id.rvTodos)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

//        Toast.makeText(this, "something", Toast.LENGTH_SHORT).show()
        val etTodo = findViewById<EditText>(R.id.etTodo)
        val btnAddTodo = findViewById<Button>(R.id.btnAddTodo)
        btnAddTodo.setOnClickListener{
            val title = etTodo.text.toString()
            val todo = Todo(title,false)
            todoList.add(todo)
            //adapter.notifyDataSetChanged()
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}