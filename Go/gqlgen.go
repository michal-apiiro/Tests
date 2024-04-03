// server.go
package main

import (
    "log"
    "net/http"

    "github.com/99designs/gqlgen/handler"
    "github.com/gorilla/mux"
)

func main() {
    r := mux.NewRouter()
    srv := handler.NewDefaultServer(NewExecutableSchema(Config{Resolvers: &Resolver{}}))

    r.Handle("/query", srv)

    log.Println("Server started at http://localhost:8080/query")
    log.Fatal(http.ListenAndServe(":8080", r))
}
