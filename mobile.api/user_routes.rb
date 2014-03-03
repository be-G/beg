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

    p params["name"]
    p params["password"]
    p params["state"]
    p params["mail"]

    #TODO controllo dell'errore e restituiri il json con i dati dell'utente

    res = User.create :name => params["name"], :password => params["password"], :state => params["state"], :mail => params["mail"], :description => params["description"]

    p res

    res

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