from ariadne.asgi import GraphQL
from .schema import schema


appgraph = GraphQL(schema, debug=True)