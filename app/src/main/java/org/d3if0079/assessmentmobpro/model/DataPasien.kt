package org.d3if0079.assessmentmobpro.model

data class DataPasien(
    val id: Long,
    val nama: String,
    val nik: String,
    val umur: String,
    val alamat: String,
    val jenisKelamin: String,
    val jenisKunjungan: String,
    val tanggalKunjungan: String,
    val keluhan: String
)