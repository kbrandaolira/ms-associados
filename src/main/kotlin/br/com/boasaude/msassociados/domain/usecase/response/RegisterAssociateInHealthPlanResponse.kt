package br.com.boasaude.msassociados.domain.usecase.response

sealed class RegisterAssociateInHealthPlanResponse(val message: String) {
    object Success : RegisterAssociateInHealthPlanResponse("Associado foi registrado no plano de saúde com sucesso.")
    object InvalidCNPJ : RegisterAssociateInHealthPlanResponse("CNPJ inválido.")
    object GenericError : RegisterAssociateInHealthPlanResponse("Ocorreu um erro inesperado ao tentar registrar o associado no plano de saúde.")
}
