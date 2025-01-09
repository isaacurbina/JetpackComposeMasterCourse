package com.iucoding.jetpackcomposemastercourse

import androidx.compose.ui.geometry.Offset
import androidx.lifecycle.ViewModel
import com.iucoding.jetpackcomposemastercourse.model.MindMapItem
import com.iucoding.jetpackcomposemastercourse.model.Todo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

	private val _state = MutableStateFlow<List<Todo>>(emptyList())
	val state = _state.asStateFlow()

	private val _mindMapItems = MutableStateFlow<List<MindMapItem>>(emptyList())
	val mindMapItems = _mindMapItems.asStateFlow()

	init {
		_mindMapItems.value = listOf(
			MindMapItem(
				title = "Hello world 1",
				percentageOffset = Offset(
					x = 0f,
					y = 0f
				)
			),
			MindMapItem(
				title = "Hello world 2",
				percentageOffset = Offset(
					x = 1f,
					y = 0f
				)
			),
			MindMapItem(
				title = "Hello world 3",
				percentageOffset = Offset(
					x = 0.3f,
					y = -0.5f
				)
			),
			MindMapItem(
				title = "Hello world 4",
				percentageOffset = Offset(
					x = -0.2f,
					y = 0.5f
				)
			)
		)
	}

	fun onAction(action: TodoAction) {
		when (action) {
			is TodoAction.Add -> _state.value =
				_state.value.toMutableList().also { it.add(action.todo) }

			is TodoAction.Remove -> _state.value =
				_state.value.toMutableList().also { it.remove(action.todo) }

			is TodoAction.Toggle -> _state.value =
				_state.value.toMutableList().map {
					if (action.todo == it) {
						action.todo.copy(isChecked = action.checked)
					} else it
				}
		}
	}
}
