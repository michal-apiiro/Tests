package main

import (
    "fmt"
    "net/http"
    "github.com/gorilla/sessions"
)

var store = sessions.NewCookieStore([]byte("your-secret-key"))

func main() {
    http.HandleFunc("/set-session", SetSession)
    http.HandleFunc("/get-session", GetSession)

    http.ListenAndServe(":8080", nil)
}

func SetSession(w http.ResponseWriter, r *http.Request) {
    session, _ := store.Get(r, "session-name")
    session.Values["user_id"] = 123
    session.Save(r, w)
    fmt.Fprintln(w, "Session set successfully.")
}

func GetSession(w http.ResponseWriter, r *http.Request) {
    session, _ := store.Get(r, "session-name")
    userID, ok := session.Values["user_id"].(int)
    if !ok {
        fmt.Fprintln(w, "User ID not found in session.")
        return
    }
    fmt.Fprintf(w, "User ID from session: %d\n", userID)
}
