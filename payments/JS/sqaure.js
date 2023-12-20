const { client } = require('square');

async function run() {
    const createpaymnet =client.paymentsApi.createPayment();
    const response =  client.paymentsApi.completePayment('bP9mAsEMYPUGjjGNaNO5ZDVyLhSZY',{});
    const response_cancel = await client.paymentsApi.cancelPaymentByIdempotencyKey({idempotencyKey: 'a7e36d40-d24b-11e8-b568-0800200c9a66'});
    const getpayment = client.paymentsApi.getPayment('bP9mAsEMYPUGjjGNaNO5ZDVyLhSZY');
    const update = client.paymentsApi.updatePayment('1QjqpBVyrI9S4H9sTGDWU9JeiWdZY',
    {
      payment: {
        amountMoney: {
          amount: 1000,
          currency: 'USD'
        },
        tipMoney: {
          amount: 100,
          currency: 'USD'
        },
        versionToken: 'ODhwVQ35xwlzRuoZEwKXucfu7583sPTzK48c5zoGd0g6o'
      },
      idempotencyKey: '956f8b13-e4ec-45d6-85e8-d1d95ef0c5de'
    });
    const cancel = await client.paymentsApi.cancelPayment('1QjqpBVyrI9S4H9sTGDWU9JeiWdZY');
}