package com.example.todoexpert

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import java.util.UUID

object TodoRepository {
    private val _todoList = mutableListOf(
        Todo(
            title = "Buy groceries",
            subtitle = "Milk, Bread, Eggs, and Fruits"
        ),
        Todo(
            title = "Study Jetpack Compose",
            subtitle = "Complete the Todo app project"
        ),
        Todo(
            title = "Workout",
            subtitle = "Go for a 30-minute run"
        ),
        Todo(
            title = "Call dad",
            subtitle = "Wish him a happy birthday"
        )
    )
    val todoList: List<Todo> get() = _todoList

    fun addTodo(todo: Todo) {
        _todoList.add(todo)
    }

    fun updateTodo(updatedTodo: Todo) {
        val index = _todoList.indexOfFirst { it.id == updatedTodo.id }
        if (index != -1) _todoList[index] = updatedTodo
    }

    fun deleteTodoById(todoId: String) {
        _todoList.removeIf { it.id == todoId }
    }

    fun getTodoById(todoId: String?): Todo? {
        return _todoList.find { it.id == todoId }
    }
}

data class Todo(
    val id: String = UUID.randomUUID().toString(),
    var title: String,
    var subtitle: String,
    val isChecked: MutableState<Boolean> = mutableStateOf(false)
)

@Composable
fun TodoExpertApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {
        composable("list") { TodoListScreen(navController) }
        composable("create") { CreateEditTodoScreen(navController, null) }
        composable("edit/{todoId}") { backStackEntry ->
            val todoId = backStackEntry.arguments?.getString("todoId")
            CreateEditTodoScreen(navController, todoId)
        }
    }
}