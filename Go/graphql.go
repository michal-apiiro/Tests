package main

import (
    "encoding/json"
    "log"
    "net/http"

    "github.com/graphql-go/graphql"
)

func main() {
    // Define types
    userType := graphql.NewObject(graphql.ObjectConfig{
        Name: "User",
        Fields: graphql.Fields{
            "id": &graphql.Field{
                Type: graphql.String,
            },
            "name": &graphql.Field{
                Type: graphql.String,
            },
            "email": &graphql.Field{
                Type: graphql.String,
            },
        },
    })

    // Define query
    rootQuery := graphql.NewObject(graphql.ObjectConfig{
        Name: "Query",
        Fields: graphql.Fields{
            "user": &graphql.Field{
                Type: userType,
                Args: graphql.FieldConfigArgument{
                    "id": &graphql.ArgumentConfig{
                        Type: graphql.String,
                    },
                },
                Resolve: func(params graphql.ResolveParams) (interface{}, error) {
                    // Here you would typically fetch data from your database or other sources
                    // For simplicity, we return hardcoded data
                    id, ok := params.Args["id"].(string)
                    if ok {
                        return map[string]interface{}{
                            "id":    id,
                            "name":  "John Doe",
                            "email": "john.doe@example.com",
                        }, nil
                    }
                    return nil, nil
                },
            },
        },
    })

    // Define schema
    schema, err := graphql.NewSchema(graphql.SchemaConfig{
        Query: rootQuery,
    })
    if err != nil {
        log.Fatalf("Failed to create schema, error: %v", err)
    }

    // Define handler for GraphQL endpoint
    http.HandleFunc("/graphql", func(w http.ResponseWriter, r *http.Request) {
        // Parse and execute the query
        result := graphql.Do(graphql.Params{
            Schema:        schema,
            RequestString: r.URL.Query().Get("query"),
        })

        // Convert result to JSON and send it as response
        json.NewEncoder(w).Encode(result)
    })

    // Start the server
    log.Println("GraphQL server running at http://localhost:8080/graphql")
    log.Fatal(http.ListenAndServe(":8080", nil))
}
