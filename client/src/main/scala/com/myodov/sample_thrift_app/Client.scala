package com.myodov.sample_thrift_app

import com.myodov.sample_thrift_app.api._
import com.twitter.finagle.Thrift
import com.twitter.util.{Await, Future}


/** The primary launcher for the sample client. */
object ClientLauncher {
  lazy val addressToListen = "127.0.0.1:8000"
  lazy val client: CalculatorService.MethodPerEndpoint = Thrift.client.build[CalculatorService.MethodPerEndpoint](addressToListen)

  def main(args: Array[String]): Unit = {
    val result: Future[Int] = client.multiply(17, 19)
    result.onSuccess((i: Int) => {
      println(s"ReceivedSuccess $i; must be ${17 * 19 + 5}")
    }).onFailure((throwable: Throwable) => {
      println(s"ReceivedThrowable $throwable")
    })
    Await.ready(result)
  }
}
