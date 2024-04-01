from flask_restful import Api, Resource
from zeep import Client
from fastapi import FastAPI
import grpc
from ariadne.asgi import GraphQL
from .schema import schema


appgraph = GraphQL(schema, debug=True)
fastapp = FastAPI()

@fastapp.get("/")
async def root():
    return {"message": "Hello World"}

app = Flask(__name__)
api = Api(app)
api.add_resource(SOAPService, '/soap')
client = Client('http://example.com/soap/wsdl')
server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))