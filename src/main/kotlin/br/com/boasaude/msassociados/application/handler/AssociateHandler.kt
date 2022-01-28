package br.com.boasaude.msassociados.application.handler

import br.com.boasaude.msassociados.application.dto.RegisterAssociateInHealthPlanDto
import br.com.boasaude.msassociados.domain.response.RegisterAssociateInHealthPlanResponse.*
import br.com.boasaude.msassociados.domain.usecase.RegisterAssociateInHealthPlanUseCase
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class AssociateHandler(
    private val registerAssociateInHealthPlanUseCase: RegisterAssociateInHealthPlanUseCase
) {

    fun registerAssociateInHealthPlan(registerAssociateInHealthPlanDto: RegisterAssociateInHealthPlanDto): ResponseEntity<Any> {
        val registerAssociateInHealthPlanResponse = this.registerAssociateInHealthPlanUseCase.execute(
            registerAssociateInHealthPlanDto.toAssociate(),
            registerAssociateInHealthPlanDto.toHealthPlan()
        )

        return when (registerAssociateInHealthPlanResponse) {
            Success -> ResponseEntity(registerAssociateInHealthPlanResponse.message, CREATED)
            InvalidName -> ResponseEntity(registerAssociateInHealthPlanResponse.message, UNPROCESSABLE_ENTITY)
            InvalidCPF -> ResponseEntity(registerAssociateInHealthPlanResponse.message, UNPROCESSABLE_ENTITY)
            InvalidEmail -> ResponseEntity(registerAssociateInHealthPlanResponse.message, UNPROCESSABLE_ENTITY)
            InvalidCNPJ -> ResponseEntity(registerAssociateInHealthPlanResponse.message, UNPROCESSABLE_ENTITY)
            else -> ResponseEntity(registerAssociateInHealthPlanResponse.message, INTERNAL_SERVER_ERROR)
        }
    }

}