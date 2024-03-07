
from aiohttp import web
from .middlewares import cors


def main(bind_host: str, bind_port: int) -> None:
    logging.basicConfig(level=logging.INFO)
    app = make_app()
    ver = black.__version__
    black.out(f"blackd version {ver} listening on {bind_host} port {bind_port}")
    web.run_app(app, host=bind_host, port=bind_port, handle_signals=True, print=None)

def make_app() -> web.Application:
    app = web.Application(
        middlewares=[cors(allow_headers=(*BLACK_HEADERS, "Content-Type"))]
    )
    executor = ProcessPoolExecutor()
    app.add_routes([web.post("/", partial(handle, executor=executor))])
    return app