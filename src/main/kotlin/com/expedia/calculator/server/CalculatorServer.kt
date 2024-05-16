package com.expedia.calculator.server

import com.expedia.calculator.service.CalculatorServiceImpl
import io.grpc.Server
import io.grpc.ServerBuilder
import java.util.concurrent.TimeUnit
import java.util.logging.Logger

class CalculatorServer() {
    val logger: Logger = Logger.getLogger("Calculator server")
    private val port = 50051
    private var server: Server = ServerBuilder.forPort(port)
        .addService(CalculatorServiceImpl())
        .build()

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val calculatorServer = CalculatorServer()
            calculatorServer.startServer()
            calculatorServer.blockUntilShutdown()
        }
    }


    fun startServer() {
        server = server.start();
        logger.info("Server started on port : $port");
    }

    fun stopServer() {
        server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
    }

    fun blockUntilShutdown() {
        server.awaitTermination()
    }
}