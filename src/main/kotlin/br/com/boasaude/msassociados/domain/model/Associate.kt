package br.com.boasaude.msassociados.domain.model

import java.time.LocalDate
import java.time.LocalDateTime

data class Associate (
    var id : Long? = null,
    val name : String,
    val birthDate : LocalDate,
    val cpf : String,
    val email: String,
    val createdAt: LocalDateTime,
    val createdBy: Long,
    var updatedAt: LocalDateTime? = null,
    var updatedBy: Long? = null,
)