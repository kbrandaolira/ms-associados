package br.com.boasaude.msassociados.infrastructure.adapter

import br.com.boasaude.msassociados.domain.model.Associate
import br.com.boasaude.msassociados.domain.repository.AssociateRepository
import br.com.boasaude.msassociados.infrastructure.entity.AssociateEntity
import br.com.boasaude.msassociados.infrastructure.jpa.AssociateJpa
import org.springframework.stereotype.Repository

@Repository
class AssociateRepositoryAdapter(private val associateJpa: AssociateJpa) : AssociateRepository {
    override fun save(associate: Associate): Long? {
        return try {
            this.associateJpa.save(AssociateEntity.fromDomain(associate)).id
        } catch (e: Exception) {
            null
        }
    }

    override fun findAllOrderByIdDesc(): List<Associate> {
        var associates = mutableListOf<Associate>()
        this.associateJpa.findAllByOrderByIdAsc().forEach {
            associates.add(it.toDomain())
        }
        return associates;
    }

    override fun findIdByCpf(cpf: String): Long? {
        return this.associateJpa.findIdByCpf(cpf)
    }
}