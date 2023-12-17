var BasePaymentMethodView = require('./base-payment-method-view');
var PayPal = require('braintree-web/paypal');

async function main(){
    PayPal.create({
        client: clientInstance
      }, function (paypalErr, paypalInstance) {
        if (paypalErr) {
          console.error('Error creating PayPal:', paypalErr);
          return;
      }
    })
  }
