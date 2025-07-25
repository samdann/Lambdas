package com.blackchain

import software.amazon.awscdk.Duration
import software.amazon.awscdk.Stack
import software.amazon.awscdk.StackProps
import software.amazon.awscdk.services.lambda.Code
import software.amazon.awscdk.services.lambda.Function
import software.amazon.awscdk.services.lambda.Runtime
import software.constructs.Construct

class MyStack(scope: Construct, id: String, props: StackProps) : Stack(scope, id) {
    init {
        Function.Builder.create(this, "sample-handler")
            .code(Code.fromAsset("../Lambdas/build/libs/Lambdas-1.0-SNAPSHOT.jar"))
            .handler("com.blackchain.handlers.SpotPriceHandler::handleRequest")
            .timeout(Duration.seconds(5))
            .runtime(Runtime.JAVA_17)
            .build()

    }
}