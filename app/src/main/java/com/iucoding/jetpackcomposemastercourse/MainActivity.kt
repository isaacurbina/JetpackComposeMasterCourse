package com.iucoding.jetpackcomposemastercourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.iucoding.jetpackcomposemastercourse.compose.HotelBookingScreen
import com.iucoding.jetpackcomposemastercourse.ui.theme.JetpackComposeMasterCourseTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			JetpackComposeMasterCourseTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					HotelBookingScreen(
						modifier = Modifier.padding(innerPadding)
					)
				}
			}
		}
	}
}
