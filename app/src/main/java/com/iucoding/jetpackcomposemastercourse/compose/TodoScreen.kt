package com.iucoding.jetpackcomposemastercourse.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iucoding.jetpackcomposemastercourse.TodoAction
import com.iucoding.jetpackcomposemastercourse.model.Todo
import com.iucoding.jetpackcomposemastercourse.ui.theme.JetpackComposeMasterCourseTheme

@Composable
fun TodoScreen(
	todos: List<Todo>,
	onAction: (TodoAction) -> Unit,
	modifier: Modifier = Modifier
) {

	LazyColumn(
		modifier = modifier
			.padding(16.dp)
	) {
		items(todos) { todo ->
			TodoItem(
				modifier = Modifier.fillMaxWidth(),
				todo = todo,
				onAction = onAction
			)
		}
		item {
			Spacer(
				modifier = Modifier.height(24.dp)
			)
		}
		item {
			var title by remember { mutableStateOf("") }
			OutlinedTextField(
				modifier = Modifier.fillMaxWidth(),
				value = title,
				onValueChange = { title = it },
				label = { Text("Title") }
			)
			var description by remember { mutableStateOf("") }
			OutlinedTextField(
				modifier = Modifier.fillMaxWidth(),
				value = description,
				onValueChange = { description = it },
				label = { Text("Description") }
			)
			Spacer(
				modifier = Modifier.height(16.dp)
			)
			Button(
				onClick = {
					onAction(
						TodoAction.Add(
							Todo(
								title = title,
								description = description,
								isChecked = false
							)
						)
					)
					title = ""
					description = ""
				}
			) {
				Text(
					modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
					text = "Add",
					textAlign = TextAlign.Center
				)
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun TodoScreenPreview() {
	JetpackComposeMasterCourseTheme {
		TodoScreen(
			modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
			todos = listOf(
				Todo(
					title = "Take out the trash",
					description = "Better do this before wife comes home.",
					isChecked = false
				),
				Todo(
					title = "Take out the trash",
					description = "Better do this before wife comes home.",
					isChecked = true
				)
			),
			onAction = {}
		)
	}
}
