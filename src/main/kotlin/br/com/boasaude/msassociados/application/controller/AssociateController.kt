package br.com.boasaude.msassociados.application.controller

import br.com.boasaude.msassociados.application.dto.RegisterAssociateInHealthPlanDto
import br.com.boasaude.msassociados.application.handler.AssociateHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.function.ServerResponse

@RestController("/associate")
class AssociateController(private val associateHandler: AssociateHandler) {

    @PostMapping
    fun registerAssociateInHealthPlan(@RequestBody dto: RegisterAssociateInHealthPlanDto): ServerResponse {
        return this.associateHandler.registerAssociateInHealthPlan(dto)
    }

}