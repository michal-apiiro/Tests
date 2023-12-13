# WePay Python SDK - http://git.io/v7Y1jA
from wepay import WePay


def main():
    # application settings
    access_token = '1a3b5c7d9'
    production = False

    # set production to True for live environments
    wepay = WePay(production, access_token)

    # create an account for a user
    response = wepay.call('/account/create', {
        'name': 'Account Name',
        'description': 'A description for your account.'
    })
