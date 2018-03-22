# Pong By Alex Pearce

Pong built with LibGDX


# Running and Packaging

Download or clone the repository.

Navigate to the directory.

To run the game:

`gradlew desktop:run`

This compiles your core and desktop project, and runs the desktop starter. The working directory is the project's assets folder!

To package the game:

`gradlew desktop:dist`

This will create a runnable JAR file located in the `desktop/build/libs/` folder. It contains all necessary code as well as all art assets. This can be run by double clicking or via the command line with `java -jar jar-file-name.jar`. Must have a JVM installed for this to work. The JAR will work on Windows, Linux and Mac OS X!



