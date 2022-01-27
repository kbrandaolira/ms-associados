package br.com.boasaude.msassociados.infrastructure.entity

import br.com.boasaude.msassociados.domain.model.HealthPlan
import br.com.boasaude.msassociados.domain.model.HealthPlanClassification
import br.com.boasaude.msassociados.domain.model.HealthPlanType
import org.springframework.data.jpa.repository.Temporal
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "healthPlan")
@Table(name = "health_plan", schema = "associados")
class HealthPlanEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Enumerated(EnumType.STRING)
    val type: HealthPlanType,
    val cnpj : String? = null,
    @Enumerated(EnumType.STRING)
    val classification: HealthPlanClassification,
    val associateId : Long,
    @Temporal(TemporalType.TIMESTAMP)
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var createdBy: Long,
    @Temporal(TemporalType.TIMESTAMP)
    var updatedAt: LocalDateTime? = null,
    var updatedBy: Long? = null,
){
    companion object {
        fun fromDomain(healthPlan: HealthPlan) = HealthPlanEntity(
            id = healthPlan.id,
            type = healthPlan.type,
            cnpj = healthPlan.cnpj,
            classification = healthPlan.classification,
            associateId = healthPlan.associateId!!,
            createdAt = healthPlan.createdAt,
            createdBy = healthPlan.createdBy,
            updatedAt = healthPlan.updatedAt,
            updatedBy = healthPlan.updatedBy
        )
    }
}
