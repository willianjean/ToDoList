package br.com.dio.todolist.datasource

import br.com.dio.todolist.model.Task

object TaskDataSource{
    private val list = arrayListOf<Task>()

    fun getList() = list

    fun insertTask(task: Task){
        list.add(task.copy(id = list.size + 1))
    }
}