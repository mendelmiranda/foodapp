package br.com.mendel.foodapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FoodappApplication

fun main(args: Array<String>) {
	runApplication<FoodappApplication>(*args)
}
