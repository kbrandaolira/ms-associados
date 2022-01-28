package br.com.boasaude.msassociados.domain.metric

import br.com.boasaude.msassociados.domain.model.HealthPlanClassification
import br.com.boasaude.msassociados.domain.model.HealthPlanType

interface MetricPublisher {
    fun incrementAssociatesCounter(healthPlanType: HealthPlanType, healthPlanClassification: HealthPlanClassification, dentalPlan: Boolean)
}