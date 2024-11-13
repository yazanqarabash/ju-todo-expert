package com.example.todoexpert

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateEditTodoScreen(navController: NavController, existingTodo: Todo?) {
    var title by remember { mutableStateOf(existingTodo?.title ?: "") }
    var subtitle by remember { mutableStateOf(existingTodo?.subtitle ?: "") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (existingTodo == null) "Create Todo" else "Edit Todo")},
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            TextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = subtitle,
                onValueChange = { subtitle = it },
                label = { Text("Details") },
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    val newTodo = Todo(
                        id = existingTodo?.id ?: UUID.randomUUID().toString(),
                        title = title,
                        subtitle = subtitle
                    )
                    if (existingTodo == null) {
                        TodoRepository.addTodo(newTodo)
                    } else {
                        TodoRepository.updateTodo(newTodo)
                    }
                    navController.popBackStack()
                },
                modifier = Modifier
            ) {
                Text("Save")
            }

            if (existingTodo != null) {
                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        TodoRepository.deleteTodoById(existingTodo.id)
                        navController.popBackStack()
                    },
                    modifier = Modifier
                ) {
                    Text("Delete")
                }
            }
        }
    }
}