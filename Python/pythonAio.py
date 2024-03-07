
from aiohttp import web
from .middlewares import cors

class main:
    def main(bind_host: str, bind_port: int) -> None:
        app =  App()
        ver = app.__version__
        web.run_app(app, host=bind_host, port=bind_port, handle_signals=True, print=None)

    def make_app() -> web.Application:
        app.add_routes([web.post("/", partial(handle, executor=executor))])
        return app