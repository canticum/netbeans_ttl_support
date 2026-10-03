# NetBeans Turtle File Type Support

A NetBeans module that adds basic Turtle (`.ttl`) file type support, including MIME recognition, a file template, an icon, and syntax highlighting.

## Requirements

- JDK 25+
- NetBeans 31+

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

## Turtle Code Templates

The plugin provides NetBeans code templates for frequently used Turtle and OWL constructs.

Type an abbreviation in a Turtle (`.ttl`) file and press `Tab` to expand it.

For example:

```text
cls<Tab>
```

expands to:

```turtle
:ClassName
    a owl:Class ;
    rdfs:label "Label"@en .
```

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

### OWL Restriction Templates

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

### Prefix Bundles

Prefix templates use the SPARQL-style Turtle syntax:

```turtle
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
```

No terminating period is required.

| Abbreviation | Prefixes |
|---|---|
| `w3c` | RDF, RDFS, OWL, XSD |
| `voc` | Schema.org, Dublin Core Terms, SKOS, PROV-O |
| `upper` | BFO, Relation Ontology (RO), Information Artifact Ontology (IAO) |
| `schema` | Schema.org |
| `bfo` | Basic Formal Ontology |
| `ro` | Relation Ontology |
| `iao` | Information Artifact Ontology |
| `sh` | SHACL |

For example:

```text
upper<Tab>
```

expands to:

```turtle
PREFIX bfo: <http://purl.obolibrary.org/obo/BFO_>
PREFIX ro:  <http://purl.obolibrary.org/obo/RO_>
PREFIX iao: <http://purl.obolibrary.org/obo/IAO_>
```

and:

```text
w3c<Tab>
```

expands to the standard RDF/RDFS/OWL/XSD namespace declarations.

### Customizing Templates

The templates are available through:

**NetBeans → Preferences → Editor → Code Templates**

Select **Turtle** from the **Language** menu to inspect or customize the registered templates.

The built-in templates are intended to provide concise, syntactically complete starting points rather than replace ontology design decisions. Domain-specific vocabulary and modeling patterns should normally remain project-local.

## License

This project is licensed under the Apache License 2.0. See [LICENSE](LICENSE) for details.
