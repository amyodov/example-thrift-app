package com.myodov.sample_thrift_app

import java.io.ByteArrayOutputStream

import com.myodov.sample_thrift_app.api._
import org.apache.thrift.protocol.{TBinaryProtocol, TCompactProtocol, TJSONProtocol, TSimpleJSONProtocol}
import org.apache.thrift.transport.TIOStreamTransport


/** The primary launcher for API samples and tests. */
object APISamplesLauncher {

  def main(args: Array[String]): Unit = {

    val spellbook: Set[Spell] = Set(Spell.Thunderbolt, Spell.Fireball)

    val mage = Hero(
      name = "Afiskon", hp = 25L, xp = 1024L,
      ClassSpecificInfo.Mage(MageInfo(spellbook, mana = 5L))
    )

    {
      val out = new ByteArrayOutputStream()
      mage.write(new TJSONProtocol(new TIOStreamTransport(out)))
      println(out.toString)
    }
    {
      val out = new ByteArrayOutputStream()
      mage.write(new TSimpleJSONProtocol(new TIOStreamTransport(out)))
      println(out.toString)
    }
    {
      val out = new ByteArrayOutputStream()
      mage.write(new TBinaryProtocol(new TIOStreamTransport(out)))
      println(out.toString)
    }
    {
      val out = new ByteArrayOutputStream()
      mage.write(new TCompactProtocol(new TIOStreamTransport(out)))
      println(out.toString)
    }
  }
}
