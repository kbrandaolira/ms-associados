package br.com.boasaude.msassociados.infrastructure.entity

import br.com.boasaude.msassociados.domain.model.Associate
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
    var createdAt: LocalDateTime,
    var createdBy: Long,
    @Temporal(TemporalType.TIMESTAMP)
    var updatedAt: LocalDateTime? = null,
    var updatedBy: Long? = null,
){
    companion object {
        fun fromDomain(associate: Associate) = AssociateEntity(
           id = associate.id,
            name = associate.name,
            birthDate = associate.birthDate,
            cpf = associate.cpf,
            email = associate.email,
            createdAt = associate.createdAt,
            createdBy = associate.createdBy
        )
    }
}
