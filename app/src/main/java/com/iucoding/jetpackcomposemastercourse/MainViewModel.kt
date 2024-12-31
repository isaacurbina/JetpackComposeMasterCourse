package com.iucoding.jetpackcomposemastercourse

import androidx.lifecycle.ViewModel
import com.iucoding.jetpackcomposemastercourse.model.Todo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

	private val _state = MutableStateFlow<List<Todo>>(emptyList())
	val state = _state.asStateFlow()

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
