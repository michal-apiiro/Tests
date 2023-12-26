using Adyen;
using Adyen.Model.Checkout;
using Adyen.Service;
using Environment = Adyen.Model.Environment;


namespace AdyenExample
{
    class Program
    {
        static void Main(string[] args)
        {
// Create a paymentRequest object.
var amount = new Amount("USD", 1000);
var paymentRequest = new PaymentRequest
{
    Reference = "My first Adyen test payment with an API library/SDK",
    Amount = amount,
    ReturnUrl = @"https://your-company.com/...",
    MerchantAccount = "YOUR_MERCHANT_ACCOUNT",
};

// Set up the client and service.
var config = new Config
{
    XApiKey = "YOUR_API_KEY",
    Environment = Environment.Test
};
var client = new Client(config);
var checkout = new PaymentsService(client);

// Add your idempotency key.
var requestOptions = new RequestOptions { IdempotencyKey= "YOUR_IDEMPOTENCY_KEY" };

// Make a /payments request.
var paymentResponse = checkout.Payments(paymentRequest, requestOptions);
        }}}