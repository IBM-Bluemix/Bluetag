#bluetag-engine service

This service is responsible for monitoring the location of all the users and calculating the distance between the users.  The UI queries this service to get the list of taggable users evertime a users location changes.

For more implementation details please refer to the [design documention](../bluetag-docs/bluetag-backend-implementation-details.md).  For an overview of the Bluetag application, please refer to the [overview documentaion](../../README.md).

#APIs exposed by service

GET TAGGABLE
Get list of people who are in a 10 meter radius around the user.

url: <prefix>-bluetag-engine.mybluemix.net/api/taggable/{username}
method: GET
response:
	{
		"taggable": ["user1", "user2", …],
		“distances”:[“user1distance”, “user2distance”, …]
	}

If something is wrong with database, will send back JSON payload from database.