from mangopaysdk import *

def mangoPay():
    api = MangoPayApi()
    api.Config.ClientID = 'your_client_id'
    api.Config.ClientPassword = 'your_client_password'

    user = users.Get(1)  # assuming that `users` is part of the imported module

    wallet = Wallet()
    wallet.Owners = [user.Id]
    wallet.Currency = 'EUR'
    wallet.Description = 'WALLET IN EUR'

    saved_wallet =  api.wallets.Create(wallet)
    return saved_wallet
