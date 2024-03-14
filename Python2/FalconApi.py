import falcon
import Python2.Request as Request

app = falcon.API()
app.add_route('/my_route', Request.Request())

