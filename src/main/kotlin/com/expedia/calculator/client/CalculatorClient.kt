package com.expedia.calculator.client

import com.expedia.stubs.calculator.CalculatorServiceGrpc
import com.expedia.stubs.calculator.Request
import com.expedia.stubs.calculator.Response
import io.grpc.Channel

class CalculatorClient(private val channel: Channel) {
    private val calculatorServiceBlockingStub: CalculatorServiceGrpc.CalculatorServiceBlockingStub =
        CalculatorServiceGrpc.newBlockingStub(channel)

    fun add(num1: Int, num2: Int): Response {
        val request: Request = Request.newBuilder()
            .setNum1(num1)
            .setNum2(num2).build();
        return calculatorServiceBlockingStub.add(request)
    }

    fun subtract(num1: Int, num2: Int): Response {
        val request: Request = Request.newBuilder()
            .setNum1(num1)
            .setNum2(num2).build();
        return calculatorServiceBlockingStub.subtract(request)
    }

    fun multiply(num1: Int, num2: Int): Response {
        val request: Request = Request.newBuilder()
            .setNum1(num1)
            .setNum2(num2).build();
        return calculatorServiceBlockingStub.multiply(request)
    }

    fun divide(num1: Int, num2: Int): Response {
        val request: Request = Request.newBuilder()
            .setNum1(num1)
            .setNum2(num2).build();
        return calculatorServiceBlockingStub.divide(request)
    }

}