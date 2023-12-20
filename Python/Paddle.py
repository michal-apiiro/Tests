from paddle import PaddleClient


def main():
    paddle = PaddleClient()
    paddle.list_products()

    paddle.get_order_details(checkout_id=checkout_id)
    paddle.get_user_history(email=email)
    paddle.get_prices(product_ids=[product_id])
    paddle.list_coupons(product_id=product_id)
    paddle.create_coupon(
        coupon_type='product',
        discount_type='percentage',
        discount_amount=50,
        allowed_uses=1,
        recurring=False,
        currency='USD',
        product_ids=product_ids,
        coupon_code='50%OFF',
        description='50% off coupon over $10',
        expires=expires,
        minimum_threshold=10,
        group='paddle-python',
    )
    paddle.delete_coupon(coupon_code=new_coupon_code, product_id=product_id)
    paddle.update_coupon(
        coupon_code=coupon_code,
        new_coupon_code='40%OFF',
        new_group='paddle-python-test',
        product_ids=[product_id],
        expires=expires,
        allowed_uses=1,
        currency='USD',
        minimum_threshold=10,
        discount_amount=40,
        recurring=True
    )
    paddle.list_transactions()
    paddle.list_transactions(entity='subscription', entity_id=subscription_id)
    paddle.refund_payment(order_id=order_id, amount=amount, reason=reason)
    paddle.list_plans()
    paddle.create_plan(
        plan_name='plan_name',
        plan_trial_days=14,
        plan_length=1,
        plan_type='month',
        main_currency_code='USD',
        initial_price_usd=50,
        recurring_price_usd=50,
    )
    paddle.list_subscription_users()
    paddle.cancel_subscription(subscription_id=1234)
    paddle.update_subscription(subscription_id=1234, pause=True)
    paddle.preview_update_subscription(
        subscription_id=123,
        bill_immediately=True,
        quantity=101,
    )
    paddle.get_webhook_history()