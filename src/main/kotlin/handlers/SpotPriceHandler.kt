package com.blackchain.handlers

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import kotlinx.serialization.Serializable

@Serializable
data class SpotPriceRequest(val token: String)

@Serializable
data class SpotPriceResponse(val token: String)

class SpotPriceHandler : RequestHandler<String, String>{

    override fun handleRequest(input: String?, context: Context?): String? {
        TODO("Not yet implemented")
    }
}