package br.com.boasaude.msassociados.application.dto

import br.com.boasaude.msassociados.domain.model.Associate
import br.com.boasaude.msassociados.domain.model.HealthPlan
import br.com.boasaude.msassociados.domain.model.HealthPlanClassification
import br.com.boasaude.msassociados.domain.model.HealthPlanType
import br.com.boasaude.msassociados.infrastructure.toLocalDate
import java.time.LocalDateTime

data class RegisterAssociateInHealthPlanDto(
    val name: String,
    val birthDate: String,
    val cpf: String,
    val email: String,
    val typeOfHealthPlan: String,
    val companyCnpj: String? = null,
    val classificationOfHealthPlan: String,
    val dentalPlan: Boolean,
    val userId: Long
) {
    fun toAssociate(): Associate {
        return Associate(name = this.name, birthDate = this.birthDate.toLocalDate(), cpf = this.cpf, email = this.email, createdAt = LocalDateTime.now(), createdBy = userId)
    }

    fun toHealthPlan(): HealthPlan {
        return HealthPlan(
            type = HealthPlanType.valueOf(this.typeOfHealthPlan),
            cnpj = this.companyCnpj,
            classification = HealthPlanClassification.valueOf(this.classificationOfHealthPlan),
            dentalPlan = this.dentalPlan,
            createdAt = LocalDateTime.now(),
            createdBy = this.userId
        )
    }
}