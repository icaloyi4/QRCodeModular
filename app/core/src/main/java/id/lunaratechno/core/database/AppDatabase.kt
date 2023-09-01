package id.lunaratechno.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import id.lunaratechno.core.database.entity.TransactionEntity

@Database(entities = [TransactionEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val databaseDao: DatabaseDao
}