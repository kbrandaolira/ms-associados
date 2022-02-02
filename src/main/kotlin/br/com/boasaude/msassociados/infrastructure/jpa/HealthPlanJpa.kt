package br.com.boasaude.msassociados.infrastructure.jpa

import br.com.boasaude.msassociados.infrastructure.entity.HealthPlanEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface HealthPlanJpa : JpaRepository<HealthPlanEntity, Long> {
    @Query("SELECT hp FROM health_plan hp WHERe hp.associate_id = :associateId LIMIT 1", nativeQuery = true)
    fun findTopByOrderByAssociateIdDesc(@Param("associateId") associateId: Long): HealthPlanEntity
}