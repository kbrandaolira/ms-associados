package br.com.boasaude.msassociados.infrastructure.jpa

import br.com.boasaude.msassociados.infrastructure.entity.HealthPlanEntity
import org.springframework.data.jpa.repository.JpaRepository

interface HealthPlanJpa: JpaRepository<HealthPlanEntity, Long> {
}