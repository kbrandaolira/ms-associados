package br.com.boasaude.msassociados.infrastructure.jpa

import br.com.boasaude.msassociados.infrastructure.entity.AssociateEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface AssociateJpa : JpaRepository<AssociateEntity, Long> {

    fun findAllByOrderByIdAsc(): List<AssociateEntity>
    @Query(value = "SELECT a.id FROM associate a WHERE a.cpf = :cpf LIMIT 1", nativeQuery = true)
    fun findIdByCpf(@Param("cpf") cpf: String): Long?
}