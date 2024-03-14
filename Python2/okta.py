import requests
from requests.auth import HTTPBasicAuth
from okta.client import Client as OktaClient
from Python2.okta import UsersClient

def get_okta_user_list(_env_type):
    secrets = get_secret("dremio-utils")
    okta_url = okta_urls[_env_type]
    okta_config = {'orgUrl': okta_url, 'token': secrets['dremio_okta_api_key']}
    okta_client = OktaClient(okta_config)
    return get_okta_users(okta_client)



# Initialize the UsersClient with your Okta domain and API token
users_client = UsersClient("https://{yourOktaDomain}", "{yourApiToken}")

# Retrieve the user by username or user ID
user = users_client.get_user("user@example.com")

# Check user attributes to determine authorization
if user.profile.department == "IT" and user.profile.title == "Manager":
    print("User is authorized for privileged access")
else:
    print("User is not authorized for privileged access")
