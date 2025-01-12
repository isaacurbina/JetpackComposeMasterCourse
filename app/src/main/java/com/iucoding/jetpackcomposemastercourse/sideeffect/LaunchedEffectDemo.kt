package com.iucoding.jetpackcomposemastercourse.sideeffect

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.iucoding.jetpackcomposemastercourse.ui.theme.JetpackComposeMasterCourseTheme
import kotlinx.coroutines.launch

@Composable
fun LaunchedEffectDemo(modifier: Modifier = Modifier) {
	var counter by remember {
		mutableIntStateOf(0)
	}
	val snackBarHostState = remember {
		SnackbarHostState()
	}
	val pagerState = rememberPagerState { 0 }
	LaunchedEffect(pagerState.currentPage) {
		// update UI here every time selected page changes
	}
	val launcher = rememberLauncherForActivityResult(
		contract = ActivityResultContracts.RequestPermission()
	) { isGranted ->
		// permission result is isGranted boolean
	}
	// launch one time
	LaunchedEffect(true) {
		launcher.launch(Manifest.permission.RECORD_AUDIO)
	}
	val scope = rememberCoroutineScope()
	LaunchedEffect(counter) {
		if (counter % 2 == 0) {
			scope.launch {
				snackBarHostState.showSnackbar(
					"The number is even!"
				)
			}
		}
	}
	Scaffold(modifier = modifier.fillMaxSize(), snackbarHost = {
		SnackbarHost(
			hostState = snackBarHostState
		)
	}) { innerPadding ->
		Button(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .wrapContentSize(),
			onClick = {
				counter++
				if (counter % 2 == 0) {
					scope.launch {
						snackBarHostState.showSnackbar(
							"The number is even!"
						)
					}
				}
			}) {
			Text("Counter: $counter")
		}
	}
}

@Preview
@Composable
private fun LaunchedEffectDemoPreview(
	modifier: Modifier = Modifier
) {
	JetpackComposeMasterCourseTheme {
		LaunchedEffectDemo(
			modifier = Modifier.fillMaxSize()
		)
	}
}
