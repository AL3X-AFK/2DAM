package com.curso20252026.agendacontactos.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.curso20252026.agendacontactos.domain.Contact
import com.curso20252026.agendacontactos.repositories.ContactRepository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ContactViewModel(
    private val repository: ContactRepository
    // 1. ELIMINAMOS el contactId de aquí, no se necesita para listar todos
): ViewModel() {

    val contacts = repository
        .getAllContacts()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            emptyList()
        )

    // 2. ELIMINAMOS addTask de aquí (eso va en el DetailViewModel)

    fun addContact(contact: Contact) {
        viewModelScope.launch {
            repository.insertContact(contact)
        }
    }
}

class ContactViewModelFactory(private val repository: ContactRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            // 3. Ahora esto ya no da error porque los parámetros coinciden
            return ContactViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}