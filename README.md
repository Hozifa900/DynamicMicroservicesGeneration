# DynamicMicroservicesGeneration

How to run the Micro services:
1- Run the RegistryService
2- Run CrossingService (New Service)
3- Run CrossingService - it include the kafka broker
4- Run The reminding services including (RegistryService => service witch we working on)

How to run the front end:

# test-admin

## Installation

Install the application dependencies by running:

```sh
npm install
```

note:
there is tow front end project for the first one you need to run
npm install react-admin

## Development

Start the application in development mode by running:

```sh
npm run dev
```

## Production

Build the application in production mode by running:

```sh
npm run build
```

## DataProvider

The included data provider use [FakeREST](https://github.com/marmelab/fakerest) to simulate a backend.
You'll find a `data.json` file in the `src` directory that includes some fake data for testing purposes.

It includes two resources, posts and comments.
Posts have the following properties: `id`, `title` and `content`.
Comments have the following properties: `id`, `post_id` and `content`.

## Authentication

The included auth provider should only be used for development and test purposes.
You'll find a `users.json` file in the `src` directory that includes the users you can use.

You can sign in to the application with the following usernames and password:

- janedoe / password
- johndoe / password
