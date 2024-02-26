import falcon

class Request:
    def on_get(self, req, resp):
        return 'get world'