package br.com.boasaude.msassociados.application.controller

import br.com.boasaude.msassociados.application.dto.RegisterAssociateInHealthPlanDto
import br.com.boasaude.msassociados.application.handler.AssociateHandler
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/associate")
class AssociateController(private val associateHandler: AssociateHandler) {

    @PostMapping
    fun registerAssociateInHealthPlan(@RequestBody dto: RegisterAssociateInHealthPlanDto): ResponseEntity<Any> {
        return this.associateHandler.registerAssociateInHealthPlan(dto)
    }

}