package br.com.boasaude.msassociados.domain.response

sealed class RegisterAssociateInHealthPlanResponse(val message: String) {
    object Success : RegisterAssociateInHealthPlanResponse("Associado salvo com sucesso.")
    object InvalidName : RegisterAssociateInHealthPlanResponse("Nome inválido.")
    object InvalidBirthDate : RegisterAssociateInHealthPlanResponse("Data de nascimento inválida.")
    object InvalidCPF : RegisterAssociateInHealthPlanResponse("CPF inválido.")
    object InvalidEmail : RegisterAssociateInHealthPlanResponse("E-mail inválido.")
    object InvalidCNPJ : RegisterAssociateInHealthPlanResponse("CNPJ inválido.")
    object GenericError : RegisterAssociateInHealthPlanResponse("Ocorreu um erro inesperado ao tentar registrar o associado no plano de saúde.")
}
