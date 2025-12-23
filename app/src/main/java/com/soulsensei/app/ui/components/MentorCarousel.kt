package com.soulsensei.app.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.soulsensei.app.data.model.RailItem

@Composable
fun MentorCarousel(items: List<RailItem>) {

    LazyRow(
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(items) { mentor ->
            MentorCard(mentor)
        }
    }
}
