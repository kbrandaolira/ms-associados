package br.com.boasaude.msassociados.infrastructure

import java.time.LocalDate

fun String.toLocalDate(): LocalDate {
    return try {
        LocalDate.parse(this)
    } catch (ex: Exception) {
        LocalDate.now()
    }
}