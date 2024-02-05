import falcon
from app.middleware import CatchAllMiddleware
from app.middleware.context import ContextMiddleware

cache_region = "something"

# Define application
app = falcon.API(middleware=[
    CatchAllMiddleware(catch_all_route='/'),
    ContextMiddleware()
])

# Application routes
app.add_route('/', jsonrpc.JSONRPCResource(cache_region))