package br.com.boasaude.msassociados.domain.model

data class HealthPlan(
    var id: Long? = null,
    val type: HealthPlanType,
    var cnpj: String? = null,
    val classification: HealthPlanClassification,
    val dentalPlan: Boolean,
    var associateId: Long? = null
)

enum class HealthPlanType {
    EMPRESARIAL, INDIVIDUAL
}

enum class HealthPlanClassification {
    APARTAMENTO, ENFERMARIA, VIP
}