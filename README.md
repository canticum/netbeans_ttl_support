# NetBeans Turtle File Type Support

A NetBeans module that adds basic Turtle (`.ttl`) file type support, including MIME recognition, a file template, an icon, and syntax highlighting.

## Requirements

- JDK 25+
- NetBeans 30+

## Installation

Compile the NetBeans module from the project root:

`mvn clean package -Dmaven.test.skip=true -Dmaven.compiler.proc=full`

For development testing, open the project in NetBeans and run:

`Right click project → Install/Reload in Development IDE`

For normal installation, install the generated plugin file:

`target/nbm/NetBeans_MIME_resolver-1.0-SNAPSHOT.nbm`

through:

`Tools → Plugins → Downloaded → Add Plugins`

Restart NetBeans after installation. The NetBeans version used to build the module should match the NetBeans version where the plugin is installed.

## Todo

- Naming
- Default template
- Improve syntax highlighting