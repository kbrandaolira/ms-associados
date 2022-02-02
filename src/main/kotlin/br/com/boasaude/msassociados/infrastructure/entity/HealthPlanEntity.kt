package br.com.boasaude.msassociados.infrastructure.entity

import br.com.boasaude.msassociados.domain.model.HealthPlan
import br.com.boasaude.msassociados.domain.model.HealthPlanClassification
import br.com.boasaude.msassociados.domain.model.HealthPlanType
import org.springframework.data.jpa.repository.Temporal
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "healthPlan")
@Table(name = "health_plan", schema = "associados")
class HealthPlanEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Enumerated(EnumType.STRING)
    val type: HealthPlanType,
    val cnpj: String? = null,
    @Enumerated(EnumType.STRING)
    val classification: HealthPlanClassification,
    val dentalPlan: Boolean,
    val associateId: Long,
    @Temporal(TemporalType.TIMESTAMP)
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var createdBy: Long,
    @Temporal(TemporalType.TIMESTAMP)
    var updatedAt: LocalDateTime? = null,
    var updatedBy: Long? = null,
) {
    companion object {
        fun fromDomain(healthPlan: HealthPlan) = HealthPlanEntity(
            id = healthPlan.id,
            type = healthPlan.type,
            cnpj = healthPlan.cnpj,
            classification = healthPlan.classification,
            dentalPlan = healthPlan.dentalPlan,
            associateId = healthPlan.associateId!!,
            createdAt = healthPlan.createdAt,
            createdBy = healthPlan.createdBy,
            updatedAt = healthPlan.updatedAt,
            updatedBy = healthPlan.updatedBy
        )
    }

    fun toDomain() = HealthPlan(
        id = this.id,
        type = this.type,
        cnpj = this.cnpj,
        classification = this.classification,
        dentalPlan = this.dentalPlan,
        associateId = this.associateId,
        createdAt = this.createdAt,
        createdBy = this.createdBy,
        updatedAt = this.updatedAt,
        updatedBy = this.updatedBy
    )
}
