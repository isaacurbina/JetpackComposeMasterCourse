package com.iucoding.jetpackcomposemastercourse

import com.iucoding.jetpackcomposemastercourse.model.Todo

sealed interface TodoAction {

	data class Add(val todo: Todo) : TodoAction
	data class Remove(val todo: Todo) : TodoAction
	data class Toggle(val todo: Todo, val checked: Boolean) : TodoAction
}
