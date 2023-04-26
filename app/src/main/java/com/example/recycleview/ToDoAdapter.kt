package com.example.recycleview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import javax.sql.RowSetListener

class ToDoAdapter(var todos:List<Todo>,private val listener: OnItemClickListener ) : RecyclerView.Adapter<ToDoAdapter.TodoViewHolder>() {
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        var cbDone =  itemView.findViewById<CheckBox>(R.id.cbDone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_todo,parent,false)
        return TodoViewHolder(view)

    }

    override fun getItemCount(): Int {
        return todos.size
    }
    
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        Log.d("Debug","${todos[position]} this is postion" )

        holder.tvTitle.text = todos[position].title
        holder.cbDone.isChecked = todos[position].isChecked

        val todoObject = todos[position]
        holder.itemView.setOnClickListener{
            listener.onItemClick(todoObject)
        }

//        holder.itemView.setOnClickListener{
//            Toast.makeText(context, "Title : " + todos[position].title, Toast.LENGTH_SHORT).show()
//        }
//

    }

}