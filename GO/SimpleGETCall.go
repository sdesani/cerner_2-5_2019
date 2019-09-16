// cerner_2^5_2019

package main

import (
	"net/http"
	"log"
	"io/ioutil"
)

func main() {
	CallFHIREndpoint()
}

// Call to open FHIR endpoint using net/http

func CallFHIREndpoint() {
	resp, err := http.Get("https://fhir-open.sandboxcerner.com/r4/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Patient?_id=4342009")
	if err != nil {
		log.Fatalln(err)
	}

	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		log.Fatalln(err)
	}

	log.Println(string(body))
}
