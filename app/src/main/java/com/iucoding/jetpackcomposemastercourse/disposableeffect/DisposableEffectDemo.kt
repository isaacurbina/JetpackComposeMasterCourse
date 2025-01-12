package com.iucoding.jetpackcomposemastercourse.disposableeffect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner

@Composable
fun DisposableEffectDemo(modifier: Modifier = Modifier) {
	val lifecycleOwner = LocalLifecycleOwner.current
	DisposableEffect(lifecycleOwner.lifecycle) {
		val observer = LifecycleEventObserver { _, event ->
			when (event) {
				Lifecycle.Event.ON_CREATE -> println("onCreate was called!")
				Lifecycle.Event.ON_START -> println("onStart was called!")
				Lifecycle.Event.ON_RESUME -> println("onResume was called!")
				Lifecycle.Event.ON_PAUSE -> println("onPause was called!")
				Lifecycle.Event.ON_STOP -> println("onStop was called!")
				Lifecycle.Event.ON_DESTROY -> println("onDestroy was called!")
				Lifecycle.Event.ON_ANY -> println("onAny was called!")
			}
		}
		lifecycleOwner.lifecycle.addObserver(observer)
		onDispose {
			println("Observer was disposed!")
			lifecycleOwner.lifecycle.removeObserver(observer)
		}
	}
}
