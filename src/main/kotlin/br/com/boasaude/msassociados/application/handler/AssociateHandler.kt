package br.com.boasaude.msassociados.application.handler

import br.com.boasaude.msassociados.application.dto.RegisterAssociateInHealthPlanDto
import br.com.boasaude.msassociados.domain.usecase.RegisterAssociateInHealthPlanResponse.*
import br.com.boasaude.msassociados.domain.usecase.RegisterAssociateInHealthPlanUseCase

class AssociateHandler(
    private val registerAssociateInHealthPlanUseCase: RegisterAssociateInHealthPlanUseCase
) {

    fun registerAssociate(registerAssociateInHealthPlanDto: RegisterAssociateInHealthPlanDto) {
        when (this.registerAssociateInHealthPlanUseCase.execute(
            registerAssociateInHealthPlanDto.toAssociate(),
            registerAssociateInHealthPlanDto.toHealthPlan()
        )) {
            Success -> TODO("HTTP 201: Mensagem + Contador Prometheus")
            InvalidName -> TODO("HTTP 422: Mensagem")
            InvalidCPF -> TODO("HTTP 422: Mensagem")
            InvalidEmail -> TODO("HTTP 422: Mensagem")
            InvalidCNPJ -> TODO("HTTP 422: Mensagem")
            else -> TODO("HTTP 500: Mensagem")
        }
    }

}