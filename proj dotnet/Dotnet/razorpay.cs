using Razorpay.Api;
using System;
using System.Collections.Generic;

class RazorpayExample
{
    static void Main()
    {
        // Replace these values with your actual Razorpay API key and secret
        string key = "your_api_key";
        string secret = "your_api_secret";

        // Initialize Razorpay client
        RazorpayClient client = new RazorpayClient(key, secret);

        // 1. Fetch card details with paymentId
        string paymentIdForCardDetails = "pay_Z6t7VFTb9xHeOs";
        Card cardDetails = client.Card.FetchCardDetails(paymentIdForCardDetails);

        Console.WriteLine($"Card Details for Payment {paymentIdForCardDetails}: {cardDetails}");

        // 2. Payment capture settings API
        Dictionary<string, object> orderRequest = new Dictionary<string, object>();
        orderRequest.Add("amount", 50000);
        orderRequest.Add("currency", "INR");
        orderRequest.Add("receipt", "rcptid_11");

        // Razorpay method: Order creation
        Order createdOrder = client.Order.Create(orderRequest);

        Console.WriteLine($"Created Order: {createdOrder}");

        // 3. Capture payment
        string paymentIdToCapture = "pay_Z6t7VFTb9xHeOs";
        Dictionary<string, object> capturePaymentRequest = new Dictionary<string, object>();
        capturePaymentRequest.Add("amount", 1000);
        capturePaymentRequest.Add("currency", "INR");

        // Razorpay method: Payment capture
        Payment capturedPayment = client.Payment.Fetch(paymentIdToCapture).Capture(capturePaymentRequest);

        Console.WriteLine($"Captured Payment: {capturedPayment}");

        // 4. Fetch all payments
        Dictionary<string, object> allPaymentsRequest = new Dictionary<string, object>();
        allPaymentsRequest.Add("count", "10");

        // Razorpay method: Fetch all payments
        List<Payment> allPayments = client.Payment.All(allPaymentsRequest);

        Console.WriteLine("All Payments:");
        foreach (var payment in allPayments)
        {
            Console.WriteLine(payment);
        }

        // 5. Fetch a payment
        string paymentIdToFetch = "pay_Z6t7VFTb9xHeOs";

        // Razorpay method: Fetch a payment
        Payment fetchedPayment = client.Payment.Fetch(paymentIdToFetch);

        Console.WriteLine($"Fetched Payment: {fetchedPayment}");

        // 6. Fetch payments for an order
        string orderId = "order_Z6t7VFTb9xHeOs";

        // Razorpay method: Fetch payments for an order
        List<Payment> paymentsForOrder = client.Order.Fetch(orderId).Payments();

        Console.WriteLine("Payments for Order:");
        foreach (var payment in paymentsForOrder)
        {
            Console.WriteLine(payment);
        }

        // 7. Update a payment
        string paymentIdToUpdate = "pay_Z6t7VFTb9xHeOs";
        Dictionary<string, object> updatePaymentRequest = new Dictionary<string, object>();
        Dictionary<string, string> notes = new Dictionary<string, string>();
        notes.Add("key1", "value1");
        notes.Add("key2", "value2");
        updatePaymentRequest.Add("notes", notes);

        // Razorpay method: Update a payment
        Payment updatedPayment = client.Payment.Fetch(paymentIdToUpdate).Edit(updatePaymentRequest);

        Console.WriteLine($"Updated Payment: {updatedPayment}");

        // 8. Fetch expanded card or emi details for payments
        // Request #1: Card
        Dictionary<string, object> cardParamRequest = new Dictionary<string, object>();
        cardParamRequest.Add("expand[]", "card");

        // Razorpay method: Fetch payments with expanded card details
        List<Payment> paymentsWithCardDetails = client.Payment.All(cardParamRequest);

        Console.WriteLine("Payments with Card Details:");
        foreach (var payment in paymentsWithCardDetails)
        {
            Console.WriteLine(payment);
        }

        // Request #2: EMI
        Dictionary<string, object> emiParamRequest = new Dictionary<string, object>();
        emiParamRequest.Add("expand[]", "emi");

        // Razorpay method: Fetch payments with expanded EMI details
        List<Payment> paymentsWithEMIDetails = client.Payment.All(emiParamRequest);

        Console.WriteLine("Payments with EMI Details:");
        foreach (var payment in paymentsWithEMIDetails)
        {
            Console.WriteLine(payment);
        }
    }
}