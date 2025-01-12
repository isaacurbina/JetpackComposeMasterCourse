package com.iucoding.jetpackcomposemastercourse.modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.layout
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode
import androidx.compose.ui.node.LayoutModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.node.currentValueOf
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.applyIf(
	condition: Boolean,
	modifier: Modifier.() -> Modifier
): Modifier {
	return if (condition) {
		this.then(modifier())
	} else this
}

fun Modifier.printConstraints(tag: String): Modifier {
	return layout { measurable, constraints ->
		println("$tag: $constraints")
		val placeable = measurable.measure(
			constraints = constraints
		)

		layout(placeable.width, placeable.height) {
			placeable.place(0, 0)
		}
	}
}

data class NegativePaddingElement(
	private val horizontal: Dp
) : ModifierNodeElement<NegativePaddingNode>() {

	override fun create(): NegativePaddingNode {
		return NegativePaddingNode(horizontal)
	}

	override fun update(node: NegativePaddingNode) {
		TODO("Not yet implemented")
	}

}

class NegativePaddingNode(
	private val horizontal: Dp
) : LayoutModifierNode, Modifier.Node(), CompositionLocalConsumerModifierNode {

	override fun MeasureScope.measure(
		measurable: Measurable,
		constraints: Constraints
	): MeasureResult {
		val density = currentValueOf(LocalDensity)
		val px = with(density) {
			horizontal.roundToPx()
		}
		val placeable = measurable.measure(
			constraints = constraints.copy(
				minWidth = constraints.minWidth + 2 * px,
				maxWidth = constraints.maxWidth + 2 * px
			)
		)
		return layout(placeable.width, placeable.height) {
			placeable.place(0, 0)
		}
	}
}

@Deprecated("use NegativePaddingNode instead")
@Composable
fun Modifier.negativePadding(horizontal: Dp): Modifier {
	val density = LocalDensity.current
	val px = with(density) {
		horizontal.roundToPx()
	}
	return layout { measurable, constraints ->
		val placeable = measurable.measure(
			constraints = constraints.copy(
				minWidth = constraints.minWidth + 2 * px,
				maxWidth = constraints.maxWidth + 2 * px
			)
		)
		layout(placeable.width, placeable.height) {
			placeable.place(0, 0)
		}
	}
}

@Composable
fun SimpleModifierDemo(
	modifier: Modifier = Modifier
) {
	Box(
		modifier = modifier
            .size(100.dp)
            .applyIf(true) {
                background(Color.Red)
                    .padding(16.dp)
            }
	)
}

@Preview
@Composable
private fun SimpleModifierDemoPreview() {
	SimpleModifierDemo()
}
