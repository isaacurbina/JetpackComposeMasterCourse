package com.iucoding.jetpackcomposemastercourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.iucoding.jetpackcomposemastercourse.disposableeffect.DisposableEffectDemo
import com.iucoding.jetpackcomposemastercourse.ui.theme.JetpackComposeMasterCourseTheme

class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			JetpackComposeMasterCourseTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					var toggle by remember {
						mutableStateOf(false)
					}
					Column {
						if (!toggle) {
							DisposableEffectDemo(
								modifier = Modifier
									.weight(1f)
									.padding(innerPadding)
							)
						}
						Button(
							onClick = {
								toggle = !toggle
							}
						) {
							Text("Toggle")
						}
					}
				}
			}
		}
	}
}
