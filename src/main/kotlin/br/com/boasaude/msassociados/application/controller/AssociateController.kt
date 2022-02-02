package br.com.boasaude.msassociados.application.controller

import br.com.boasaude.msassociados.application.dto.RegisterAssociateInHealthPlanDto
import br.com.boasaude.msassociados.application.handler.AssociateHandler
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/associate")
class AssociateController(private val associateHandler: AssociateHandler) {

    private val logger: Logger = LoggerFactory.getLogger(AssociateController::class.java)

    @PostMapping
    fun registerAssociateInHealthPlan(@RequestBody dto: RegisterAssociateInHealthPlanDto): ResponseEntity<String> {
        logger.info("Registering associate in health plan with parameters $dto")
        return this.associateHandler.registerAssociateInHealthPlan(dto)
    }

}