package com.iucoding.jetpackcomposemastercourse.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iucoding.jetpackcomposemastercourse.TodoAction
import com.iucoding.jetpackcomposemastercourse.model.Todo
import com.iucoding.jetpackcomposemastercourse.ui.theme.JetpackComposeMasterCourseTheme

@Composable
fun TodoItem(
    todo: Todo,
    onAction: (TodoAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                onAction(TodoAction.Remove(todo))
            }
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
                tint = Color.Red
            )
        }
        Spacer(
            modifier = Modifier.width(16.dp)
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = todo.title,
                fontWeight = FontWeight.Bold,
                textDecoration = if (todo.isChecked) {
                    TextDecoration.LineThrough
                } else TextDecoration.None
            )
            Text(
                text = todo.description, textDecoration = if (todo.isChecked) {
                    TextDecoration.LineThrough
                } else TextDecoration.None
            )
        }
        Spacer(
            modifier = Modifier.width(16.dp)
        )
        Checkbox(
            checked = todo.isChecked,
            onCheckedChange = {
                onAction(TodoAction.Toggle(todo, it))
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TodoItemPreview() {
    JetpackComposeMasterCourseTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TodoItem(
                modifier = Modifier.fillMaxWidth(),
                todo = Todo(
                    title = "Take out the trash",
                    description = "Better do this before wife comes home.",
                    isChecked = false
                ),
                onAction = {}
            )
            TodoItem(
                modifier = Modifier.fillMaxWidth(),
                todo = Todo(
                    title = "Take out the trash",
                    description = "Better do this before wife comes home.",
                    isChecked = true
                ),
                onAction = {}
            )
        }
    }
}
