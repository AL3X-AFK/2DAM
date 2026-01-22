package com.alenic.agendacontactos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alenic.agendacontactos.domain.Contact
import com.alenic.agendacontactos.repositories.ContactRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ContactViewModel(
    private val repository: ContactRepository
): ViewModel(){

    val contact = repository
        .getAllContacts()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            emptyList()
        )

    fun addContact(contact: Contact){
        viewModelScope.launch {
            repository.insertContact(contact)
        }
    }
}