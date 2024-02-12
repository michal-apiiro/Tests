
#require 'faker'
require 'date'
require_relative 'my_module'
require 'bundler/setup'
Bundler.require(:default)


# Example usage
puts Date.today
puts MyModule.greet

# Generate and print a fake name and email address
puts "Fake Name: #{Faker::Name.name}"
puts "Fake Email: #{Faker::Internet.email}"

# Example JSON data
json_data = '{"name": "John", "age": 30, "city": "New York"}'
# Parsing JSON data
parsed_data = JSON.parse(json_data)
# Accessing parsed JSON data
puts "Name: #{parsed_data['name']}"
puts "Age: #{parsed_data['age']}"
puts "City: #{parsed_data['city']}"



# this command prompt: gem list --local --all
# can help you find all global gems -> if the gem is listed under "(default)"

# Global gems should not appear in the .gemspec file.
# Global gems, also known as system gems or global installations,
# refer to Ruby gems that are installed system-wide and are available for use in any Ruby project or
# script without the need for project-specific installation