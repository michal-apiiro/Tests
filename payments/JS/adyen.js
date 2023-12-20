// Step 1: Require the parts of the module you want to use.
const { Client, CheckoutAPI} = require('@adyen/api-library');


async function main(){
  // Step 2: Initialize the client object.
  const client = new Client({apiKey: "YOUR_API_KEY", environment: "TEST"});

  // Step 3: Initialize the API object.
  const checkoutApi = new CheckoutAPI(client);

  // Step 4: Create the request object.
  const paymentRequest = {
      amount: {
        currency: "USD",
        value: 1000 // value in minor units
      },
      reference: "My first Adyen test payment with an API library/SDK",
      paymentMethod: {
        type: "scheme",
        encryptedCardNumber: "test_4111111111111111",
        encryptedExpiryMonth: "test_03",
        encryptedExpiryYear: "test_2030",
        encryptedSecurityCode: "test_737"
      },
      shopperReference: "YOUR_SHOPPER_REFERENCE",
      storePaymentMethod: true,
      shopperInteraction: "Ecommerce",
      recurringProcessingModel: "CardOnFile",
      returnUrl: "https://your-company.com/...",
      merchantAccount: "YOUR_MERCHANT_ACCOUNT"
  };

  // Optional: Add your idempotency key.
  const requestOptions = { idempotencyKey: "YOUR_IDEMPOTENCY_KEY" };

  // Step 5: Make a /payments request.
  checkoutApi.PaymentsApi.payments(paymentRequest, requestOptions)
    .then(paymentResponse => console.log(paymentResponse.pspReference))
    .catch(error => console.log(error));
}