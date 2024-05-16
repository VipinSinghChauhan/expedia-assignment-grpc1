package com.expedia.calculator

import com.expedia.calculator.client.CalculatorClient
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder

fun main() {
    val channel: ManagedChannel = ManagedChannelBuilder.forTarget("localhost:50051")
        .usePlaintext().build();
    val calculatorClient = CalculatorClient(channel)

    val num1 = 5
    val num2 = 10

    println("Add : " + calculatorClient.add(num1, num2).result)
    println("Subtract : " + calculatorClient.subtract(num1, num2).result)
    println("Multiply : " + calculatorClient.multiply(num1, num2).result)
    println("Divide : " + calculatorClient.divide(num1, num2).result)
}