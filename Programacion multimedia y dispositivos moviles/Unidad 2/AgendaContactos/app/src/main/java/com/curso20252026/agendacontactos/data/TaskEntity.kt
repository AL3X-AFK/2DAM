package com.curso20252026.agendacontactos.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(
    tableName = "tasks",
    foreignKeys = [
        ForeignKey(
            entity = ContactEntity::class,
            parentColumns = ["id"],
            childColumns = ["contactId"],
            onDelete = ForeignKey.CASCADE // Si borras el contacto, se borran sus tareas
        )
    ]
)

data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val taskId: Int = 0,
    val contactId: Int, // Enlace con el contacto
    val title: String,
    val isDone: Boolean = false
)

data class ContactWithTasks(
    @Embedded val contact: ContactEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "contactId"
    )
    val tasks: List<TaskEntity>
)