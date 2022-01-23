# SwapiChallenge

## Requirements

The first page is Api Root (https://swapi.dev/api/)

### Films: 
A list of the movies with the most recent movie being displayed first.
When selecting a movie, it should bring up their information such as release year, director and producer, etc.
No need to list the characters, planets, starships and other listed information in the film information page

### Starships: 
A list of the ships with the shortest length being displayed first.
Same as films, once selecting the starship. It should come to the information like manufacture, crew, passengers, etc.
No need to list the films on the starship information page
UI/ UX is left to your discretion but still need to be tidy

## Jetpack library has been used for following functionality

* Navigation
* Hilt

Futhermore, following libraries are used for their relevant purposes

* LiveData
* ROOM (For caching data)
* Retrofit

## Architecturally

* MVVM 
* I have used DTO, DBO and Domain model when necessary