require 'bundler/setup'
Bundler.require( :development)
autoload :MyModule, 'my_module.rb'

class hello
    puts "Hello, World!".red
    puts "Success!".green
    puts MyModule.greet

