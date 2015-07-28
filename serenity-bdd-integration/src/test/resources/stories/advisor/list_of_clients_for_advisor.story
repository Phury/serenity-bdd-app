Scenario: list of clients for advisor

Given that I am an authenticated advisor $advisorId
When I access uri $clientListUri
Then I retrieve a list of clients
And the list of clients contains $client1
And the list of clients contains $client2

Examples:
| advisorId | clientListUri 					| client1 		| client2 		|
| 1			| /advisor/$advisorId/client/list	| client1.json	| client2.json	|