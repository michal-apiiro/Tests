import requests
from requests.auth import HTTPBasicAuth
from okta.client import Client as OktaClient


def get_okta_user_list(_env_type):
    secrets = get_secret("dremio-utils")
    okta_url = okta_urls[_env_type]
    okta_config = {'orgUrl': okta_url, 'token': secrets['dremio_okta_api_key']}
    okta_client = OktaClient(okta_config)
    return get_okta_users(okta_client)

