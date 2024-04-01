from ariadne.asgi import GraphQL
from .schema import schema

def main():
    appgraph = GraphQL(schema, debug=True)