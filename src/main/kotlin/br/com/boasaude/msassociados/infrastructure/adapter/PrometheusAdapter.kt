package br.com.boasaude.msassociados.infrastructure.adapter

import br.com.boasaude.msassociados.domain.metric.MetricPublisher
import br.com.boasaude.msassociados.domain.model.HealthPlanClassification
import br.com.boasaude.msassociados.domain.model.HealthPlanType
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.stereotype.Component

@Component
class PrometheusAdapter(
    private val registry: MeterRegistry
) : MetricPublisher {
    override fun incrementAssociatesCounter(healthPlanType: HealthPlanType, healthPlanClassification: HealthPlanClassification, dentalPlan: Boolean){
        val metricName = "associates_counter"
        val tags = this.convertLabelsToTags(mutableMapOf("healthPlanType" to healthPlanType, "healthPlanClassification" to healthPlanClassification, "dentalPlan" to dentalPlan))
        registry.counter(metricName, *tags.toTypedArray()).let { counter -> counter.increment() }
    }

    private fun convertLabelsToTags(labels: MutableMap<String, Any>): List<String> {
        val result = mutableListOf<String>()
        labels.forEach {
            result.add(it.key)
            result.add(it.value.toString())
        }
        return result
    }
}