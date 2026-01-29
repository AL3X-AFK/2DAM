package com.curso20252026.agendacontactos.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.curso20252026.agendacontactos.data.ContactEntity
import com.curso20252026.agendacontactos.data.ContactWithTasks
import com.curso20252026.agendacontactos.data.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contact: ContactEntity)

    @Update
    suspend fun update(contact: ContactEntity)

    @Delete
    suspend fun delete(contact: ContactEntity)

    @Query("SELECT * FROM ContactEntity ORDER BY name ASC")
    fun getAllContacts(): Flow<List<ContactEntity>>

    @Query("SELECT * FROM ContactEntity WHERE id = :id")
    fun getContactById(id: Int): Flow<ContactEntity?>

    @Transaction // Necesario para consultas relacionales
    @Query("SELECT * FROM ContactEntity WHERE id = :id")
    fun getContactWithTasks(id: Int): Flow<ContactWithTasks?>

    @Insert
    suspend fun insertTask(task: TaskEntity)

    @Query("UPDATE tasks SET isDone = :isDone WHERE taskId = :taskId")
    suspend fun updateTaskStatus(taskId: Int, isDone: Boolean)

    @Query("DELETE FROM tasks WHERE taskId = :taskId")
    suspend fun deleteTask(taskId: Int)
}