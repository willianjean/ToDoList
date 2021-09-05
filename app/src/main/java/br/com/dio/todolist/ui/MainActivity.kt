package br.com.dio.todolist.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.dio.todolist.databinding.ActivityMainBinding
import br.com.dio.todolist.datasource.TaskDataSource

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { TaskListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        insertListeners()
    }

    private fun insertListeners() {
        binding.fab.setOnClickListener{
            startActivityForResult(Intent(this, AddTaskActivity::class.java), CREATE_NEW_TASK)
        }

        adapter.listenerEdit = {
            Log.e("TAG", "insertListeners: $it")
        }

        adapter.listenerDelete = {
            Log.e("TAG", "insertListeners: $it")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == CREATE_NEW_TASK){
            binding.rvTasks.adapter = adapter
            adapter.submitList(TaskDataSource.getList())
        }
    }

    companion object{
        private const val CREATE_NEW_TASK = 1000
    }
}