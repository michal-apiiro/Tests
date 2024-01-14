package main

import (
	"fmt"
	"github.com/rogpeppe/fastuuid"
)

func main() {
	// Create a new UUID generator
	gen := fastuuid.MustNewGenerator()

	// Generate a new UUID
	uuid := gen.Next()

	// Print the generated UUID
	fmt.Printf("Generated UUID: %s\n", uuid)
}
