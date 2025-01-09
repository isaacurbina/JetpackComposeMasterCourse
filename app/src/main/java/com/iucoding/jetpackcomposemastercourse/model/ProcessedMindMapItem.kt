package com.iucoding.jetpackcomposemastercourse.model

import androidx.compose.ui.layout.Placeable

data class ProcessedMindMapItem(
	val placeable: Placeable,
	val finalXPosition: Int,
	val finalYPosition: Int
)
