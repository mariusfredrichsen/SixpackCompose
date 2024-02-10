package no.uio.ifi.in2000.mafredri.sixpackcompose.data

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson


object ApiClient {
    val client = HttpClient() {
        install(ContentNegotiation) {
            gson()
        }
    }
}