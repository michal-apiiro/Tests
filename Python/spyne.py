from flask import Flask, request
from flask_restful import Api, Resource
from spyne.protocol.soap import Soap11
from spyne.server.flask import FlaskApplication
from spyne import ServiceBase, rpc, Unicode

app = Flask(__name__)
api = Api(app)

class MyService(ServiceBase):
    @rpc(Unicode, Unicode, _returns=Unicode)
    def some_method(self, param1, param2):
        # Perform SOAP service logic here
        result = f'Parameter 1: {param1}, Parameter 2: {param2}'
        return result

spyne_app = FlaskApplication(MyService, tns='example.soap', in_protocol=Soap11(validator='lxml'), out_protocol=Soap11())

# Add Spyne service resource to API
api.add_resource(spyne_app, '/soap')

if __name__ == '__main__':
    app.run(debug=True)
