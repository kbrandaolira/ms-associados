package br.com.boasaude.msassociados.infrastructure.entity

import org.springframework.data.jpa.repository.Temporal
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "associate")
@Table(name = "associate", schema = "associados")
class AssociateEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name : String,
    @Temporal(TemporalType.DATE)
    var birthDate : LocalDate,
    var cpf : String,
    var email: String,
    @Temporal(TemporalType.TIMESTAMP)
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var createdBy: Long,
    @Temporal(TemporalType.TIMESTAMP)
    var updatedAt: LocalDateTime,
    var updatedBy: Long,
)