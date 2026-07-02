package org.scesi.cappuchinoawesome.ui.utils.timetable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.scesi.cappuchinoawesome.network.data.GroupSubject
import org.scesi.cappuchinoawesome.ui.theme.text
import org.scesi.cappuchinoawesome.ui.utils.modal.Modal
import kotlin.collections.forEach
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.scesi.cappuchinoawesome.network.data.Day
import org.scesi.cappuchinoawesome.network.data.Slot


@Composable
fun SlotCard(
    modifier: Modifier = Modifier,
    groups: List<GroupSubject>,
    height: Dp,
    day: Day
){
    var selectForModal by remember { mutableStateOf<Pair<GroupSubject, Slot>?>(null) }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .padding(2.dp)
    ) {
        if(groups.isNotEmpty()){
            Column(modifier = Modifier.fillMaxSize()) {
                val cardHeight = height / groups.size
                groups.forEach { groupSubject ->
                    val currentSlot = groupSubject.group.schedule.firstOrNull(){it.day == day}
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(cardHeight)
                            .padding(1.dp),
                        onClick = {
                            if (currentSlot != null) {
                                selectForModal = Pair(groupSubject, currentSlot)
                            }
                        },
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.85f),
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(4.dp),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = groupSubject.subjectName,
                                style = MaterialTheme.typography.text,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = "G: ${groupSubject.group.code}",
                                style = MaterialTheme.typography.text,
                                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f)
                            )
                        }
                    }
                }
            }
        }
    }

    val currentGroup = selectForModal
    if (currentGroup != null) {
        val (groupSubject, clickedSlot) = currentGroup
        Modal(
            textHeader = groupSubject.subjectName,
            textMedium = clickedSlot.room,
            textFooter = "Grupo: ${groupSubject.group.code}",
            isClass = clickedSlot.isClass ,
            onDismiss = { selectForModal = null }
        )
    }
}