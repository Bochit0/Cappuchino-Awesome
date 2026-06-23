import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DropDown(
    itemCount: Int,
    modifier: Modifier = Modifier,
    itemDivider: @Composable (() -> Unit)? = null,
    itemContent: @Composable (Int) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(max = 400.dp)
    ) {
        items(itemCount) { index ->
            itemContent(index)
            if (itemDivider != null) {
                itemDivider()
            }
        }
    }
}