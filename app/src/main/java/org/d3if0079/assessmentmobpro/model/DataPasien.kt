package org.d3if0079.assessmentmobpro.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dataPasien")
data class DataPasien(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val nik: String,
    val umur: String,
    val alamat: String,
    val jenisKelamin: String,
    val jenisKunjungan: String,
    val tanggalKunjungan: String,
    val keluhan: String
)