package br.com.boasaude.msassociados.application.handler

import br.com.boasaude.msassociados.application.dto.RegisterAssociateInHealthPlanDto
import br.com.boasaude.msassociados.domain.response.RegisterAssociateInHealthPlanResponse.*
import br.com.boasaude.msassociados.domain.usecase.RegisterAssociateInHealthPlanUseCase
import org.springframework.http.HttpStatus.*
import org.springframework.stereotype.Component
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.ServerResponse.status

@Component
class AssociateHandler(
    private val registerAssociateInHealthPlanUseCase: RegisterAssociateInHealthPlanUseCase
) {

    fun registerAssociateInHealthPlan(registerAssociateInHealthPlanDto: RegisterAssociateInHealthPlanDto): ServerResponse {
        val registerAssociateInHealthPlanResponse = this.registerAssociateInHealthPlanUseCase.execute(
            registerAssociateInHealthPlanDto.toAssociate(),
            registerAssociateInHealthPlanDto.toHealthPlan()
        )

        return when (registerAssociateInHealthPlanResponse) {
            Success -> status(CREATED).body(registerAssociateInHealthPlanResponse.message)
            InvalidName -> status(UNPROCESSABLE_ENTITY).body(registerAssociateInHealthPlanResponse.message)
            InvalidCPF -> status(UNPROCESSABLE_ENTITY).body(registerAssociateInHealthPlanResponse.message)
            InvalidEmail -> status(UNPROCESSABLE_ENTITY).body(registerAssociateInHealthPlanResponse.message)
            InvalidCNPJ -> status(UNPROCESSABLE_ENTITY).body(registerAssociateInHealthPlanResponse.message)
            else -> status(INTERNAL_SERVER_ERROR).body(registerAssociateInHealthPlanResponse.message)
        }
    }

}