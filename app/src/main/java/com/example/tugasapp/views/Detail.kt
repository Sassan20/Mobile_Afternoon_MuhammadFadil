package com.example.tugasapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.tugasapp.data.DummyData
import com.example.tugasapp.model.Berita

@Composable
fun DetailberitaScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    beritaId: Int?
) {
    val newBersList = DummyData.berita.filter { ber ->
        ber.id == beritaId
    }
    Column(
        modifier = modifier
    ) {
        DetailberitaContent(newBeritasList = newBersList)
    }
}

@Composable
private fun DetailberitaContent(
    newBeritasList: List<Berita>,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data = newBeritasList[0].photo)
                .build(),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(height = 250.dp, width = 500.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentDescription = "Poster Movie"
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.padding(4.dp)) {
            Text(
                text = newBeritasList[0].judul,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${newBeritasList[0].detail}",
                style = MaterialTheme.typography.titleSmall,
            )
            Text(
                text = "Pencipta : ${newBeritasList[0].pencipta}",
                style = MaterialTheme.typography.titleSmall,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailBeritaContentPreview() {
    DetailberitaContent(newBeritasList = DummyData.berita)
}