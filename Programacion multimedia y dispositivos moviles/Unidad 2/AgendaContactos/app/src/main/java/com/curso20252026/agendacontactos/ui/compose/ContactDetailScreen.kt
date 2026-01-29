package com.curso20252026.agendacontactos.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.curso20252026.agendacontactos.R
import com.curso20252026.agendacontactos.domain.Contact
import com.curso20252026.agendacontactos.ui.ContactDetailViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactDetailScreen(
    viewModel: ContactDetailViewModel,
    onBack: () -> Unit,
    onDeleted: () -> Unit
) {
    val contact by viewModel.contact.collectAsState()
    var showEditSheet by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.title_contact_detail)) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { showEditSheet = contact != null },
                        enabled = contact != null
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = stringResource(R.string.action_edit_contact)
                        )
                    }
                    IconButton(
                        onClick = { viewModel.deleteContact(onDeleted) },
                        enabled = contact != null
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = stringResource(R.string.action_delete_contact)
                        )
                    }
                }
            )
        }
    ) { padding ->
        ContactDetailContent(
            contact = contact,
            onAddTask = {title -> viewModel.addTask(title)} ,
            onToggleTask = {id, completado -> viewModel.toggleTask(id, completado)},
            onDeleteTask = {id -> viewModel.deleteTask(id)},
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        )
    }

    if (showEditSheet && contact != null) {
        AddContactBottomSheet(
            initialName = contact!!.name,
            initialPhone = contact!!.phone,
            initialAddress = contact!!.address,
            onConfirm = { name, phone, address ->
                viewModel.updateContact(name, phone, address)
                showEditSheet = false
            },
            onDismiss = { showEditSheet = false }
        )
    }
}

@Composable
private fun ContactDetailContent(
    contact: Contact?,
    onAddTask: (String) -> Unit,
    onToggleTask: (Int, Boolean) -> Unit,
    onDeleteTask: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var newTaskTitle by rememberSaveable { mutableStateOf("") }

    LazyColumn (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (contact == null) {
            item { Text(stringResource(R.string.message_contact_not_found)) }
            return@LazyColumn
        }

        // 1. FICHA DEL CONTACTO
        item {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = contact.name, style = MaterialTheme.typography.headlineSmall)
                    Text(text = contact.phone, style = MaterialTheme.typography.bodyLarge)
                    if(contact.address.isNotBlank()){
                        Text(text = contact.address, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }

        // TAREAS
        item{
            Text(text = "Tareas Asociadas", style=MaterialTheme.typography.titleMedium)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                OutlinedTextField(
                    value=newTaskTitle,
                    onValueChange = { newTaskTitle = it },
                    label = { Text("¿Cual es la tarea?")},
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
            }
            Spacer(Modifier.width(8.dp))
            Button(onClick = {
                if(newTaskTitle.isNotBlank()){
                    onAddTask(newTaskTitle)
                    newTaskTitle = ""
                }
            }){
                Icon(Icons.Default.Add, contentDescription = null)
            }
        }

        //Listado Tareas
        items(contact.tasks) { task ->
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp), // Un poco de margen entre tarjetas
                shape = MaterialTheme.shapes.small,
                tonalElevation = 2.dp
            ) {
                Row(
                    modifier = Modifier.padding(8.dp), // Más espacio interno para el click
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // El parámetro correcto es 'onCheckedChange', no 'onChange'
                    Checkbox(
                        checked = task.isDone,
                        onCheckedChange = { onToggleTask(task.id, it) }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = task.title,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    // Boton para eliminar la tarea
                    IconButton(onClick = {onDeleteTask(task.id)}){
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Eliminar tarea",
                            tint = MaterialTheme.colorScheme.error
                        )
                    }
                }
            }
        }
    }
}
