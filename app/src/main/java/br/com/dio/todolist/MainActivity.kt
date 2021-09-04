package br.com.dio.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dio.todolist.databinding.ActivityMainBinding
import br.com.dio.todolist.ui.AddTaskActivity
import br.com.dio.todolist.ui.TaskListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { TaskListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvTasks.adapter = adapter

        insertListeners()
    }

    private fun insertListeners() {
        binding.fab.setOnClickListener{
            startActivity(Intent(this, AddTaskActivity::class.java))
        }
    }
}