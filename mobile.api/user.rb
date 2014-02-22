
require 'active_record'

ActiveRecord::Base.establish_connection(
    adapter: 'postgres',
    host: 'localhost',
    database: 'beg',
    password: 'matteobinda',
    schema_search_path: 'beg'
)

class User < ActiveRecord::Base
end

