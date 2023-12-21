package utils

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
	"net/http/httptest"
	"reflect"
	"strings"
	"testing"
        "crypto/hmac"
	"crypto/sha256"
	"encoding/hex"

	razorpay "github.com/razorpay/razorpay-go"
	"github.com/stretchr/testify/assert"
)


func testSetup() func() {
	mux = http.NewServeMux()
	server = httptest.NewServer(mux)
	Client = razorpay.NewClient(TestAccessKey, TestAccessSecret)
	razorpay.Request.BaseURL = server.URL
	body, err := Client.Payment.CreateRecurringPayment(data, nil)

	return func() {
		server.Close()
	}
}

