package br.com.boasaude.msassociados.domain.model

import java.time.LocalDateTime

data class HealthPlan(
    var id: Long? = null,
    val type: HealthPlanType,
    var cnpj: String? = null,
    val classification: HealthPlanClassification,
    val dentalPlan: Boolean,
    var associateId: Long? = null,
    val createdAt: LocalDateTime,
    val createdBy: Long,
    var updatedAt: LocalDateTime? = null,
    var updatedBy: Long? = null,
)

enum class HealthPlanType {
    EMPRESARIAL, INDIVIDUAL
}

enum class HealthPlanClassification {
    APARTAMENTO, ENFERMARIA, VIP
}