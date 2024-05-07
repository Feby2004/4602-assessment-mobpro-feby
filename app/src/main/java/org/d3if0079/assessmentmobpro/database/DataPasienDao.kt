package org.d3if0079.assessmentmobpro.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import org.d3if0079.assessmentmobpro.model.DataPasien


@Dao
interface DataPasienDao {

    @Insert
    suspend fun insert(dataPasien: DataPasien)

    @Insert
    suspend fun update(dataPasien: DataPasien)

    @Query("SELECT * FROM dataPasien ORDER BY tanggalKunjungan DESC")
    fun getDataPasien(): Flow<List<DataPasien>>

}