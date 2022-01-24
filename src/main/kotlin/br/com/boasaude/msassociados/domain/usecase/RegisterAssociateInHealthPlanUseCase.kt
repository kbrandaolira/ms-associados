package br.com.boasaude.msassociados.domain.usecase

import br.com.boasaude.msassociados.domain.model.HealthPlan
import br.com.boasaude.msassociados.domain.usecase.response.RegisterAssociateInHealthPlanResponse

class RegisterAssociateInHealthPlanUseCase : UseCase<HealthPlan, RegisterAssociateInHealthPlanResponse> {
    override fun execute(t: HealthPlan): RegisterAssociateInHealthPlanResponse {
        TODO("Not yet implemented")
    }
}