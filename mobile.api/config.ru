  # config.ru
require './user_routes'

require File.expand_path '../user_routes.rb', __FILE__

run UserRoutes