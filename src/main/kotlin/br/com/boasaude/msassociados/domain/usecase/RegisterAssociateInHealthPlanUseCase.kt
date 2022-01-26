package br.com.boasaude.msassociados.domain.usecase

import br.com.boasaude.msassociados.domain.model.Associate
import br.com.boasaude.msassociados.domain.model.HealthPlan
import br.com.boasaude.msassociados.domain.model.HealthPlanType.EMPRESARIAL
import br.com.boasaude.msassociados.domain.repository.AssociateRepository
import br.com.boasaude.msassociados.domain.repository.HealthPlanRepository
import br.com.boasaude.msassociados.domain.usecase.RegisterAssociateInHealthPlanResponse.*
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class RegisterAssociateInHealthPlanUseCase(
    private val associateRepository: AssociateRepository,
    private val healthPlanRepository: HealthPlanRepository
) {
    fun execute(associate: Associate, healthPlan: HealthPlan): RegisterAssociateInHealthPlanResponse {
        if (associate.name.isEmpty()) {
            return InvalidName
        }
        if (associate.cpf.isEmpty()) {
            return InvalidCPF
        }
        if (associate.email.isEmpty()) {
            return InvalidEmail
        }
        if (healthPlan.type == EMPRESARIAL && healthPlan.cnpj.isNullOrEmpty()) {
            return InvalidCNPJ
        }

        this.associateRepository.save(associate) ?: return GenericError
        this.healthPlanRepository.save(healthPlan) ?: return GenericError
        return Success
    }
}