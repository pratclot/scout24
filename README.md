# android-coding-challenge

Currently the simple app fetches a list of countries and displays them.

Documentation for used API: https://restcountries.com/

Your task is to continue development reaching the following milestones: 

- ~~list should show only European countries~~
- ~~list should show each countries capital too as well as its flag~~
- ~~the layout of the item should show the flag on the left of texts and look OK~~
- upon clicking an item a new screen should open
- BONUS the new screen should show a map at the countries capital

Emphasize quality and testing, this should be a work sample that meets your professional standards.
Leave comments for what you leave for later but deem important or any assumptions you make. 

Also feel free to use this file to add general notes or whatever you would like to document. 

Reserve 2-3 hours or less for this task (maybe you have reference projects handy). 
If more time is needed you might go overboard. Remember you can also comment open tasks. 

# candidate space

- initial code was not functional because country data service would return incomplete JSON doc, and this would crash the app on start. Passing additional URL parameters fixes this issue. Adding error handler could also help, but would not really fix the functionality.
- (rant) https://restcountries.com does not include a Swagger UI endpoint, which is a shame. Consumers are expected to use a custom [table](https://gitlab.com/restcountries/restcountries/-/blob/master/FIELDS.md) instead.
- usecases allow to nicely separate filtering of the data and reuse base `GetCountries` one.
- for image loading I wanted to provide a single instance of `ImageLoader`, and this was achieved by `Arrow` library with its `memoize()` wrapper (I could not figure how to do it with `lazy`, and did not want to bring DI in). I admit this is pretty unconventional and could be a bad choice for a real app :)
- (TODO) country service certificate seems to expire randomly and often, something has to be done about that on the app level.
- (TODO) generate DTOs from OpenAPI schema to stay consistent with the deployed version of country API. It is important because writing them by hand is error-prone and cumbersome.

...