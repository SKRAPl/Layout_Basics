package com.example.layoutbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.layoutbasics.ui.theme.LayoutBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutBasicsTheme {
                val l = Artist(
                    image = painterResource(id = R.drawable._147c8341cda0333ceaaacc75f5f44e1),
                    name = "Alexey Nakano",
                    lastSeenOnline = "3 minutes ago"
                )
                ArtistCardRow(l)
            }
        }
    }
}

@Composable
fun ArtistCardRow(artist: Artist) {
    var isImageVisible by remember { mutableStateOf(false) }

    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(5.dp)
            .clickable { isImageVisible = !isImageVisible }
            .fillMaxWidth()
    ){
        ArtistAvatar(
            artist
        )
        Column {
            Text(artist.name)
            Text(
                artist.lastSeenOnline,
                fontSize = 10.sp,
                color = Color.Gray
            )
        }
    }
    if (isImageVisible) {
        Image(
            painter = painterResource(id = R.drawable._612273681_3_p_oboi_na_rabochii_stol_anime_art_deviantart_3),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(top = 50.dp, bottom = 5.dp, start = 5.dp, end = 5.dp)
                .clip(RoundedCornerShape(5.dp))
        )
    }

}

@Composable
fun ArtistAvatar (artist: Artist) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .padding(end = 10.dp)

    ){
        Image(
            painter = artist.image,
            contentDescription = "Artist image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(35.dp)
                )
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = "Check mark",
            tint = Color.White,
            modifier = Modifier
                .size(15.dp)
                .clip(CircleShape)
                .background(Color.Black)
                .border(1.dp, Color.White, shape = CircleShape)
                .align(Alignment.BottomEnd)
                .padding(4.dp)

        )
    }
}

@Preview (showBackground = true)
@Composable
fun ArtistPreview(){
    val l = Artist(
        image = painterResource(id = R.drawable._147c8341cda0333ceaaacc75f5f44e1),
        name = "Alexey Nakano",
        lastSeenOnline = "3 minutes ago"
    )
    ArtistCardRow(l)
}