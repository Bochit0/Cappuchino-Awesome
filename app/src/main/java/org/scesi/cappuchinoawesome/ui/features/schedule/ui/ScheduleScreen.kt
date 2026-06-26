package org.scesi.cappuchinoawesome.ui.features.schedule.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.scesi.cappuchinoawesome.ui.features.home.ui.HomeViewModel
import org.scesi.cappuchinoawesome.ui.utils.button.ButtonComponent
import org.scesi.cappuchinoawesome.ui.utils.dropdown.DropDownComponent
import org.scesi.cappuchinoawesome.ui.utils.header.HeaderComponent
import org.scesi.cappuchinoawesome.ui.utils.icons.Icons
import org.scesi.cappuchinoawesome.ui.utils.itemcard.ItemCard

@Composable
fun ScheduleScreen(viewModel: ScheduleViewModel = viewModel()){
    Box(modifier = Modifier.fillMaxSize()){
        Schedule(viewModel)
    }
}

@Composable
fun Schedule(
    viewModel: ScheduleViewModel,
    modifier: Modifier = Modifier
){
    val openMenu by viewModel.openSemesters.collectAsStateWithLifecycle()
    Column(modifier = modifier
        .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .windowInsetsTopHeight(WindowInsets.statusBars)
        )
        HeaderComponent(
            titleHeader = "MANTECOÑO",
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

        if(openMenu){
            InteractiveMenu(viewModel)
        }

        TableTime()


    }
}
@Composable
fun InteractiveMenu(viewModel: ScheduleViewModel) {
    val semestres = List(8) { "Semestre ${it + 1}" }
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.55f)
            .background(MaterialTheme.colorScheme.tertiary)
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(semestres) { index, semestre ->
                SemesterItem(
                    viewModel = viewModel,
                    semesterName = semestre,
                    index = index
                )
            }
        }
    }
}


@Composable
fun SemesterItem(
    viewModel: ScheduleViewModel,
    semesterName: String,
    index: Int
) {
    val materias = List(7) { "Materia ${it + 1}" }
    val openSemesterIndex by viewModel.openSubjectIndex.collectAsStateWithLifecycle()
    val isExpanded = openSemesterIndex == index

    Column {
        ItemCard(
            name = semesterName,
            onClick = { viewModel.onClickSemester(index) },
        )
        if (isExpanded) {
            DropDownComponent(
                items = materias,
                itemContent = { materia ->
                    SubjectItem(subjectName = materia, index, viewModel)
                }
            )
        }
    }
}

@Composable
fun SubjectItem(
    subjectName: String,
    index: Int,
    viewModel: ScheduleViewModel
){
    val docentes = List(2) { "Docente ${it + 1}" }
    val openSubjectIndex by viewModel.openTeacherIndex.collectAsStateWithLifecycle()
    val isExpanded = openSubjectIndex == index

    Column {
        ItemCard(
            name = subjectName,
            onClick = { viewModel.onClickSubject(index) },
        )
        if (isExpanded) {
            DropDownComponent(
                items = docentes,
                itemContent = { docente ->
                    TeacherItem(teacherName = docente)
                }
            )
        }
    }
}

@Composable
fun TeacherItem(teacherName: String){
    ItemCard(
        name = teacherName,
        onClick = {},
    )
}

@Composable
fun TableTime(){}