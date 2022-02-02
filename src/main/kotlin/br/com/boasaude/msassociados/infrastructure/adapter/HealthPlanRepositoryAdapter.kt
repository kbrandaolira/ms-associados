package br.com.boasaude.msassociados.infrastructure.adapter

import br.com.boasaude.msassociados.domain.model.Associate
import br.com.boasaude.msassociados.domain.model.HealthPlan
import br.com.boasaude.msassociados.domain.repository.HealthPlanRepository
import br.com.boasaude.msassociados.infrastructure.entity.AssociateEntity
import br.com.boasaude.msassociados.infrastructure.entity.HealthPlanEntity
import br.com.boasaude.msassociados.infrastructure.jpa.HealthPlanJpa
import org.springframework.stereotype.Repository

@Repository
class HealthPlanRepositoryAdapter (private val healthPlanJpa: HealthPlanJpa) : HealthPlanRepository {
    override fun save(healthPlan: HealthPlan): Long? {
        return try {
            this.healthPlanJpa.save(HealthPlanEntity.fromDomain(healthPlan)).id
        } catch (e: Exception) {
            null
        }
    }

    override fun findLastHealthPlanByAssociate(associateId: Long): HealthPlan {
        return this.healthPlanJpa.findTopByOrderByAssociateIdDesc(associateId).toDomain()
    }
}