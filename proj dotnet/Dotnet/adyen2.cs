using System;
using Adyen.Security;
using Adyen.Service;
using Adyen.Model.Nexo;
using Adyen.Model.Nexo.Message;
using Adyen.HttpClient;
using Newtonsoft.Json;

namespace LocalAdyenTerminalAPI
{
    class Program
    {
        static void Main(string[] args)
        {
            // This is a simple console application using the 9.1 .NET Adyen library to make a successful
            // Local Terminal API call. Please pay close attention to the comments about where you need to edit this to your
            // own terminal settings


            Adyen.Config config = new Adyen.Config
            {
                // Please change the IP address below to the Local IP of the terminal that is on the same
                // network as this application
                Endpoint = @"https://192.168.0.71:8443/nexo",
                Environment = Adyen.Model.Enum.Environment.Test
            };

            Adyen.Client client = new Adyen.Client(config)
            {
                HttpClient = new HttpUrlConnectionClient()
            };

            PosPaymentLocalApi posPaymentLocalApi = new PosPaymentLocalApi(client);

            var _encryptionCredentialDetails = new EncryptionCredentialDetails
            {
                // These settings are set in the Adyen Customer area, and below must match what is
                // configured in Adyen. Once you match them, make sure to "pull down the config", so the 
                // terminal has the settings applied
                AdyenCryptoVersion = 1,
                KeyIdentifier = "CryptoKeyIdentifier12345",
                Password = "p@ssw0rd123456",
                KeyVersion = 1
            };

            // Please replace the terminalId with the ID of your terminal (this can be seen from the customer area),
            // and is of the format {TerminalModel}={SerialNumber}

            var terminalId = "P400Plus-275266890";
            SaleToPOIRequest paymentRequest = CreatePosPaymentRequest(terminalId);
            // Log the payment request to console
            Console.WriteLine(JsonConvert.SerializeObject(paymentRequest, Formatting.Indented));
            // Stop the execution so you can have a look and make sure your payment request looks right
            Console.ReadLine();

            SaleToPOIResponse saleToPoiResponse = posPaymentLocalApi.TerminalApiLocal(paymentRequest, _encryptionCredentialDetails);
            // Now my terminal is lit up asking for payment, now tap card and get response
            Console.WriteLine(JsonConvert.SerializeObject(saleToPoiResponse, Formatting.Indented));
            Console.ReadLine();
        }

        public static SaleToPOIRequest CreatePosPaymentRequest(String terminalId)
        {
            Random random = new Random();
            int reference = random.Next();

            SaleToPOIRequest saleToPoiRequest = new SaleToPOIRequest()
            {
                MessageHeader = new MessageHeader
                {
                    MessageType = MessageType.Request,
                    MessageClass = MessageClassType.Service,
                    MessageCategory = MessageCategoryType.Payment,
                    SaleID = "DemoCashRegister",
                    POIID = terminalId,
                    ServiceID = DateTime.Now.ToString("ddHHmmss") //this should be unique
                },
                MessagePayload = new PaymentRequest()
                {
                    SaleData = new SaleData()
                    {
                        SaleTransactionID = new TransactionIdentification()
                        {
                            TransactionID = reference.ToString(),
                            TimeStamp = DateTime.Now
                        },
                    },
                    PaymentTransaction = new PaymentTransaction()
                    {
                        AmountsReq = new AmountsReq()
                        {
                            Currency = "GBP",
                            RequestedAmount = 10
                        }
                    },
                    PaymentData = new PaymentData()
                    {
                        PaymentType = PaymentType.Normal
                    }
                },
                SecurityTrailer = new ContentInformation() { }
            };
            return saleToPoiRequest;
        }
    }
}