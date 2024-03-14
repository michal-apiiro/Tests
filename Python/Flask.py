from flask import Flask, request
from flask_restful import Api, Resource
from zeep import Client

app = Flask(__name__)
api = Api(app)

class SOAPService(Resource):
    def post(self):
        # Parse incoming JSON request
        data = request.get_json()
        # Extract parameters from request
        param1 = data.get('param1')
        param2 = data.get('param2')

        # Call the SOAP service
        client = Client('http://example.com/soap/wsdl')
        response = client.service.some_method(param1, param2)
        
        # Return SOAP service response
        return {'result': response}

# Add SOAP service resource to API
api.add_resource(SOAPService, '/soap')

if __name__ == '__main__':
    app.run(debug=True)
