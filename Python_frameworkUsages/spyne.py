from spyne.protocol.soap import Soap11
from spyne.server.flask import FlaskApplication
from spyne import ServiceBase, rpc, Unicode

def main():
    spyne_app = FlaskApplication(MyService, tns='example.soap', in_protocol=Soap11(validator='lxml'), out_protocol=Soap11())
    api.add_resource(spyne_app, '/soap')
