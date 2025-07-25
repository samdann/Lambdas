package com.blackchain

import software.amazon.awscdk.App

import software.amazon.awscdk.Environment
import software.amazon.awscdk.StackProps

const val REGION = "eu-central-1"
fun main() {
    val app = App()

    MyStack(
        app, "sample-stack", StackProps.builder().env(
            Environment.builder().account("660416467304").region(REGION).build()).build()
    )
    app.synth()
}