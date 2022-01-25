package br.com.boasaude.msassociados.domain.model

import java.time.LocalDate

data class Associate (
    var id : Long? = null,
    val name : String,
    val birthDate : LocalDate,
    val cpf : String,
    val email: String,
)