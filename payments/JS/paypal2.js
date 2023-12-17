import  paypal  from 'paypal-rest-sdk';


async function main(){
  paypal.execute(paymentId, paymentDetails, (err) => {
    if (err) {
      return reject(err)
    }
  })

    paypal.create(this.getPaymentDetails(description, amount, currency), (err, payment) => {
      if (err) {
        return reject(err)
      }
    })
  }