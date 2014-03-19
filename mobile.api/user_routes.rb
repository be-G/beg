# user_routes.rb
require 'sinatra'
require 'pg'
require 'active_record'
require 'sinatra/activerecord'

class UserRoutes < Sinatra::Base

  ActiveRecord::Base.establish_connection(
      adapter: 'postgresql',
      host: 'localhost',
      username: 'postgres',
      database: 'beg',
      password: ''
  )

  class User < ActiveRecord::Base

  end

  get '/login' do

    res = User.find_by name: params["name"], password: params["password"]

    res.to_json


  end

  get '/createaccount' do

     User.create :name => params["name"], :password => params["password"], :state => params["state"], :mail => params["mail"], :description => params["description"]

     "{\"name\":\"#{params["name"]}\",\"mail\":\"#{params["mail"]}\"}"

  end

  get '/users' do

    res = User.find(:all)

    res.to_json

  end

  get '/rescuepassword'do

    params["mail"]

    'OK'

  end

  get'/updateposition' do

    params["mail"]
    params["longitude"]
    params["latitude"]

    'OK'

  end

  get '/updatestate' do

    params["mail"]

    'OK'

  end


end