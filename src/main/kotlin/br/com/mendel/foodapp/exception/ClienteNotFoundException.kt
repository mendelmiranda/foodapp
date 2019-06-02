package br.com.mendel.foodapp.exception

class ClienteNotFoundException : Exception {

    constructor(message: String) : super(message)

    companion object {
        fun create(id: String): ClienteNotFoundException {
            return ClienteNotFoundException("Cliente com o id {$id} não encontrado.")
        }
    }
}
