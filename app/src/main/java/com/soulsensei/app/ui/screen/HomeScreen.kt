package com.soulsensei.app.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.soulsensei.app.ui.components.FAQSection
import com.soulsensei.app.ui.components.MentorCarousel
import com.soulsensei.app.ui.components.RailHeader
import com.soulsensei.app.ui.components.TopHeader
import com.soulsensei.app.viewmodel.MainViewModel


@Composable
fun HomeScreen(viewModel: MainViewModel) {

    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }

    val response by viewModel.data.collectAsState()

    response?.let { data ->

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            TopHeader()

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 40.dp)
            ) {

                stickyHeader {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        RailHeader(data.data.rail.name)
                    }
                }

                item {
                    MentorCarousel(data.data.rail.items)
                }

                item {
                    FAQSection(data.data.railPageFaqs)
                }
            }
        }
    }
}
