# NetBeans Turtle File Type Support

A NetBeans module that adds practical editing support for Turtle (`.ttl`) files.

The plugin provides:

- Turtle MIME type recognition
- Turtle file templates
- File type icon support
- Turtle syntax highlighting
- Code templates for common Turtle and OWL constructs
- Prefix templates for widely used RDF and ontology vocabularies
- Line comment toggling using `#`

The project is intended to provide lightweight, native Turtle support inside Apache NetBeans without imposing a particular ontology engineering workflow.

## Requirements

- JDK 25+
- Apache NetBeans 31+

## Installation

### Build from Source

Compile the NetBeans module from the project root:

```bash
mvn clean package \
    -Dmaven.test.skip=true \
    -Dmaven.compiler.proc=full
```

### Development Installation

For development testing, open the project in NetBeans and run:

```text
Right-click project → Install/Reload in Development IDE
```

### Normal Installation

After building the project, install the generated NetBeans plugin:

```text
target/nbm/NetBeans_MIME_resolver-1.0-SNAPSHOT.nbm
```

through:

```text
Tools → Plugins → Downloaded → Add Plugins
```

Restart NetBeans after installation or upgrade.

The NetBeans version used to build the module should match the NetBeans version where the plugin is installed.

## Turtle Editing Support

The plugin registers `.ttl` files as:

```text
text/turtle
```

This allows Turtle files to participate in the NetBeans editor infrastructure, including syntax highlighting, code templates, file templates, and editor actions.

## Code Templates

The plugin provides code templates for frequently used Turtle and OWL constructs.

Type an abbreviation in a Turtle file and press `Tab` to expand it.

For example:

```text
cls<Tab>
```

expands to a class declaration such as:

```turtle
:ClassName
    a owl:Class ;
    rdfs:label "Label"@en .
```

Template fields can then be edited using the normal NetBeans code-template workflow.

### General Templates

| Abbreviation | Expands to |
|---|---|
| `pfx` | Turtle-style `@prefix` declaration |
| `pre` | SPARQL-style `PREFIX` declaration |
| `ont` | OWL ontology metadata block |
| `cls` | OWL class declaration |
| `op` | OWL object property declaration |
| `dp` | OWL datatype property declaration |
| `ind` | Named individual |
| `sub` | `rdfs:subClassOf` axiom |
| `inv` | `owl:inverseOf` axiom |
| `lbl` | `rdfs:label` statement |
| `cmt` | `rdfs:comment` statement |
| `imp` | `owl:imports` statement |

## OWL Restriction and Axiom Templates

| Abbreviation | Expands to |
|---|---|
| `some` | `owl:someValuesFrom` restriction |
| `only` | `owl:allValuesFrom` restriction |
| `value` | `owl:hasValue` restriction |
| `min` | `owl:minCardinality` restriction |
| `max` | `owl:maxCardinality` restriction |
| `exact` | `owl:cardinality` restriction |
| `eqc` | `owl:equivalentClass` axiom |
| `eqp` | `owl:equivalentProperty` axiom |
| `dis` | `owl:disjointWith` axiom |
| `type` | RDF type assertion |
| `same` | `owl:sameAs` assertion |
| `diff` | `owl:differentFrom` assertion |

The generated templates are intended to produce complete Turtle statements rather than isolated fragments whenever practical.

For example:

```text
some<Tab>
```

can expand to:

```turtle
:ClassName
    rdfs:subClassOf [
        a owl:Restriction ;
        owl:onProperty :property ;
        owl:someValuesFrom :Filler
    ] .
```

## Prefix Templates

Two forms of Turtle prefix declaration are supported.

### Individual Prefix Declaration

`pfx` generates the traditional Turtle form:

```turtle
@prefix ex: <https://example.org/> .
```

`pre` generates the SPARQL-style form:

```turtle
PREFIX ex: <https://example.org/>
```

The predefined prefix bundles use the SPARQL-style `PREFIX` syntax.

### W3C Core Prefixes

```text
w3c<Tab>
```

expands to:

```turtle
PREFIX rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX owl:  <http://www.w3.org/2002/07/owl#>
PREFIX xsd:  <http://www.w3.org/2001/XMLSchema#>
```

### Common Vocabulary Prefixes

```text
voc<Tab>
```

provides commonly used vocabularies including:

- Schema.org
- Dublin Core Terms
- SKOS
- PROV-O

### Upper / Foundational Ontology Prefixes

```text
upper<Tab>
```

expands to:

```turtle
PREFIX bfo: <http://purl.obolibrary.org/obo/BFO_>
PREFIX ro:  <http://purl.obolibrary.org/obo/RO_>
PREFIX iao: <http://purl.obolibrary.org/obo/IAO_>
```

This provides convenient access to:

- Basic Formal Ontology (BFO)
- Relation Ontology (RO)
- Information Artifact Ontology (IAO)

### Available Prefix Templates

| Abbreviation | Prefixes |
|---|---|
| `w3c` | RDF, RDFS, OWL, XSD |
| `voc` | Schema.org, Dublin Core Terms, SKOS, PROV-O |
| `upper` | BFO, RO, IAO |
| `schema` | Schema.org |
| `bfo` | Basic Formal Ontology |
| `ro` | Relation Ontology |
| `iao` | Information Artifact Ontology |
| `sh` | SHACL |

The grouped templates are intended for quickly preparing a Turtle document, while individual templates are useful when only one additional vocabulary is required.

## Comment Toggle

Turtle line comments use `#`.

The plugin integrates this with the NetBeans **Toggle Comment** editor action.

For example:

```turtle
:Person
    a owl:Class ;
    rdfs:label "Person"@en .
```

can be toggled to:

```turtle
# :Person
#     a owl:Class ;
#     rdfs:label "Person"@en .
```

The keyboard shortcut can be inspected or changed under:

```text
NetBeans → Preferences → Keymap
```

Search for:

```text
Toggle Comment
```

## Customizing Code Templates

The registered templates can be inspected or customized through:

```text
NetBeans → Preferences → Editor → Code Templates
```

Select:

```text
Language: Turtle
```

The built-in templates are intended to provide concise and syntactically useful starting points rather than encode ontology design decisions.

Domain-specific vocabularies, modeling patterns, and project conventions should normally remain project-local.

## Design Scope

This plugin focuses on lightweight Turtle editing support inside NetBeans.

It does not attempt to replace ontology editors, reasoners, RDF stores, or ontology validation systems. Semantic processing such as reasoning, SHACL validation, SPARQL querying, or project-specific vocabulary management can be provided independently by the surrounding application or ontology engineering toolchain.

## License

This project is licensed under the Apache License 2.0.

See [LICENSE](LICENSE) for details.