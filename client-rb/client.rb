#!/usr/bin/ruby

$LOAD_PATH << './gen-rb'
require 'calculator_service'

begin
  port = ARGV[0] || 8000

  transport = Thrift::FramedTransport.new(Thrift::Socket.new('127.0.0.1', port))
  # transport = Thrift::BufferedTransport.new(Thrift::Socket.new('127.0.0.1', port))

  protocol = Thrift::BinaryProtocol.new(transport)
  # protocol = Thrift::JsonProtocol.new(transport)
  # protocol = Thrift::CompactProtocol.new(transport)

  client = CalculatorService::Client.new(protocol)

  begin
    transport.open()
    result = client.multiply(17, 19)
    print "Result %d; must be %d\n" % [result, 17 * 19 + 5]
    transport.close()
  ensure
  end

end