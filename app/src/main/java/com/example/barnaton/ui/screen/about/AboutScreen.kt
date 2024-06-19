package com.example.barnaton.ui.screen.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barnaton.R
import com.example.barnaton.ui.components.CircleImageView
import com.example.barnaton.ui.theme.BarnatonTheme
import com.example.barnaton.ui.theme.midNightBlue

@Composable
fun AboutScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(midNightBlue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircleImageView()
        Text(
            text = stringResource(R.string.name_profil),
            color = Color.White,
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier.padding(top = 16.dp)
        )

        Text(
            text = stringResource(R.string.email_profile),
            color = Color.White,
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier.padding(top = 16.dp)
        )

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AboutScreenPreview() {
    BarnatonTheme {
        AboutScreen()
    }
}