from wsgiref.simple_server import make_server
from tg import expose, TGController, AppConfig

class MyController(TGController):

   @expose()
   def index(self):
      return 'Hello World TurboGears'
		 
config = AppConfig(minimal = True, root_controller = MyController())
application = config.make_wsgi_app()

print "Serving on port 8080..."
server = make_server('', 8080, application)
server.serve_forever()