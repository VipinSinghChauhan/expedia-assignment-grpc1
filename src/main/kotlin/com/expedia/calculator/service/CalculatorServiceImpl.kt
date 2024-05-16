package com.expedia.calculator.service

import com.expedia.calculator.client.CalculatorClient
import com.expedia.stubs.calculator.CalculatorServiceGrpc
import com.expedia.stubs.calculator.Request
import com.expedia.stubs.calculator.Response
import io.grpc.stub.StreamObserver

class CalculatorServiceImpl : CalculatorServiceGrpc.CalculatorServiceImplBase() {


    override fun add(request: Request?, responseObserver: StreamObserver<Response>?) {
        val response: Response = Response.newBuilder().setResult((request?.num1 ?: 0) + (request?.num2 ?: 0)).build()
        responseObserver?.onNext(response)
        responseObserver?.onCompleted()
    }

    override fun subtract(request: Request?, responseObserver: StreamObserver<Response>?) {
        val response: Response = Response.newBuilder().setResult((request?.num1 ?: 0) - (request?.num2 ?: 0)).build()
        responseObserver?.onNext(response)
        responseObserver?.onCompleted()
    }

    override fun multiply(request: Request?, responseObserver: StreamObserver<Response>?) {
        val response: Response = Response.newBuilder().setResult((request?.num1 ?: 0) * (request?.num2 ?: 0)).build()
        responseObserver?.onNext(response)
        responseObserver?.onCompleted()
    }

    override fun divide(request: Request?, responseObserver: StreamObserver<Response>?) {
        val response: Response = Response.newBuilder().setResult((request?.num1 ?: 0) / (request?.num2 ?: 1)).build()
        responseObserver?.onNext(response)
        responseObserver?.onCompleted()
    }
}