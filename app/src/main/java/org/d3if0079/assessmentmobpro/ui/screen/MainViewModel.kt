package org.d3if0079.assessmentmobpro.ui.screen

import androidx.lifecycle.ViewModel
import org.d3if0079.assessmentmobpro.model.DataPasien

class MainViewModel : ViewModel() {

    val data = getDataDummy()

    private fun getDataDummy(): List<DataPasien> {
        val nama = arrayOf(
            "Feby Irmayana",
            "Aidil Aufa",
            "Aidil Fadila",
            "Rizky Anugrah",
            "Pasha Alkahfi"
        )

        val nik = arrayOf(
            "12031190",
            "12031191",
            "12031192",
            "12031193",
            "12031194"
        )

        val umur = arrayOf(
            "18 tahun",
            "19 tahun",
            "20 tahun",
            "21 tahun",
            "22 tahun"
        )

        val alamat = arrayOf(
            "Sukabirus",
            "Sukapura",
            "Buah Batu",
            "Margacinta",
            "Soekarno Hatta"
        )

        val jenisKelamin = arrayOf(
            "Perempuan",
            "laki-laki",
            "laki-laki",
            "laki-laki",
            "laki-laki"
        )

        val jenisKunjungan = arrayOf(
            "Umum",
            "Umum",
            "Bpjs",
            "Umum",
            "Bpjs"
        )

        val tanggalKunjungan = arrayOf(
            "06-05-2024",
            "07-05-2024",
            "08-05-2024",
            "09-05-2024",
            "10-05-2024"
        )

        val keluhan = arrayOf(
            "Sakit perut",
            "Demam",
            "Flu dan batuk",
            "Diare",
            "Sakit kepala"
        )

        val data = mutableListOf<DataPasien>()
        for (i in nama.indices) {
            data.add(
                DataPasien(
                    (i + 1).toLong(),
                    nama[i],
                    nik[i],
                    umur[i],
                    alamat[i],
                    jenisKelamin[i],
                    jenisKunjungan[i],
                    tanggalKunjungan[i],
                    keluhan[i]
                )
            )
        }
        data.sortBy { it.tanggalKunjungan }

        return data
    }
}