package de.patrickwire.myapplication.mavigationexamples.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor() : ViewModel() {

    var isLoggedIn by mutableStateOf(false)
        private set

    fun login() {
        isLoggedIn = true
    }

    fun logout() {
        isLoggedIn = false
    }
}
