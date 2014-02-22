# user_routes.rb
require 'sinatra'
require 'pg'
require 'active_record'

ActiveRecord::Base.establish_connection(
    adapter: 'postgresql',
    host: 'localhost',
    database: 'beg',
    password: 'postgres',
    schema_search_path: 'beg'
)

class User < ActiveRecord::Base
end

class UserRoutes < Sinatra::Base

  get '/login' do

    params["name"]
    params["password"]



    'OK'

  end

  get '/createaccount' do

    @user = User.new(params);

    @user.save

  end

  get '/neighbors' do

    params["longitude"]
    params["latitude"]

    'Lista di utenti'

  end

  get '/rescuepassword'do

    params["mail"]

    'OK'

  end

  get'/refreshposition' do

    params["mail"]
    params["longitude"]
    params["latitude"]

    'OK'

  end


end