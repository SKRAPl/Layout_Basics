package com.example.layoutbasics

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel

class ArtistModel: ViewModel() {
    var image: MutableState<Painter?> = mutableStateOf(null)
        private set


    fun SetImage(newImage: Painter) {
        image.value = newImage
    }
}