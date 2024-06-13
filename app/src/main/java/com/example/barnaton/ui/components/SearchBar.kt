package com.example.barnaton.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barnaton.ui.theme.BarnatonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar(
    query: String = "",
    onSearch: ((String) -> Unit)? = null,
) {
    SearchBar(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
//            .heightIn(min = 48.dp),
        query = query,
        onQueryChange = {

        },
        onSearch = {
            onSearch?.invoke(it)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        active = query.isNotBlank(),
        onActiveChange = {

        },
        placeholder = {
            Text(text = "Search TV Series....")
        },
        shape = MaterialTheme.shapes.large,
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun CustomSearchBarPreview() {
    BarnatonTheme {
        CustomSearchBar()
    }
}