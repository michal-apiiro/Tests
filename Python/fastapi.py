from fastapi import APIRouter, Depends

api_router = APIRouter(prefix="/prefix", dependencies=[Depends(authenticate)])

@api_router.get("/hey/group")
async def function(num: int = None):
   pass