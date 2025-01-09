package com.iucoding.jetpackcomposemastercourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.iucoding.jetpackcomposemastercourse.compose.LazyMindMap
import com.iucoding.jetpackcomposemastercourse.compose.TodoScreen
import com.iucoding.jetpackcomposemastercourse.ui.theme.JetpackComposeMasterCourseTheme

class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			JetpackComposeMasterCourseTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					val viewModel: MainViewModel = viewModel()
					val items = viewModel.mindMapItems.collectAsStateWithLifecycle(emptyList())
					var mindMapOffset by remember {
						mutableStateOf(IntOffset.Zero)
					}
					LazyMindMap(
						items = items.value,
						mindMapOffset = mindMapOffset,
						onDrag = { delta ->
							mindMapOffset += delta
						},
						modifier = Modifier
							.fillMaxSize()
							.padding(innerPadding)
					)
				}
			}
		}
	}
}
