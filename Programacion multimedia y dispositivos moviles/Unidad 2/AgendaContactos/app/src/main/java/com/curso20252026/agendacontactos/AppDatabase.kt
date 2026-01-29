package com.curso20252026.agendacontactos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.curso20252026.agendacontactos.dao.ContactDao
import com.curso20252026.agendacontactos.data.ContactEntity
import com.curso20252026.agendacontactos.data.TaskEntity

@Database (entities = [ContactEntity::class, TaskEntity::class], version = 4, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "contact_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}