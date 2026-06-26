package org.scesi.cappuchinoawesome.ui.features.schedule.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ScheduleViewModel: ViewModel() {

    private val _openSemesters = MutableStateFlow<Boolean>(false)
    private val _openTeacherIndex = MutableStateFlow<Int?>(null)
    private val _openSubjectIndex = MutableStateFlow<Int?>(null)

    val openSemesters : StateFlow<Boolean> = _openSemesters.asStateFlow()
    val openTeacherIndex : StateFlow<Int?> = _openTeacherIndex.asStateFlow()
    val openSubjectIndex : StateFlow<Int?> = _openSubjectIndex.asStateFlow()

    fun toggleMenu(){
        _openSemesters.value = !_openSemesters.value
    }
    fun onClickSemester(index: Int){
        _openSubjectIndex.value = if (_openSubjectIndex.value == index) null else index
        //_openSubjectIndex.value = null
    }
    fun onClickSubject(index: Int){
        _openTeacherIndex.value = if (_openTeacherIndex.value == index) null else index
    }
}