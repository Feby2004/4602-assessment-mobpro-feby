package org.d3if0079.assessmentmobpro.ui.screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0079.assessmentmobpro.model.Bunga
import org.d3if0079.assessmentmobpro.network.BungaApi

class MainViewModel : ViewModel() {

    var data = mutableStateOf(emptyList<Bunga>())
        private set
    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                data.value = BungaApi.service.getBunga()
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
            }
        }
    }
}