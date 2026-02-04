package com.curso20252026.agendacontactos.repositories

import com.curso20252026.agendacontactos.dao.ContactDao
import com.curso20252026.agendacontactos.data.ContactEntity
import com.curso20252026.agendacontactos.data.ContactWithTasks
import com.curso20252026.agendacontactos.data.TaskEntity
import com.curso20252026.agendacontactos.domain.Contact
import com.curso20252026.agendacontactos.domain.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ContactRepository(private val contactDao: ContactDao) {


    // Insertar una tarea asociada a un contacto
    suspend fun insertTask(contactId: Int, taskTitle: String) {
        val taskEntity = TaskEntity(
            contactId = contactId,
            title = taskTitle,
            isDone = false
        )
        contactDao.insertTask(taskEntity)
    }

    suspend fun updateTaskStatus(taskId: Int, isDone: Boolean){
        contactDao.updateTaskStatus(taskId, isDone)
    }

    // Obtener contacto con sus tareas para el detalle
    fun getContactWithTasks(id: Int): Flow<Contact?> {
        return contactDao.getContactWithTasks(id).map { relation ->
            relation?.toDomain()
        }
    }

    fun getAllContacts(): Flow<List<Contact>>{
        return contactDao.getAllContacts().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    fun getContactById(id: Int): Flow<Contact?>{
        return contactDao.getContactById(id).map { it?.toDomain()}
    }

    suspend fun insertContact(contact: Contact){
        contactDao.insert(contact.toEntity())
    }

    suspend fun updateContact( contact: Contact){
        contactDao.update(contact.toEntity())
    }

    suspend fun deleteContact( contact: Contact){
        contactDao.delete(contact.toEntity())
    }

    suspend fun deleteTask(taskId: Int){
        contactDao.deleteTask(taskId)
    }
}

// Mapper actualizado
fun ContactWithTasks.toDomain() = Contact(
    id = contact.id,
    name = contact.name,
    phone = contact.phone,
    address = contact.address,
    tasks = tasks.map { Task(it.taskId, it.title, it.isDone) }
)

fun ContactEntity.toDomain() = Contact(id, name, phone, address)

fun Contact.toEntity() = ContactEntity(id, name, phone, address)