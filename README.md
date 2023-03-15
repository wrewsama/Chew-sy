# Chew-sy
A web application for choosing a restaurant to eat at. Done as a take-home assignment for GovTech Singapore.

## Table of Contents
- [Chew-sy](#chew-sy)
  - [Table of Contents](#table-of-contents)
  - [Requirements / User Stories](#requirements--user-stories)
  - [Feature List](#feature-list)
  - [Non Functional Requirements](#non-functional-requirements)
  - [Tech Stack](#tech-stack)
  - [Installation](#installation)
  - [Usage](#usage)
  - [Backend API documentation](#backend-api-documentation)
    - [POST /sessions](#post-sessions)
    - [GET /sessions/:id](#get-sessionsid)
    - [GET /restaurants/:id](#get-restaurantsid)
    - [GET /restaurants/random/:id](#get-restaurantsrandomid)
    - [POST /restaurants](#post-restaurants)
    - [DELETE /restaurants/:id](#delete-restaurantsid)

## Requirements / User Stories
- [X] As a team member, I want to get a random restaurant choice out of everyone's choices so that everyone is treated fairly.
- [X] As a user, I want to add restaurants to the "pool" of choices.
- [X] As a user, I want to remove restaurants so that if I change my mind, that restaurant will not get picked.
- [X] As a member of a big team, I want to let each team member input their own choices so that we can decide what to eat even if we cannot meet up beforehand.
- [X] As a user, I want to 'reroll' a new choice in case I change my mind again.
- [X] As a user, I want to reset the pool of choices so that I can remove all the choices more easily.
- [X] As a user, I want the process of inputting my team's choices and getting the recommendation to be as simple and fast as possible.

## Feature List
- [X] Create new 'lunch session' which allows users with the link to add restaurants to the pool of choices.
- [X] Add restaurant to pool.
- [X] Delete restaurant from pool.
- [X] Reset the pool.
- [X] Get random choice from the pool of choices.
- [X] Reroll a new choice from the pool of choices.

## Non Functional Requirements
- [] A 'lunch session' can be set up and shared within 10 seconds of opening the webpage.

## Tech Stack
This project uses the following technologies:
1. Vite + React/Typescript for the frontend
2. Bootstrap for css stylesheets
3. Play/Akka and Java for the backend API
4. H2 Database

## Installation
Clone the Github repo with the command:
'''
    $ git clone git@github.com:wrewsama/Chew-sy.git
'''

## Usage
1. Ensure you have `docker` and `docker-compose` installed.

2. `cd` into the repository folder and run:
```
    docker compose up -d
```

3. Visit `localhost:8080` to view the webpage.

4. To shut down the app, run:
```
    docker compose down
```

## Backend API documentation

### POST /sessions
Adds a new lunch session to the backend database.

Arguments:
id: A String containing the lunch session's id
name: A String containing the name of the user creating the lunch session.

### GET /sessions/:id
Gets the session matching the given id from the backend database.

Arguments:
id: A String with the id of the lunch session we want to get.

### GET /restaurants/:id
Gets all restaurants corresponding to the id of a given lunch session.

Arguments:
id: A String with the id of the lunch session whose restaurants we want to get.

### GET /restaurants/random/:id
Gets a random restaurant out of the restaurants added to a particular lunch session.

Arguments:
id: A String with the id of the lunch session whose restaurants we want to get.

### POST /restaurants
Adds a new restaurant to the backend database.

Arguments:
id: The unique id of the restaurant.
sessionId: The id of the session this restaurant is tied to.
name: The name of the restaurants.

### DELETE /restaurants/:id
Deletes a restaurant from the database.

Arguments:
id: The id of the restaurant to be deleted.


