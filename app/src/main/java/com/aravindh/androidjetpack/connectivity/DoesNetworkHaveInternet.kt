package com.codingwithmitch.food2forkcompose.interactors.app

import com.aravindh.androidjetpack.utils.Logger
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket


/**
 * Send a ping to googles primary DNS.
 * If successful, that means we have internet.
 */
object DoesNetworkHaveInternet {

    // Make sure to execute this on a background thread.
    fun execute(): Boolean {
        return try {
            Logger.d("PINGING google.")
            val socket = Socket()
            socket.connect(InetSocketAddress("8.8.8.8", 53), 1500)
            socket.close()
            Logger.d("PING success.")
            true
        } catch (e: IOException) {
            Logger.d("No internet connection. $e")
            false
        }
    }
}