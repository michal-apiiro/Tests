require 'bundler/setup'
Bundler.require( :development)
autoload :MyModule, 'my_module.rb'

class hello
    def hello_
        puts "Hello, World!".red
        puts "Success!".green
        puts MyModule.greet
    end

