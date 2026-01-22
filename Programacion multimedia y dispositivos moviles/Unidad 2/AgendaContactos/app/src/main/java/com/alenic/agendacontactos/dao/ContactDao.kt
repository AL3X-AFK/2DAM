package com.alenic.agendacontactos.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.alenic.agendacontactos.data.ContactEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contact: ContactEntity)

    @Update
    suspend fun  update(contact: ContactEntity)

    @Delete
    suspend fun delete(contact: ContactEntity)

    @Query(value = "SELECT * FROM ContactEntity ORDER BY name ASC ")
    fun getAllContact(): Flow<List<ContactEntity>>

    @Query("SELECT * FROM ContactEntity WHERE id = :id")
    fun getContactById(id: Int): Flow<ContactEntity?>

}