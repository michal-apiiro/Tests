from fastapi import FastAPI


def main():
    fastapp = FastAPI()

    @fastapp.get("/")
    def root():
        return {"message": "Hello World"}
