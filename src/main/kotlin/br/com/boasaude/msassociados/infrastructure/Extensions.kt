package br.com.boasaude.msassociados.infrastructure

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun String.toLocalDate(): LocalDate {
    return try {
        LocalDate.parse(this, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    } catch (ex: Exception) {
        LocalDate.now()
    }
}