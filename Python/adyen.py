import Adyen

def main():
    adyen = Adyen.Adyen()
    adyen.payment.client.xapikey = "YOUR_API_KEY"
    adyen.payment.client.platform = "test"  # Change the value to live for the live environment.

    request = {
        "amount": {
            "currency": "USD",
            "value": 1000 # Value in minor units.
        },
        "reference": "My first Adyen test payment with an API library/SDK",
        "paymentMethod": {
            "type": "visa",
            "encryptedCardNumber": "test_4111111111111111",
            "encryptedExpiryMonth": "test_03",
            "encryptedExpiryYear": "test_2030",
            "encryptedSecurityCode": "test_737"
        },
        "shopperReference": "YOUR_SHOPPER_REFERENCE",
        "returnUrl": "https://your-company.com/...",
        "merchantAccount": "YOUR_MERCHANT_ACCOUNT"
        }

    result = adyen.checkout.payments_api.payments(request, idempotency_key="YOUR_IDEMPOTENCY_KEY")