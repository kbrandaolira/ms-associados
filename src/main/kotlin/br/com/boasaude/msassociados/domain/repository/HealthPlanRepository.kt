package br.com.boasaude.msassociados.domain.repository

import br.com.boasaude.msassociados.domain.model.HealthPlan

interface HealthPlanRepository {
    fun save(healthPlan: HealthPlan): Long?
    fun findLastHealthPlanByAssociate(associateId: Long): HealthPlan
}