package br.com.mendel.foodapp.service

import br.com.mendel.foodapp.model.Cliente
import org.springframework.http.ResponseEntity
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface IClienteService {
    fun listaTodos(): Flux<Cliente>
    fun novo(clienteMono: Cliente) : Mono<*>
    fun atualizar(clienteMono: Cliente) : Mono<*>
    fun clientePorId(id: String) : Mono<Cliente>
    open fun remover(id: String): Mono<Void>


    fun createCliente(cliente: Cliente) : Mono<Cliente>

}
