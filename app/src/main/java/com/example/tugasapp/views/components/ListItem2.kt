package com.example.tugasapp.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasapp.R
import com.example.tugasapp.model.Berita
import com.example.tugasapp.ui.theme.TugasAppTheme

@Composable
fun Item2 (
    berita2: Berita,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable {
             onItemClicked(berita2.id)
            }
    ) {
        Image(
            painter = painterResource(id = berita2.photo),
            contentDescription = berita2.judul,
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = berita2.judul, style = MaterialTheme.typography.titleMedium)
                Text(text = "Pencipta :")
            Row {
                Text(text = berita2.pencipta, color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BeritaItem2() {
    TugasAppTheme {
        Item2(
            berita2 = Berita(
                1,
                "Ambatron",
                "",
                "",
                "Prof. Faiz",
                R.drawable.ambatron
            ),
            onItemClicked = { BeritaId ->
                println("Berita : $BeritaId")
            }
        )
    }
}