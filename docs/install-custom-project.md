# Create a custom project for Automatic Test

In the examples below we asume that calypso is installed into `/opt/calypso-15.2.0.28` directory

- create a new folder called `buggy-tests` into the custom projects folder
```bash
cd /opt/calypso-15.2.0.28/custom-extensions/custom-projects
mkdir buggy-tests
```
-  edit the file `settings.gradle` to add the following line
`include ':buggy-tests'`

- extract calypso libraries

    gradle unpackWar


TODO: continuará
