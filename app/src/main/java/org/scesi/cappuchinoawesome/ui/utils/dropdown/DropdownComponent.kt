package org.scesi.cappuchinoawesome.ui.utils.dropdown

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> DropDownComponent(
    items: List<T>,
    modifier: Modifier = Modifier,
    itemDivider: @Composable (() -> Unit)? = null,
    itemContent: @Composable (T) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(max = 400.dp)
    ) {
        items(
            count = items.size,
            key = { index -> index }
        ) {
            index ->
            val item = items[index]
            itemContent(item)
            if (itemDivider != null) {
                itemDivider()
            }
        }
    }
}