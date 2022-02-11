package br.com.boasaude.msassociados.application.handler

import br.com.boasaude.msassociados.application.dto.AssociateDTO
import br.com.boasaude.msassociados.application.dto.RegisterAssociateInHealthPlanDto
import br.com.boasaude.msassociados.domain.repository.AssociateRepository
import br.com.boasaude.msassociados.domain.repository.HealthPlanRepository
import br.com.boasaude.msassociados.domain.response.RegisterAssociateInHealthPlanResponse.*
import br.com.boasaude.msassociados.domain.usecase.RegisterAssociateInHealthPlanUseCase
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class AssociateHandler(
    private val registerAssociateInHealthPlanUseCase: RegisterAssociateInHealthPlanUseCase,
    private val associateRepository: AssociateRepository,
    private val healthPlanRepository: HealthPlanRepository,
) {

    fun findAssociateIdByDocumentNumber(documentNumber: String): Long?{
        return this.associateRepository.findIdByCpf(documentNumber)
    }

    fun search(): List<AssociateDTO> {
        val dtos = mutableListOf<AssociateDTO>()
        this.associateRepository.findAllOrderByIdDesc().forEach { associate ->
            val healthPlan = this.healthPlanRepository.findLastHealthPlanByAssociate(associate.id!!)
            dtos.add(
                AssociateDTO(
                    id = associate.id,
                    name = associate.name,
                    typeOfHealthPlan = healthPlan.type.toString(),
                    classificationOfHealthPlan = healthPlan.classification.toString()
                )
            )
        }
        return dtos
    }

    fun registerAssociateInHealthPlan(registerAssociateInHealthPlanDto: RegisterAssociateInHealthPlanDto): ResponseEntity<String> {
        val registerAssociateInHealthPlanResponse = this.registerAssociateInHealthPlanUseCase.execute(
            registerAssociateInHealthPlanDto.toAssociate(),
            registerAssociateInHealthPlanDto.toHealthPlan()
        )

        return when (registerAssociateInHealthPlanResponse) {
            Success -> ResponseEntity(registerAssociateInHealthPlanResponse.message, CREATED)
            InvalidName -> ResponseEntity(registerAssociateInHealthPlanResponse.message, UNPROCESSABLE_ENTITY)
            InvalidBirthDate -> ResponseEntity(registerAssociateInHealthPlanResponse.message, UNPROCESSABLE_ENTITY)
            InvalidCPF -> ResponseEntity(registerAssociateInHealthPlanResponse.message, UNPROCESSABLE_ENTITY)
            InvalidEmail -> ResponseEntity(registerAssociateInHealthPlanResponse.message, UNPROCESSABLE_ENTITY)
            InvalidCNPJ -> ResponseEntity(registerAssociateInHealthPlanResponse.message, UNPROCESSABLE_ENTITY)
            else -> ResponseEntity(registerAssociateInHealthPlanResponse.message, INTERNAL_SERVER_ERROR)
        }
    }

}