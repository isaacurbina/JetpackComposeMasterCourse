package com.iucoding.jetpackcomposemastercourse.model

import androidx.compose.ui.geometry.Offset

data class MindMapItem(
	val title: String,
	val percentageOffset: Offset = Offset(x = 0f, y = 0f)
)
