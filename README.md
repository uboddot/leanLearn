# leanLearn

An app to learn

# TOC

- [Frontend](#Frontend)
  - [testing](#testing)
  - [deployment](#deployment)
  - [developement](#developement)

- [Backend](#Backend)
  - [testing](#testing-1)
  - [deployment](#deployment-1)
  - [developement](#developement-1)

# Frontend

### Testing

E2e tests with Playwright:

```bash
npx playwright test [specificFile] [--ui]
```

Run ` npx playwright codegen` to generate tests with codegen.

See [Playwright](https://playwright.dev/docs/intro) for more details.

### Deployment

[This](.github/workflows/frontend_build_image_to_registry.yml) GitHub Actions workflow builds the Docker image of the frontend (nginx) and pushes it to ghcr. Railway gets notified (not specified in the pipeline, but in Railway) and starts a new container from the newly pushed image.

### Developement

#### start locally directly calling vite

Make sure Node.js and npm are installed, then in `./frontend` install dependencies before starting the dev server:

```bash
cd ./frontend
npm install
npm run dev
```

#### start in container

with hot reload

```bash
docker compose -f docker-compose.dev.yml up -d --build
```

### or start locally directly calling vite

Make sure Node.js and npm are installed, then in `./frontend` install dependencies before starting the dev server:

```bash
cd ./frontend
npm install
npm run dev
```

# Backend

### Testing

tbd

### Deployment

In [this](.github/workflows/backend_build_image_to_registry.yml) GitHub Actions workflow, the backend image gets built and pushed to ghcr. It is not yet deployed to a server.

### Developement

#### start container

Start the dev compose, as it is a service in there:

```bash
docker compose -f docker-compose.dev.yml up -d --build
```

#### OpenAPI

For API development OpenAPI is included in the project. Got to [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html). See [swagger docs](https://swagger.io/docs/).
