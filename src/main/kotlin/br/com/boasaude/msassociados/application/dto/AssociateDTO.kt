package br.com.boasaude.msassociados.application.dto

import br.com.boasaude.msassociados.domain.model.Associate

data class AssociateDTO(
    val id: Long?,
    val name: String,
    val typeOfHealthPlan: String,
    val classificationOfHealthPlan: String
) {
    fun fromAssociate(associate: Associate): AssociateDTO {
        return AssociateDTO(id = associate.id, name = associate.name, typeOfHealthPlan = "", classificationOfHealthPlan = "")
    }
}