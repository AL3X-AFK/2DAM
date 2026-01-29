package com.curso20252026.agendacontactos.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.curso20252026.agendacontactos.domain.Contact
import com.curso20252026.agendacontactos.repositories.ContactRepository

import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ContactDetailViewModel(
    private val repository: ContactRepository,
    private val contactId: Int
) : ViewModel() {

    val contact: StateFlow<Contact?> = repository
        .getContactById(contactId)
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            null
        )

    fun addTask(title: String) {
        if (title.isBlank()) return
        viewModelScope.launch {
            // El ID del contacto ya lo tenemos en el ViewModel
            repository.insertTask(contactId, title)
        }
    }

    fun updateContact(name: String, phone: String, address: String) {
        val currentContact = contact.value ?: return
        viewModelScope.launch {
            repository.updateContact(currentContact.copy(name = name, phone = phone, address = address))
        }
    }

    fun deleteContact(onDeleted: () -> Unit) {
        val currentContact = contact.value ?: return
        viewModelScope.launch {
            repository.deleteContact(currentContact)
            onDeleted()
        }
    }

    fun toggleTask(taskId: Int, isDone: Boolean){
        viewModelScope.launch{
            repository.updateTaskStatus(taskId, isDone)
        }
    }

    fun deleteTask(taskId: Int){
        viewModelScope.launch {
            repository.deleteTask(taskId)
        }
    }


}

class ContactDetailViewModelFactory(
    private val repository: ContactRepository,
    private val contactId: Int
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactDetailViewModel::class.java)) {
            return ContactDetailViewModel(repository, contactId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}