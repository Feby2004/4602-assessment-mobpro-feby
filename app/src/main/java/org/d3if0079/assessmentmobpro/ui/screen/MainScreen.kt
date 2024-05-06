package org.d3if0079.assessmentmobpro.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.d3if0079.assessmentmobpro.R
import org.d3if0079.assessmentmobpro.model.DataPasien
import org.d3if0079.assessmentmobpro.ui.theme.AssessmentMobproTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Green,
                    titleContentColor = Color.Black
                )
            )
        }
    ){ padding ->
        ScreenContent(Modifier.padding(padding))
    }
}

@Composable
fun ScreenContent(modifier: Modifier) {
    val viewModel: MainViewModel = viewModel()
    val data = viewModel.data
    LazyColumn (
        modifier = modifier.fillMaxSize()
    ){
        items(data) {
            ListItem(dataPasien = it)
            Divider()
        }
    }
}

@Composable
fun ListItem(dataPasien: DataPasien) {
    Column (
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = dataPasien.nama,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = dataPasien.nik,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = dataPasien.umur,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = dataPasien.alamat,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = dataPasien.jenisKelamin,
            maxLines = 5,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = dataPasien.jenisKunjungan,
            maxLines = 6,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = dataPasien.tanggalKunjungan,
            maxLines = 7,
            overflow = TextOverflow.Ellipsis
        )
        Text(text = dataPasien.keluhan)
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ScreenPreview() {
    AssessmentMobproTheme {
        MainScreen()
    }
}