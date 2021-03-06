# The Ratpack Manual

The manual is the canonical documentation for Ratpack.
It is both book like documentation _and_ the API reference (i.e. Javadoc).

The chapters provide high level information and link through to the API reference.
The chapters should not duplicate information that can be found in the API reference.

## Building the manual

The manual consists of *Markdown* templates and a stylesheet composed with *SASS* and *Compass*.
It is built with Gradle.

The manual is built to `ratpack-manual/build/manual/`.

### Requirements

The only thing you need to have installed in order to build the manual is a JVM.

### Commands

All commands can be run from the root of the *ratpack* project.

* `./gradlew packageManual` builds the manual.
* `./gradlew openManual` builds the manual and opens it in your default browser.
* `./gradlew openApi` builds the Javadoc API and opens it in your default browser.

## Contributing

### Chapters

The chapters are in Markdown format and are found in `ratpack-manual/src/content/chapters`.
The chapter number is determined by the filename.

#### Writing style

If you are contributing documentation please try to stick to the following style guidelines in your markdown.

* Headings should be in title case, e.g. "Unit testing handlers" rather than "Unit Testing Handlers".
* Proper names should be capitalized, e.g. "You can test Ratpack with Groovy and Spock" rather than "You can test ratpack with groovy and spock".
* File or directory names and literal URLs should be italicized, e.g. "The handler renders a template called *index.html*", "Point your browser at *http://localhost:5050/*".
* Maven artifact names should be italicized, e.g. "Groovy support is included in the *ratpack-groovy* package".
* Class, variable and method names should be rendered as code, e.g. "The `Handler` interface has a single method – `handle(Context)`".
* Literal values such as *true*, *false*, *null* or *"a string"* should be italicized.
* Code blocks should be delimited with triple back-ticks.
* To support syntax highlighting code blocks should, where appropriate, include a `language-xxx` immediately following the opening back-ticks where `xxx` is the language of the sample (use `language-bash` for terminal commands`).
* When discussing classes from the Ratpack API you should make the first reference to the class name a link to the Javadoc API page for that class. Only link the first reference in a chapter not all of them.
* When talking about common concepts such as Ratpack handlers it's not always necessary to use the class name – too many code blocks can make the text harder to read. e.g. "You can unit test your handler with `InvocationBuilder`" rather than "You can unit test your `Handler` with `InvocationBuilder`.

### API reference

The API reference is pulled from the Javadoc of Ratpack's public API.

#### Writing style

The same writing style rules apply as per above.