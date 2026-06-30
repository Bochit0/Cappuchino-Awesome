package org.scesi.cappuchinoawesome.ui.features.schedule.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.scesi.cappuchinoawesome.ui.features.schedule.data.ScheduleService
import org.scesi.cappuchinoawesome.ui.network.data.DetailCareer
import org.scesi.cappuchinoawesome.ui.network.data.Group
import org.scesi.cappuchinoawesome.ui.network.data.GroupSubject
import org.scesi.cappuchinoawesome.ui.network.data.StatesControl

class ScheduleViewModel: ViewModel() {

    private val detailService = ScheduleService()

    private val _detailState = MutableStateFlow<StatesControl <DetailCareer>>(StatesControl.Loading)
    private val _openSemesters = MutableStateFlow<Boolean>(false)
    private val _openTeacherIndex = MutableStateFlow<Int?>(null)
    private val _openSubjectIndex = MutableStateFlow<String?>(null)
    private val _selectedGroups = MutableStateFlow<List<GroupSubject>>(emptyList())

    val detailState : StateFlow< StatesControl <DetailCareer>> = _detailState.asStateFlow()
    val openSemesters : StateFlow<Boolean> = _openSemesters.asStateFlow()
    val openTeacherIndex : StateFlow<Int?> = _openTeacherIndex.asStateFlow()
    val openSubjectIndex : StateFlow<String?> = _openSubjectIndex.asStateFlow()
    val selectedGroups : StateFlow< List <GroupSubject>> = _selectedGroups.asStateFlow()

    fun toggleMenu(){
        _openSemesters.value = !_openSemesters.value
    }
    fun onClickSemester(index: String){
        _openSubjectIndex.value = if (_openSubjectIndex.value == index) null else index
    }
    fun onClickSubject(index: Int){
        _openTeacherIndex.value = if (_openTeacherIndex.value == index) null else index
    }

    fun loadDetail(code: Int){
        viewModelScope.launch {
            _detailState.value = StatesControl.Loading
            try {
                val result = detailService.getDetailCareer(code)
                _detailState.value = if (result.levels.isEmpty()){
                    StatesControl.Empty
                }else {
                    StatesControl.Success(result)
                }
            }catch(e: Exception) {
                _detailState.value = StatesControl.Error("No hay contenido")
            }
        }
    }

    fun isGroupSelected(group: Group, selectedGroups: List<GroupSubject>): Boolean {
        for (gs in selectedGroups) {
            if (gs.group == group) {
                return true
            }
        }
        return false
    }
    fun selectGroup(group: Group, subjectName: String){
        val currentGroups = _selectedGroups.value
        val item = GroupSubject(group, subjectName)

        val isSelected = isGroupSelected(group, currentGroups)
        if (isSelected) {
            val newList = mutableListOf<GroupSubject>()
            for (gs in currentGroups) {
                if (gs.group != group) {
                    newList.add(gs)
                }
            }
            _selectedGroups.value = newList
        } else {
            val newList = mutableListOf<GroupSubject>()
            newList.addAll(currentGroups)
            newList.add(item)
            _selectedGroups.value = newList
        }
    }
}