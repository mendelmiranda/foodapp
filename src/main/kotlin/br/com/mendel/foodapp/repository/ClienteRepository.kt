package br.com.mendel.foodapp.repository

import br.com.mendel.foodapp.model.Cliente
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface ClienteRepository: ReactiveMongoRepository<Cliente,String?> {
    fun findByNome( nome: String)
}
