package com.example.todoexpert

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.BottomAppBar
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
fun TodoListScreen(navController: NavController, modifier: Modifier = Modifier) {
    val todoList = TodoRepository.getTodoList()
    val image = painterResource(R.drawable.androidparty)

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Todo List") })
        },
        bottomBar = {
            BottomAppBar {
                Text("Todo Expert App")
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("create") }
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Create")
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = 0.5F,
                modifier = Modifier
            )
            LazyColumn(modifier = Modifier) {
                items(todoList) {
                        todo ->
                    ListItem(
                        modifier = Modifier.clickable { navController.navigate("edit/${todo.id}") },
                        leadingContent = {
                            Icon(Icons.Rounded.AccountCircle, contentDescription = "User")
                        },
                        headlineContent = { Text(todo.title) },
                        supportingContent = { Text(todo.subtitle) },
                        trailingContent = {
                            Checkbox(
                                checked = todo.check.value,
                                onCheckedChange = {
                                    todo.check.value = !todo.check.value
                                }
                            )
                        }
                    )
                    HorizontalDivider()
                }
            }
        }
    }
}