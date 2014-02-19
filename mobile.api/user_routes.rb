# user_routes.rb
require 'sinatra'

class UserRoutes < Sinatra::Base

  get '/login' do

    params["name"]
    params["password"]

    'OK'

  end

  get '/createaccount' do

    params["name"]
    params["password"]
    params["email"]

    'OK'

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