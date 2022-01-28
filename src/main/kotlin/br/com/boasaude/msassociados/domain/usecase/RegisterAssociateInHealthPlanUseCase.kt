package br.com.boasaude.msassociados.domain.usecase

import br.com.boasaude.msassociados.domain.metric.MetricPublisher
import br.com.boasaude.msassociados.domain.model.Associate
import br.com.boasaude.msassociados.domain.model.HealthPlan
import br.com.boasaude.msassociados.domain.model.HealthPlanType.EMPRESARIAL
import br.com.boasaude.msassociados.domain.repository.AssociateRepository
import br.com.boasaude.msassociados.domain.repository.HealthPlanRepository
import br.com.boasaude.msassociados.domain.response.RegisterAssociateInHealthPlanResponse
import br.com.boasaude.msassociados.domain.response.RegisterAssociateInHealthPlanResponse.*
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class RegisterAssociateInHealthPlanUseCase(
    private val associateRepository: AssociateRepository,
    private val healthPlanRepository: HealthPlanRepository,
    private val metricPublisher: MetricPublisher
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

        this.associateRepository.save(associate)?.let { healthPlan.associateId = it } ?: return GenericError
        this.healthPlanRepository.save(healthPlan) ?: return GenericError
        this.metricPublisher.incrementAssociatesCounter(healthPlan.type, healthPlan.classification, healthPlan.dentalPlan)
        return Success
    }
}