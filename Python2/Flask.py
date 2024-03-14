import logging
import requests
from admin_portal import auth


class Class(Resource):

    @auth.requires_auth
    def get(self):
        try:
            is_authorized = False

        except Exception as e:
            pass