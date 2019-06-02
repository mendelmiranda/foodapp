package br.com.mendel.foodapp.controller

import br.com.mendel.foodapp.model.Cliente
import br.com.mendel.foodapp.repository.ClienteRepository
import br.com.mendel.foodapp.service.IClienteService
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import javax.validation.Valid

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
class ClienteController {

    @Autowired lateinit var repositoty: IClienteService

    @Autowired lateinit var repo: ClienteRepository

    @GetMapping("/clientes", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTodos() = repositoty.listaTodos()

    @PostMapping("/clientes") fun novo(@RequestBody book: Cliente) = repositoty.novo(book)

    @GetMapping("/clientes/{clienteId}")
    fun clientePorId(@PathVariable clienteId : String) : Mono<Cliente> = repositoty.clientePorId(clienteId)

    @DeleteMapping("/clientes/{clienteId}")
    fun delete(@PathVariable clienteId: ObjectId): Mono<Void> =  repositoty.remover(clienteId.toHexString())

    @PutMapping("/clientes", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun atualiza(@Valid @RequestBody upCliente: Cliente) = repositoty.atualizar(upCliente)

    /*somenete para teste - retorna o status*/
    @PostMapping("/cria", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createEmployee(@Valid @RequestBody cliente: Cliente) = repositoty.createCliente(cliente)
            .map { newEmployee -> ResponseEntity.status(HttpStatus.CREATED).body(newEmployee)}



}
