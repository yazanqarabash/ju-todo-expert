package com.example.todoexpert

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import java.util.UUID

object TodoRepository {
    private val todoList = mutableListOf<Todo>()

    fun getTodoList() = todoList
    fun addTodo(todo: Todo) = todoList.add(todo)
    fun updateTodo(updatedTodo: Todo) {
        todoList.replaceAll { if (it.id == updatedTodo.id) updatedTodo else it }
    }
    fun deleteTodoById(todoId: String) = todoList.removeIf { it.id == todoId }
    fun getTodoById(todoId: String?) = todoList.find { it.id == todoId }
}

data class Todo(
    val id: String = UUID.randomUUID().toString(),
    var title: String,
    var subtitle: String,
    val check: MutableState<Boolean> = mutableStateOf(false)
)

@Composable
fun TodoExpertApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "todoList") {
        composable("todoList") { TodoListScreen(navController) }
        composable("create") { CreateEditTodoScreen(navController, null) }
        composable("edit/{todoId}") { backStackEntry ->
            val todoId = backStackEntry.arguments?.getString("todoId")
            val todo = TodoRepository.getTodoById(todoId)
            CreateEditTodoScreen(navController, todo)
        }
    }
}