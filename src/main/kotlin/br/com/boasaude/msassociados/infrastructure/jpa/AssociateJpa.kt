package br.com.boasaude.msassociados.infrastructure.jpa

import br.com.boasaude.msassociados.infrastructure.entity.AssociateEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AssociateJpa : JpaRepository<AssociateEntity, Long> {
}