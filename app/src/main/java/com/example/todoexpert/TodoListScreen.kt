package com.example.todoexpert

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListScreen(navController: NavController) {
    val todoList = TodoRepository.todoList

    Scaffold(
        topBar = { TopAppBar(title = { Text("Todo List") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("create") }) {
                Icon(Icons.Filled.Add, contentDescription = "Create")
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Image(
                painter = painterResource(R.drawable.androidparty),
                contentDescription = "Todo list background image",
                contentScale = ContentScale.Crop,
                alpha = 0.5F
            )
            LazyColumn {
                items(todoList) { todo ->
                    TodoListItem(
                        todo = todo,
                        onItemClick = { navController.navigate("edit/${todo.id}") },
                        onCheckedChange = {
                            todo.isChecked.value = !todo.isChecked.value
                        }
                    )
                    HorizontalDivider()
                }
            }
        }
    }
}

@Composable
fun TodoListItem(
    todo: Todo,
    onItemClick: () -> Unit,
    onCheckedChange: (Boolean) -> Unit
) {
    ListItem(
        modifier = Modifier.clickable(onClick = onItemClick),
        leadingContent = {
            Icon(Icons.Rounded.MoreVert, contentDescription = "Editable Icon")
        },
        headlineContent = { Text(todo.title) },
        supportingContent = { Text(todo.subtitle) },
        trailingContent = {
            Checkbox(
                checked = todo.isChecked.value,
                onCheckedChange = onCheckedChange
            )
        }
    )
}
