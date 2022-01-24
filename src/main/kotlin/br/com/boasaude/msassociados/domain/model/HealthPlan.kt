package br.com.boasaude.msassociados.domain.model

data class HealthPlan(
    val id: Long,
    val type: HealthPlanType,
    val cnpj : String,
    val classification: HealthPlanClassification,
    val associateId : Long
)

enum class HealthPlanType {
    EMPRESARIAL, INDIVIDUAL
}

enum class HealthPlanClassification {
    APARTAMENTO, ENFERMARIA, VIP
}