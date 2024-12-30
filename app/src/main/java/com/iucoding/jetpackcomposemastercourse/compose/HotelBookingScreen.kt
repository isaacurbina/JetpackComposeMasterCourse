package com.iucoding.jetpackcomposemastercourse.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.window.core.layout.WindowWidthSizeClass
import com.iucoding.jetpackcomposemastercourse.R
import com.iucoding.jetpackcomposemastercourse.ui.theme.JetpackComposeMasterCourseTheme

private val tags = listOf(
	"City Center",
	"Luxury",
	"Instant Booking",
	"Exclusive Deal",
	"Early Bird Discount",
	"Romantic Gateway",
	"24/7 Support"
)

private val offers = mapOf(
	R.drawable.bed to "2 Bed",
	R.drawable.breakfast to "Breakfast",
	R.drawable.cutlery to "Cutlery",
	R.drawable.pawprint to "Pet Friendly",
	R.drawable.serving_dish to "Dinner",
	R.drawable.snowflake to "Air Conditioning",
	R.drawable.television to "TV",
	R.drawable.wi_fi_icon to "Wi-Fi"
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HotelBookingScreen(modifier: Modifier = Modifier) {
	LazyColumn(
		modifier = modifier
            .fillMaxSize()
            .background(Color.White),
		verticalArrangement = Arrangement.spacedBy(16.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		item {
			Box {
				Image(
					modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(
                            max = 250.dp
                        ),
					painter = painterResource(R.drawable.living_room),
					contentDescription = null,
					contentScale = ContentScale.Crop
				)
				HotelFadedBanner(
					modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
				)
			}
		}
		item {
			HorizontalDivider(
				modifier = Modifier.padding(horizontal = 16.dp)
			)
		}
		item {
			FlowRow(
				modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
				horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
			) {
				tags.forEach { tag ->
					AssistChip(onClick = {}, label = {
						Text(text = tag)
					})
				}
			}
		}
		item {
			HorizontalDivider(
				modifier = Modifier.padding(horizontal = 16.dp)
			)
		}
		item {
			Text(
				modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
				text = """The advertisement features a vibrant and inviting design, showcasing the Hotel California Strawberry nestled in the heart of Los Angeles. Surrounded by the iconic Hollywood Sign, Griffith Park, and stunning beaches, the hotel is perfectly located for guests to explore L.A.'s best attractions.""".trimIndent(),
				fontSize = 13.sp,
				textAlign = TextAlign.Justify
			)
		}
		item {
			Text(
				modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
				text = "What we offer",
				fontSize = 18.sp,
				textAlign = TextAlign.Center,
				fontWeight = FontWeight.Bold
			)
		}
		item {
			LazyRow(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
			) {
				items(offers.entries.toList()) { (drawableResId, label) ->
					Column(
						modifier = Modifier
                            .background(Color.Gray.copy(alpha = 0.3f))
                            .padding(8.dp),
						horizontalAlignment = Alignment.CenterHorizontally,
						verticalArrangement = Arrangement.Center
					) {
						Icon(
							modifier = Modifier.size(36.dp),
							imageVector = ImageVector.vectorResource(drawableResId),
							contentDescription = label
						)
						Text(
							text = label, fontSize = 13.sp
						)
					}
				}
			}
		}
		item {
			Button(modifier = Modifier
                .padding(horizontal = 16.dp)
                .widthIn(
                    max = 400.dp
                )
                .fillMaxWidth(), onClick = {}) {
				Text(
					text = "Book now!"
				)
			}
		}
	}
}

@Composable
private fun HotelFadedBanner(modifier: Modifier = Modifier) {
	val windowClass = currentWindowAdaptiveInfo().windowSizeClass
	Row(
		modifier = modifier
            .background(Color.White.copy(alpha = 0.7f))
            .padding(16.dp),
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalAlignment = Alignment.Bottom
	) {
		Column(
			modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)
		) {
			Text(
				text = "Hotel California Strawberry",
				fontWeight = FontWeight.Bold,
				fontSize = when (windowClass.windowWidthSizeClass) {
					WindowWidthSizeClass.COMPACT -> 18.sp
					WindowWidthSizeClass.MEDIUM -> 24.sp
					WindowWidthSizeClass.EXPANDED -> 38.sp
					else -> 18.sp
				},
				maxLines = 2,
				overflow = TextOverflow.Ellipsis
			)
			LabeledIcon(text = "Los Angeles, California", icon = {
				Icon(
					imageVector = Icons.Default.LocationOn,
					contentDescription = null,
					tint = Color.DarkGray
				)
			})
			LabeledIcon(text = "4.9 (13K reviews)", icon = {
				Icon(
					imageVector = Icons.Default.Star, contentDescription = null, tint = Color.Yellow
				)
			})
		}
		Text(text = buildAnnotatedString {
			val fontSizeMultiplier = when (windowClass.windowWidthSizeClass) {
				WindowWidthSizeClass.COMPACT -> 1f
				WindowWidthSizeClass.MEDIUM -> 1.2f
				WindowWidthSizeClass.EXPANDED -> 1.5f
				else -> 1f
			}
			withStyle(
				style = SpanStyle(
					fontWeight = FontWeight.Bold, fontSize = 20.sp * fontSizeMultiplier
				)
			) {
				append("420$/")
			}
			withStyle(
				style = SpanStyle(
					fontWeight = FontWeight.SemiBold, fontSize = 14.sp * fontSizeMultiplier
				)
			) {
				append("night")
			}
		})
	}
}

@Composable
private fun LabeledIcon(
	text: String, icon: @Composable () -> Unit, modifier: Modifier = Modifier
) {
	Row(
		modifier = modifier, verticalAlignment = Alignment.CenterVertically
	) {
		icon()
		Text(
			text = text, fontSize = 13.sp
		)
	}
}

@PreviewScreenSizes
@Composable
private fun HotelBookingScreenPreview() {
	JetpackComposeMasterCourseTheme {
		HotelBookingScreen()
	}
}
