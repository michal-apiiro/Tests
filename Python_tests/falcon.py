import falcon
from app.middleware import CatchAllMiddleware
from app.middleware.context import ContextMiddleware

cache_region = "something"

def main():
# Define application
    app = falcon.API(middleware=[
        CatchAllMiddleware(catch_all_route='/'),
        ContextMiddleware()
    ])

    # Application routes
    app.add_route('/', jsonrpc.JSORPCResource(cache_region))

class JSONRPCResource(BaseResource):
    def on_post(self, req, resp):
        return "Siu"