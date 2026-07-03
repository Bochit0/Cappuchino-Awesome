package org.scesi.cappuchinoawesome.ui.utils.timetable

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.scesi.cappuchinoawesome.network.data.Day
import org.scesi.cappuchinoawesome.network.data.GroupSubject
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
    var maxInAnyDay = 0

    for (day in Day.entries) {
        var countInDay = 0
        for (gs in selectedGroups) {
            for (slot in gs.group.schedule) {
                if (slot.day == day && formatJSONTime(slot.start) == blockTime) {
                    countInDay++
                }
            }
        }
        if (countInDay > maxInAnyDay) {
            maxInAnyDay = countInDay
        }
    }

    return (maxOf(1, maxInAnyDay) * BASE_DP_GROUP).dp
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
    Row(
        modifier =
            Modifier.fillMaxHeight(),
        verticalAlignment = Alignment.Top
    ) {
        Column(
            modifier = Modifier
                .width(56.dp)
                .padding(top = 32.dp)
        ) {
            val lineColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.7f)
            hours.forEachIndexed { index, hour ->
                Box(
                    modifier = Modifier
                        .height(rowHeights[index])
                        .fillMaxWidth()
                        .drawBehind {
                        drawLine(
                            color = lineColor,
                            start = Offset(0f, size.height),
                            end = Offset(size.width, size.height),
                            strokeWidth = 6.dp.toPx()
                        )
                    },
                    contentAlignment = Alignment.TopCenter
                ) {
                    Text(
                        text = hour,
                        style = MaterialTheme.typography.subtitle,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(4.dp)
                .background(
                    MaterialTheme.colorScheme.secondary
                )
        )
    }
}

@Composable
fun DayColumn(
    day: Day,
    timeBlocks: List<String>,
    rowHeights: List<Dp>,
    selectedGroups: List<GroupSubject>
){
    Column(
        modifier = Modifier
            .width(96.dp)
            .padding(horizontal = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .background(
                    MaterialTheme.colorScheme.primary,
                    RoundedCornerShape(4.dp)),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = day.name,
                style = MaterialTheme.typography.subtitle,
                color = MaterialTheme.colorScheme.onPrimary
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
                height = rowHeights[index],
                day = day
            )
        }
    }
}

