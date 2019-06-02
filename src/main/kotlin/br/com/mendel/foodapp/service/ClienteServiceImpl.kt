package br.com.mendel.foodapp.service

import br.com.mendel.foodapp.model.Cliente
import br.com.mendel.foodapp.repository.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

@Service
class ClienteServiceImpl : IClienteService {

    @Autowired
    lateinit var clienteRepository: ClienteRepository

    override fun listaTodos(): Flux<Cliente> {
        val todos: Flux<Cliente> = this.clienteRepository.findAll()
        return todos
    }

    override fun novo(clienteMono: Cliente): Mono<*> =clienteRepository.save(clienteMono)
    override fun clientePorId(id: String): Mono<Cliente> = clienteRepository.findById(id)
    override fun atualizar(clienteMono: Cliente): Mono<*> =clienteRepository.save(clienteMono)
    override fun remover(id: String): Mono<Void> = clienteRepository.deleteById(id)

    override fun createCliente(cliente: Cliente) : Mono<Cliente> = clienteRepository.save(cliente)





}
