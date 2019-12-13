# Sample-Thrift-App
-------------------

Just a sample playground project for [Apache Thrift](https://thrift.apache.org/) integrations.


## Features

Note: may change in future without any warning (this is a playground!)

* API defined using Thrift specification; language-specific interfaces are autogenerated.
* Served by Twitter [Finagle](https://twitter.github.io/finagle/) embedded RPC server.
  - working in [ThriftMux](https://twitter.github.io/finagle/guide/Protocols.html#mux) mode;
  - using [MethodPerEndpoint](https://twitter.github.io/scrooge/Finagle.html) Thrift-Finagle integration;
  - using Thrift framed transport (hence non-blocking);
  - using default Binary protocol for serialization.


## Components and languages

### Common API: [/api](/api)

* [/api/src/main/thrift](/api/src/main/thrift) – contains the API definition (taken from some public Thrift example).

The other projects will use it (both client and server ones) and generate the needed boilerplate code from it.

### Scala

Uses [sbt](https://www.scala-sbt.org/) to build. No manual steps are normally required, the APIs are built automatically using the configured sbt plugin.

#### Some common API code

* [/api/src/main/scala](/api/src/main/scala) – some (completely unnecessary for functioning) code to test out the API serialization aspects.

#### RPC server: [/server](/server)

Launches the Finagle-ThriftMux server at `127.0.0.1:8000`.

Build and run it using:

~~~sh
sbt server/run
~~~

(or `sbt '~server/run'` if you want auto-restarting it if source files are edited).

#### RPC client: [/client](/client)

Connects to the Finagle-ThriftMux server at `127.0.0.1:8000` and tries the available operations.

Build and run it using:

~~~sh
sbt client/run
~~~

(or `sbt '~client/run'` if you want auto-restarting it if source files are edited).

### Ruby

#### RPC client: [/client-rb](/client-rb)

Needs some manual actions (calling the Thrift compiler to build the API into the autogenerated access code) before running. See the [/client-rb/README.md](/client-rb/README.md) file for details.

Then, similarly to the Scala client implementation, connects to the RPC server at `127.0.0.1:8000` and tries the available operations.

After building (see [/client-rb/README.md](/client-rb/README.md)), run it using:

~~~sh
ruby client.rb
~~~

## Read more

### Thrift

* [Official Thrift interface description](https://thrift.apache.org/docs/idl);
* (suggested) [Thrift – The missing specification](https://erikvanoosten.github.io/thrift-missing-specification/).

### Finagle

*  [Finagle](https://twitter.github.io/finagle/);
  - [Usage guide](https://twitter.github.io/finagle/guide/Protocols.html).