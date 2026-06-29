package org.scesi.cappuchinoawesome.ui.utils.timetable

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.scesi.cappuchinoawesome.ui.network.data.Day
import org.scesi.cappuchinoawesome.ui.network.data.GroupSubject
import org.scesi.cappuchinoawesome.ui.theme.subtitle

const val BASE_DP_GROUP = 60

val hours = listOf(
    "06:45",
    "08:15",
    "09:45",
    "11:15",
    "12:45",
    "14:15",
    "15:45",
    "17:15",
    "18:45",
    "20:15",
)
fun rowHeightForBlock(
    blockTime: String,
    selectedGroups: List<GroupSubject>
): Dp {
    val groupsInBlock = selectedGroups.count { groupSubject ->
        groupSubject.group.schedule.any { slot ->
            formatJSONTime(slot.start) == blockTime
        }
    }
    return (maxOf(1, groupsInBlock) * BASE_DP_GROUP).dp
}

fun formatJSONTime(start: String): String {
    return when (start.length) {
        3 -> "0${start[0]}:${start.substring(1)}"
        4 -> "${start.substring(0, 2)}:${start.substring(2)}"
        else -> start
    }
}

@Composable
fun TimeTable(selectedGroup: List<GroupSubject> = emptyList()){
    val rowHeights = remember(selectedGroup) {
        hours.map { block ->
            rowHeightForBlock(block, selectedGroup)
        }
    }

    Row(modifier = Modifier.fillMaxSize()) {
        HourColumn(rowHeights = rowHeights)

        Row(
            modifier = Modifier
                .fillMaxSize()
                .horizontalScroll(rememberScrollState())
                .verticalScroll(rememberScrollState())
        ) {
            Day.entries.forEach { day ->
                DayColumn(
                    day = day,
                    timeBlocks = hours,
                    rowHeights = rowHeights,
                    selectedGroups = selectedGroup
                )
            }
        }
    }
}

@Composable
fun HourColumn(rowHeights: List<Dp>){
    Column(modifier = Modifier
        .width(56.dp)
        .padding(top = 32.dp)
    ) {
        hours.forEachIndexed { index ,hour ->
            Box(
                modifier = Modifier
                    .height(rowHeights[index])
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(
                    text = hour,
                    style = MaterialTheme.typography.subtitle,
                    color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.6f)
                )
            }
        }
    }
}

@Composable
fun DayColumn(
    day: Day,
    timeBlocks: List<String>,
    rowHeights: List<Dp>,
    selectedGroups: List<GroupSubject>
){
    Column(modifier = Modifier.width(96.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .background(MaterialTheme.colorScheme.secondary),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = day.name,
                style = MaterialTheme.typography.subtitle,
                color = MaterialTheme.colorScheme.background
            )
        }

        timeBlocks.forEachIndexed { index, blockTime ->
            val groupsInBlock = selectedGroups.filter { groupSubject ->
                groupSubject.group.schedule.any { slot ->
                    slot.day == day &&
                            formatJSONTime(slot.start) == blockTime
                }
            }

            SlotCard(
                groups = groupsInBlock,
                height = rowHeights[index]
            )
        }
    }
}

@Composable
fun SlotCard(
    groups: List<GroupSubject>,
    height: Dp,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .padding(2.dp)
    ) {
        if(groups.isNotEmpty()){
            Column(modifier = Modifier.fillMaxSize()) {
                val cardHeight = height / groups.size
                groups.forEach { group ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(cardHeight)
                            .padding(1.dp),
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
                                text = group.subjectName,
                                style = MaterialTheme.typography.labelSmall,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = group.group.code,
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f)
                            )
                        }
                    }
                }
            }
        }
    }
}

