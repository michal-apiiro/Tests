from fastapi import FastAPI


fastapp = FastAPI()

@fastapp.get("/")
def root():
    return {"message": "Hello World"}
