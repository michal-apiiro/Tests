from mangopaysdk.mangopayapi import MangoPayApi
from mangopaysdk.entities.wallet import Wallet

def mangoPay():
    api = MangoPayApi()
    api.Config.ClientID = 'sdk-unit-tests'
    api.Config.ClientPassword = 'cqFfFrWfCcb7UadHNxx2C9Lo6Djw8ZduLi7J9USTmu8bhxxpju'

    user = api.users.Get(1)
    wallet = Wallet()
    wallet.Owners = [john.Id]
    wallet.Currency = 'EUR'
    wallet.Description = 'WALLET IN EUR'
    saved_wallet = api.wallets.Create(wallet)