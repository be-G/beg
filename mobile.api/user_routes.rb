# user_routes.rb
require 'sinatra'

class UserRoutes < Sinatra::Base

  get '/login' do

    params["name"]
    params["password"]

  end
end