package org.d3if0079.assessmentmobpro.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if0079.assessmentmobpro.model.DataPasien

@Database(entities = [DataPasien::class], version = 1, exportSchema = false)
abstract class DataPasienDb : RoomDatabase() {

    abstract val dao: DataPasienDao

    companion object {

        @Volatile
        private var INSTANCE: DataPasienDb? = null

        fun getInstance(context: Context): DataPasienDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataPasienDb::class.java,
                        "dataPasien.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}