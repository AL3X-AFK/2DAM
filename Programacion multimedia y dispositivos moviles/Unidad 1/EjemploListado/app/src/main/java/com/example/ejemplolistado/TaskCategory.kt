package com.example.ejemplolistado

sealed class TaskCategory {
    object Futbol : TaskCategory()
    object Tennis : TaskCategory()
    object Rugby : TaskCategory()
    object Other : TaskCategory()
}