package org.d3if0079.assessmentmobpro.navigation

import org.d3if0079.assessmentmobpro.ui.screen.KEY_ID_DATAPASIEN

sealed class Screen (val route: String) {
    data object Home: Screen("mainScreen")
    data object FormBaru: Screen("detailScreen")
    data object FormUbah: Screen("detailScreen/{$KEY_ID_DATAPASIEN}") {
        fun withId(id:Long) = "detailScreen/$id"
    }
}