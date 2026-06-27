package org.scesi.cappuchinoawesome.ui.features.schedule.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.scesi.cappuchinoawesome.ui.features.schedule.data.ScheduleService
import org.scesi.cappuchinoawesome.ui.network.data.DetailCareer
import org.scesi.cappuchinoawesome.ui.network.data.StatesControl

class ScheduleViewModel: ViewModel() {

    private val detailService = ScheduleService()

    private val _detailState = MutableStateFlow<StatesControl <DetailCareer>>(StatesControl.Loading)
    private val _openSemesters = MutableStateFlow<Boolean>(false)
    private val _openTeacherIndex = MutableStateFlow<Int?>(null)
    private val _openSubjectIndex = MutableStateFlow<String?>(null)

    val detailState : StateFlow< StatesControl <DetailCareer>> = _detailState.asStateFlow()
    val openSemesters : StateFlow<Boolean> = _openSemesters.asStateFlow()
    val openTeacherIndex : StateFlow<Int?> = _openTeacherIndex.asStateFlow()
    val openSubjectIndex : StateFlow<String?> = _openSubjectIndex.asStateFlow()

    fun toggleMenu(){
        _openSemesters.value = !_openSemesters.value
    }
    fun onClickSemester(index: String){
        _openSubjectIndex.value = if (_openSubjectIndex.value == index) null else index
        //_openSubjectIndex.value = null
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
}