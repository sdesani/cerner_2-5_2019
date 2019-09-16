import groovy.json.JsonOutput;
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.GET
import static groovyx.net.http.ContentType.JSON
  
// initialize a new builder and give URL to open FHIR endpoint
def http = new HTTPBuilder("https://fhir-open.sandboxcerner.com/r4/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Patient?_id=4342009")
  
def data = http.request(GET,JSON) { req ->
	headers.'Accept' = 'application/json'
  
  response.success = { resp, jsonData ->
    assert resp.status == 200
    return jsonData
  }
  
  // called only for a 404 (not found) status code:
  response."404" = { resp ->
    log.error ("Not found")
    return null
  }
}
 
if (data) {
  println JsonOutput.prettyPrint(json)
}

