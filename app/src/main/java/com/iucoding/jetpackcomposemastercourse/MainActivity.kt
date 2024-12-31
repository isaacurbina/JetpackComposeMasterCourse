package com.iucoding.jetpackcomposemastercourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
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
					val todos = viewModel.state.collectAsStateWithLifecycle(emptyList())
					TodoScreen(
						modifier = Modifier
							.fillMaxSize()
							.padding(innerPadding),
						todos = todos.value,
						onAction = viewModel::onAction
					)
				}
			}
		}
	}
}
