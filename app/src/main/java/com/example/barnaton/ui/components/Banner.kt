package com.example.barnaton.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barnaton.R
import com.example.barnaton.ui.theme.BarnatonTheme

@Composable
fun Banner(
    modifier: Modifier = Modifier,
    onSearch: ((String) -> Unit)? = null,
) {
    Column(
        modifier = modifier.background(Color.White).fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_tmdb),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.padding(start = 16.dp, top = 16.dp)
        )
        CustomSearchBar(
            onSearch = {
                onSearch?.invoke(it)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBanner() {
    BarnatonTheme {
        Banner()
    }
}