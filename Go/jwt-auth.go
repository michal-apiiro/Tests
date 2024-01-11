package main

import (
    "fmt"
    "github.com/dgrijalva/jwt-go"
    "time"
)

func main() {
    // Create a token
    token := jwt.New(jwt.SigningMethodHS256)
    claims := token.Claims.(jwt.MapClaims)
    claims["user_id"] = 123
    claims["exp"] = time.Now().Add(time.Hour * 24).Unix()

    // Sign the token
    secret := []byte("your-secret-key")
    signedToken, err := token.SignedString(secret)
    if err != nil {
        fmt.Println("Error signing token:", err)
        return
    }

    fmt.Println("Signed Token:", signedToken)
}
