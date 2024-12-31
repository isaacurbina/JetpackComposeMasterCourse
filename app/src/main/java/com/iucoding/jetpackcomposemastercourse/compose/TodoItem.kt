package com.iucoding.jetpackcomposemastercourse.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iucoding.jetpackcomposemastercourse.model.Todo
import com.iucoding.jetpackcomposemastercourse.ui.theme.JetpackComposeMasterCourseTheme

@Composable
fun TodoItem(
	todo: Todo, modifier: Modifier = Modifier
) {
	Row(
		modifier = modifier
	) {
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
		Checkbox(checked = todo.isChecked, onCheckedChange = {})
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
				modifier = Modifier.fillMaxWidth(), todo = Todo(
					title = "Take out the trash",
					description = "Better do this before wife comes home.",
					isChecked = false
				)
			)
			TodoItem(
				modifier = Modifier.fillMaxWidth(), todo = Todo(
					title = "Take out the trash",
					description = "Better do this before wife comes home.",
					isChecked = true
				)
			)
		}
	}
}
