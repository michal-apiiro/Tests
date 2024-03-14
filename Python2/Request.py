import falcon

class Request:
    def on_get(self, req, resp):
        return 'get world'
    def on_post(self, req, resp):
        return 'get world'