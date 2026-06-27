package org.scesi.cappuchinoawesome.ui.utils.dropdown

import androidx.compose.animation.expandVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> DropDownComponent(
    items: List<T>,
    modifier: Modifier = Modifier,
    verticalLine: Boolean = false,
    itemDivider: @Composable (() -> Unit)? = null,
    itemContent: @Composable (T) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(max = 400.dp)
        ) {
            items(
                count = items.size,
                key = { index -> index }
            ) { index ->
                val item = items[index]
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    if (verticalLine) {
                        Box(
                            modifier = Modifier
                                .width(5.dp)
                                .height(54.dp)
                                .background(MaterialTheme.colorScheme.secondary)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        itemContent(item)
                    }
                }
                if (itemDivider != null) {
                    itemDivider()
                }
            }
        }
    }
}