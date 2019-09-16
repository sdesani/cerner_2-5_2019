# cerner_2^5_2019

import urllib.request

# Request with Accept Header to open FHIR endpoint
url = 'https://fhir-open.sandboxcerner.com/r4/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Patient?_id=4342009'

headers = {}
headers['Accept'] = 'application/json'

request = urllib.request.Request(url, headers=headers)
resp = urllib.request.urlopen(request)

print(resp.read())
