package br.com.boasaude.msassociados.domain.usecase

interface UseCase<T,K> {
    fun execute(t:T): K
}