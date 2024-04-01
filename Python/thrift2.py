from thrift.protocol import TBinaryProtocol
from thrift.server import THttpServer

from tutorial import CalculatorHandler # assuming you defined this

handler = CalculatorHandler()
processor = Calculator.Processor(handler)
pfactory = TBinaryProtocol.TBinaryProtocolFactory()
server = THttpServer.THttpServer(
    processor,
    ('', 9090),
    pfactory
)

print('Starting the server...')
server.serve()
print('done.')