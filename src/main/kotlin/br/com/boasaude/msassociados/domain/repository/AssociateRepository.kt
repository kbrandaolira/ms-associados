package br.com.boasaude.msassociados.domain.repository

import br.com.boasaude.msassociados.domain.model.Associate

interface AssociateRepository {
    fun save(associate: Associate): Long?
    fun findAllOrderByIdDesc(): List<Associate>
}