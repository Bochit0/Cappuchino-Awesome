package org.scesi.cappuchinoawesome.ui.features.schedule.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.scesi.cappuchinoawesome.ui.network.data.DetailCareer
import org.scesi.cappuchinoawesome.ui.network.data.Group
import org.scesi.cappuchinoawesome.ui.network.data.Level
import org.scesi.cappuchinoawesome.ui.network.data.StatesControl
import org.scesi.cappuchinoawesome.ui.network.data.Subject
import org.scesi.cappuchinoawesome.ui.utils.button.ButtonComponent
import org.scesi.cappuchinoawesome.ui.utils.dropdown.DropDownComponent
import org.scesi.cappuchinoawesome.ui.utils.header.HeaderComponent
import org.scesi.cappuchinoawesome.ui.utils.icons.Icons
import org.scesi.cappuchinoawesome.ui.utils.itemcard.ItemCard
import org.scesi.cappuchinoawesome.ui.utils.timetable.TimeTable

@Composable
fun ScheduleScreen(
    viewModel: ScheduleViewModel = viewModel(),
    careerCode: Int
){
    LaunchedEffect(careerCode) {
        viewModel.loadDetail(careerCode)
    }

    val detailState by viewModel.detailState.collectAsStateWithLifecycle()

    Box(modifier = Modifier.fillMaxSize()){
        Schedule(viewModel, detailState = detailState)
    }
}

@Composable
fun Schedule(
    viewModel: ScheduleViewModel,
    modifier: Modifier = Modifier,
    detailState: StatesControl<DetailCareer>
){
    val openMenu by viewModel.openSemesters.collectAsStateWithLifecycle()
    val selectedGroups by viewModel.selectedGroups.collectAsStateWithLifecycle()
    Column(modifier = modifier
        .fillMaxSize()
    ) {
        val titleHeader = when (detailState) {
            is StatesControl.Success -> detailState.data.name
            is StatesControl.Loading -> "Cargando..."
            is StatesControl.Error -> "Error"
            is StatesControl.Empty -> ""
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .windowInsetsTopHeight(WindowInsets.statusBars)
        )
        HeaderComponent(
            titleHeader = titleHeader,
            backgroundColor = MaterialTheme.colorScheme.secondary,
            titleColor = MaterialTheme.colorScheme.background,
            leftAction = {ButtonComponent(
                onClick = { viewModel.toggleMenu() },
                isIcon = Icons.listNested(color = MaterialTheme.colorScheme.secondary),
                backgroundColor = MaterialTheme.colorScheme.secondary,
                textColor = MaterialTheme.colorScheme.background
            )},
            rightAction = { ButtonComponent(
                onClick = {},
                isIcon = Icons.listNested(),
                backgroundColor = MaterialTheme.colorScheme.secondary,
                textColor = MaterialTheme.colorScheme.background
            )}
        )

        Spacer(Modifier.height(30.dp))

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            TimeTable(selectedGroup = selectedGroups)

            if (openMenu) {
                when (detailState) {
                    is StatesControl.Success -> InteractiveMenu(
                        viewModel = viewModel,
                        levels = detailState.data.levels
                    )

                    is StatesControl.Loading -> CircularProgressIndicator()
                    is StatesControl.Error -> Text(text = detailState.message)
                    is StatesControl.Empty -> Text(text = "Sin datos")
                }
            }
        }
    }
}
@Composable
fun InteractiveMenu(
    viewModel: ScheduleViewModel,
    levels: List<Level>
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.55f)
            .background(MaterialTheme.colorScheme.tertiary)
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(levels) { index, level ->
                SemesterItem(
                    viewModel = viewModel,
                    semesterCode = "SEMESTRE ${level.code}",
                    subjects = level.subjects
                )
            }
        }
    }
}

@Composable
fun SemesterItem(
    viewModel: ScheduleViewModel,
    semesterCode: String,
    subjects: List<Subject>,
) {
    val openSubjectIndex by viewModel.openSubjectIndex.collectAsStateWithLifecycle()
    val isExpanded = openSubjectIndex == semesterCode

    Column {
        ItemCard(
            name = semesterCode,
            onClick = { viewModel.onClickSemester(semesterCode) },
        )
        if (isExpanded) {
            DropDownComponent(
                items = subjects,
                itemContent = { subject ->
                    SubjectItem(
                        subjectName =
                            subject.name,
                        subject.code,
                        subject.groups,
                        viewModel
                    )
                }
            )
        }
    }
}

@Composable
fun SubjectItem(
    subjectName: String,
    subjectCode: Int,
    groups: List<Group>,
    viewModel: ScheduleViewModel
){
    val openSubjectIndex by viewModel.openTeacherIndex.collectAsStateWithLifecycle()
    val isExpanded = openSubjectIndex == subjectCode

    Column {
        ItemCard(
            name = subjectName,
            onClick = { viewModel.onClickSubject(subjectCode) },
        )
        if (isExpanded) {
            DropDownComponent(
                items = groups,
                itemContent = { group ->
                    GroupItem(
                        group = group,
                        subjectName = subjectName,
                        viewModel = viewModel
                    )
                }
            )
        }
    }
}

@Composable
fun GroupItem(
    group: Group,
    subjectName: String,
    viewModel: ScheduleViewModel
){
    val selectedGroups by viewModel.selectedGroups.collectAsStateWithLifecycle()
    val isSelected = viewModel.isGroupSelected(group, selectedGroups)
    ItemCard(
        name = group.teacher,
        onClick = { viewModel.selectGroup(group, subjectName) },
        containerColor = if (isSelected)
            MaterialTheme.colorScheme.primary
        else
            MaterialTheme.colorScheme.background,
        contentColor = if (isSelected)
            MaterialTheme.colorScheme.onPrimary
        else
            MaterialTheme.colorScheme.onSurface
    )
}