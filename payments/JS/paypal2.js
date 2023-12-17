const paypal = require('paypal-rest-sdk')


async function main(){
  paypal.payment.execute(paymentId, paymentDetails, (err) => {
    if (err) {
      return reject(err)
    }
  })

    paypal.payment.create(this.getPaymentDetails(description, amount, currency), (err, payment) => {
      if (err) {
        return reject(err)
      }
    })
  }