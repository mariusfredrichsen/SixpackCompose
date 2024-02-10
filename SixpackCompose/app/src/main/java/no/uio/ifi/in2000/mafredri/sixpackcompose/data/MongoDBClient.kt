package no.uio.ifi.in2000.mafredri.sixpackcompose.data

import android.annotation.SuppressLint


object MongoDBClient {
    @SuppressLint("AuthLeak")
    private const val CONNECTION_STRING = "mongodb+srv://marius:po2XxJKx9NQC7P4U@discord.7b4in8d.mongodb.net/"

    fun getMongoClient(): MongoClient {
        return MongoClient
    }
}