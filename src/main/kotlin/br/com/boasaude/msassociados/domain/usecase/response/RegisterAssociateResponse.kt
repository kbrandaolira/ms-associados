package br.com.boasaude.msassociados.domain.usecase.response

sealed class RegisterAssociateResponse(val message: String) {
    object Success : RegisterAssociateResponse("Associado salvo com sucesso.")
    object InvalidName : RegisterAssociateResponse("Nome inválido.")
    object InvalidCPF : RegisterAssociateResponse("CPF inválido.")
    object InvalidEmail : RegisterAssociateResponse("E-mail inválido.")
    object InvalidBirthdate : RegisterAssociateResponse("Data de nascimento inválida.")
    object GenericError : RegisterAssociateResponse("Ocorreu um erro inesperado ao tentar salvar o associado.")
}
