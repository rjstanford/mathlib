mathlib
=======

A trivial utility illustrating private S3 publication through Maven

Go into S3 and create a new bucket - in this example, "protea-repo"

Create a new IAM user, get their credentials, and give them the following access policy:

```
{
  "Statement": [
    {
      "Action": "s3:*",
      "Effect": "Allow",
      "Resource": [
        "arn:aws:s3:::protea-repo",
        "arn:aws:s3:::protea-repo/*"
      ]
    }
  ]
}
```

Create a ~/.m2/settings.xml file as follows:

```xml
<?xml version="1.0" encoding="UTF-8"?>

<settings
	xmlns="http://maven.apache.org/SETTINGS/1.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">

	<servers>

		<server>
			<id>aws-release</id>
			<username>xxxx</username>
			<password>xxxx</password>
		</server>

		<server>
			<id>aws-snapshot</id>
			<username>xxxx</username>
			<password>xxxx</password>
		</server>

	</servers>

</settings>
```

Alternately you can set two environment variables: AWS_ACCESS_KEY and AWS_SECRET_KEY .  That approach works better for CI systems.

Within the pom.xml file the build extension allows s3:// URLs to be used.  The distributionManagement section defines the repositories in a previously created S3.

