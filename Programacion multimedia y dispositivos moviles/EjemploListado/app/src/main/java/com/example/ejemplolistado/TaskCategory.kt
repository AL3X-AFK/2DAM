package com.example.ejemplolistado

sealed class TaskCategory {
    object futbol : TaskCategory()
    object Tennis : TaskCategory()
    object Rugby : TaskCategory()
    object Other : TaskCategory()
}