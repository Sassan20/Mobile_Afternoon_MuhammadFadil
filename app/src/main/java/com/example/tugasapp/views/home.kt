package com.example.tugasapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tugasapp.data.DummyData
import com.example.tugasapp.navigation.Screen
import com.example.tugasapp.model.Berita
import com.example.tugasapp.views.components.Item2
import com.example.tugasapp.views.components.Item1
import androidx.navigation.NavController

@Composable
fun Home(
    navController: NavController,
    modifier: Modifier = Modifier,
    beritas: List<Berita> = DummyData.berita,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        item {
            LazyRow(
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
            ) {
                items(beritas, key = { it.id }) {
                    Item1( berita1 = it) { id ->
                        navController.navigate(Screen.Detail.route + "/$id")
                    }
                }
            }
        }
        items(beritas, key = { it.id }) {
            Item2(berita2 = it, modifier = Modifier.padding(horizontal = 16.dp)){ id ->
                navController.navigate(Screen.Detail.route + "/$id")
            }
        }
    }
}

