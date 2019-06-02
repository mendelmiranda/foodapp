package br.com.mendel.foodapp.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Cliente")
data class Cliente(@Id val id: String?, val nome: String) {
}
