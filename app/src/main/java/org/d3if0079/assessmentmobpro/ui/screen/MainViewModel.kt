package org.d3if0079.assessmentmobpro.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if0079.assessmentmobpro.database.DataPasienDao
import org.d3if0079.assessmentmobpro.model.DataPasien

class MainViewModel (dao: DataPasienDao) : ViewModel() {

    val data: StateFlow<List<DataPasien>> = dao.getDataPasien().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}