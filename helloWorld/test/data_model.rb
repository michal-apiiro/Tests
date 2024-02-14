# user.rb
require 'active_record'

class User < ActiveRecord::Base
end

# create_users.rb (migration)
class CreateUsers < ActiveRecord::Migration[6.0]
  def change
    create_table :users do |t|
      t.string :name
      t.string :email
      t.integer :age
      t.timestamps
    end
  end
end