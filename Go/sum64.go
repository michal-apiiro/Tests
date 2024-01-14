package main

import (
	"fmt"
	"github.com/cespare/xxhash/v2"
)

func main() {
	// Input data (byte slice)
	data := []byte("Hello, xxHash!")

	// Compute the 64-bit xxHash of the input data
	hash := xxhash.Sum64(data)

	// Print the hash value
	fmt.Printf("xxHash (64-bit) of data: %d\n", hash)
}
