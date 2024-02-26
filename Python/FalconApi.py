import falcon
import my_method

app = falcon.API()
app.add_route('/my_route', my_method.Request())

