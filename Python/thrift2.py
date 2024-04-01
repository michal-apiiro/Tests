from thrift.protocol import TBinaryProtocol
from thrift.server import THttpServer
from tutorial import CalculatorHandler

handler = CalculatorHandler()
processor = Calculator.Processor(handler)
pfactory = TBinaryProtocol.TBinaryProtocolFactory()
server = THttpServer.THttpServer(
    processor,
    ('', 9090),
    pfactory
)
