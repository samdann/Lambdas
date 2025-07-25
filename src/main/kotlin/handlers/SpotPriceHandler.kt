package com.blackchain.handlers

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class SpotPriceHandler : RequestHandler<String, String> {

    private val json = Json {}
    override fun handleRequest(input: String, context: Context): String {
        val logger = context.logger
        val message = input
        logger.log("EVENT: parse message : $message")
        return json.encodeToString("Echoing $message")
    }
}