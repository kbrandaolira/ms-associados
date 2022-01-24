package br.com.boasaude.msassociados.domain.usecase

import br.com.boasaude.msassociados.domain.model.Associate
import br.com.boasaude.msassociados.domain.repository.AssociateRepository
import br.com.boasaude.msassociados.domain.usecase.response.RegisterAssociateResponse

class RegisterAssociateUseCase(private val associateRepository: AssociateRepository) :
    UseCase<Associate, RegisterAssociateResponse> {
    override fun execute(associate: Associate): RegisterAssociateResponse {
        if (associate.name.isEmpty()) {
            return RegisterAssociateResponse.InvalidName
        }

        if (associate.cpf.isEmpty()) {
            return RegisterAssociateResponse.InvalidCPF
        }

        if (associate.email.isEmpty()) {
            return RegisterAssociateResponse.InvalidEmail
        }

        this.associateRepository.save(associate)?.let {
            return RegisterAssociateResponse.Success
        } ?: return RegisterAssociateResponse.GenericError
    }
}
