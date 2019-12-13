# Running sample Ruby client

## Dependencies

1. Install needed versions of **rbenv**, **ruby**, **bundler**.
2. Run `bundle install` in this directory to install the Ruby dependencies.
3. Install **Thrift** compiler for your platform
  - macOS: `brew install thrift`

## Building

Compile the API definitions to Ruby code:
~~~sh
thrift -r --gen rb ../api/src/main/thrift/api.thrift
~~~
