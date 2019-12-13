package com.myodov.sample_thrift_app

import com.myodov.sample_thrift_app.api._
import com.twitter.finagle.ThriftMux
import com.twitter.util.{Await, Future}


class ServerMPEImpl extends CalculatorService.MethodPerEndpoint {
  override def multiply(n1: Int, n2: Int): Future[Int] = Future {
    println(s"Multiply called with $n1, $n2")
    n1 * n2 + 5
  }
}


/** The primary launcher for the sample server. */
object ServerLauncher {

  def main(args: Array[String]): Unit = {
    val addressToListen = "127.0.0.1:8000"
    val serverMPEImpl = new ServerMPEImpl

    //    val server = Thrift.server.serveIface(addressToListen, serverMPEImpl)
    val server = ThriftMux.server
      .withLabel("Sample Calculator service")
      .serveIface(addressToListen, serverMPEImpl)
      .announce("CalcService")

    Await.ready(server)
    println("Server launched")
    while (true) {
      Thread.sleep(1000)
      // doing something else in other threads
    }
  }
}
