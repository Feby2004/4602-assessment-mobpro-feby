package org.d3if0079.assessmentmobpro.ui.screen

import androidx.lifecycle.ViewModel
import org.d3if0079.assessmentmobpro.model.DataPasien

class DetailViewModel : ViewModel() {
    private val mainViewModel = MainViewModel()

    fun getDataPasien(id: Long): DataPasien? {
        return mainViewModel.data.find { it.id == id }
    }
}