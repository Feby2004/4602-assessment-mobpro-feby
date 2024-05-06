package org.d3if0079.assessmentmobpro.navigation

sealed class Screen (val route: String) {
    data object Home: Screen("mainScreen")
    data object FormBaru: Screen("detailScreen")
}