package org.d3if0079.assessmentmobpro.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if0079.assessmentmobpro.model.DataPasien


@Dao
interface DataPasienDao {

    @Insert
    suspend fun insert(dataPasien: DataPasien)

    @Update
    suspend fun update(dataPasien: DataPasien)

    @Query("SELECT * FROM dataPasien ORDER BY tanggalKunjungan DESC")
    fun getDataPasien(): Flow<List<DataPasien>>

    @Query("SELECT * FROM dataPasien WHERE id = :id")
    suspend fun getDataPasienById(id: Long): DataPasien?

}