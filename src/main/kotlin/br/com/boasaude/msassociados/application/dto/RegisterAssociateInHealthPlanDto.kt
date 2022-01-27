package br.com.boasaude.msassociados.application.dto

import br.com.boasaude.msassociados.domain.model.Associate
import br.com.boasaude.msassociados.domain.model.HealthPlan
import br.com.boasaude.msassociados.domain.model.HealthPlanClassification
import br.com.boasaude.msassociados.domain.model.HealthPlanType
import java.time.LocalDate
import java.time.LocalDateTime

data class RegisterAssociateInHealthPlanDto(
    val name: String,
    val birthDate: LocalDate,
    val cpf: String,
    val email: String,
    val typeOfHealthPlan: String,
    val companyCnpj: String? = null,
    val classificationOfHealthPlan: String,
    val dentalPlan: Boolean,
    val userId: Long
) {
    fun toAssociate(): Associate {
        return Associate(name = this.name, birthDate = this.birthDate, cpf = this.cpf, email = this.email, createdAt = LocalDateTime.now(), createdBy = userId)
    }

    fun toHealthPlan(): HealthPlan {
        return HealthPlan(
            type = HealthPlanType.EMPRESARIAL,
            cnpj = "123",
            classification = HealthPlanClassification.APARTAMENTO,
            dentalPlan = true,
            createdAt = LocalDateTime.now(),
            createdBy = userId
        )
    }
}