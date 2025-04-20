package com.example.mangaapp.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.mangaapp.R
import java.net.URLDecoder

@Composable
fun DetailedView(title: String, subtitle: String, summary: String, url: String) {
    val decodedTitle = URLDecoder.decode(title, "UTF-8")
    val decodedSubtitle = URLDecoder.decode(subtitle, "UTF-8")
    val decodedSummary = URLDecoder.decode(summary, "UTF-8")
    val decodedUrl = URLDecoder.decode(url, "UTF-8")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            AsyncImage(
                model = decodedUrl,
                contentDescription = decodedTitle,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .width(150.dp)
                    .height(250.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = decodedTitle,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Multiple titles with bullet points as shown in screenshot
                Text(
                    text = decodedSubtitle,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = decodedSummary,
            color = Color.White,
            fontSize = 14.sp,
        )
    }
}