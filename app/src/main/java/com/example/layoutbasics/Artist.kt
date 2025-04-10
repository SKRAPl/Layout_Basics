package com.example.layoutbasics

import androidx.compose.ui.graphics.painter.Painter

data class Artist(
    val image: Painter,
    val name: String,
    val lastSeenOnline: String
)