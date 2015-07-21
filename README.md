# serenity-bdd-app
Test bdd with serenity

## Overview
This project is a test project to run serenity bdd (formerly thycidides) with jbehave and upload the report to a repository.


## generate the bdd report
Maven site is used to deploy the serenity report and is configured with wagon-file plugin to deploy the site from /serenity-bdd-integration to c:/tmp/serenity-bdd-integration.
To generate the report:

    mvn install site:deploy
	

