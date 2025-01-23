# android-coding-challenge

Currently the simple app fetches a list of countries and displays them.

Documentation for used API: https://restcountries.com/

Your task is to continue development reaching the following milestones:

- ~~list should show only European countries~~
- ~~list should show each countries capital too as well as its flag~~
- ~~the layout of the item should show the flag on the left of texts and look OK~~
- ~~upon clicking an item a new screen should open~~
- ~~BONUS the new screen should show a map at the countries capital~~ Please follow
  the [README](https://github.com/googlemaps/android-maps-compose/tree/main) file
  to setup API key.

Emphasize quality and testing, this should be a work sample that meets your professional standards.
Leave comments for what you leave for later but deem important or any assumptions you make.

Also feel free to use this file to add general notes or whatever you would like to document.

Reserve 2-3 hours or less for this task (maybe you have reference projects handy).
If more time is needed you might go overboard. Remember you can also comment open tasks.

# candidate space

- initial code was not functional because country data service would return incomplete JSON doc, and
  this would crash the app on start. Passing additional URL parameters fixes this issue. Adding
  error handler could also help, but would not really fix the functionality.
- (minor) https://restcountries.com does not serve a Swagger UI endpoint, which is a shame.
  Consumers are expected to use a
  non-interactive [table](https://gitlab.com/restcountries/restcountries/-/blob/master/FIELDS.md)
  instead.
- usecases allow to nicely separate filtering of the data and reuse base `GetCountries` one.
- for image loading I wanted to provide a single instance of `ImageLoader`, and this was achieved by
  `Arrow` library with its `memoize()` wrapper (I could not figure how to do it with `lazy`, and did
  not want to bring DI in). I admit this is pretty unconventional and could be a bad choice for a
  real app :)
- (TODO) country service certificate seems to expire randomly and often, something has to be done
  about that on the app level. For testing purposes setting device's clock back works fine, lol.
- (TODO) generate DTOs from OpenAPI schema to stay consistent with the deployed version of country
  API. It is important because writing them by hand is error-prone and cumbersome.
- (TODO) navigation is based on a simple stack of activities. A couple of practical reasons for this
  choice:
    - allows to extend the code later while using basic Android navigation tools.
    - it allows to work with `back` button as users would expect normally.
    - there is neither an explicit requirement for a navigation solution nor a need for the app in
      its current feature state to have more complex code.
- (TODO) a `CountryUI` class could help to further separate plain data from UI needs. Overall,
  attempt was made to make all UI components depend on primitives like `String` or `Double`, which
  ensures easy extraction of these components to a design system for example.
- (TODO) eventually, all the new packages should become Gradle projects to allow for parallel
  compilation.
- the [docs](https://github.com/googlemaps/android-maps-compose/tree/main) of compose maps
  dependency is something else! It is super helpful that Google team provided a sample app with all
  required Gradle setup.
- there are no tests of any kind (apart from a small DTO mapper test). For UI tests obviously there
  is simply no time to implement them (although snapshot testing is much simpler than Espresso), for
  Unit tests there is not enough business logic :)
- instead, the app presents a nice base for further refactoring to convert it to a monorepo-like
  project.

...