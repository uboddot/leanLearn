# leanLearn

An app to learn

# TOC

- [Frontend](#Frontend)
  - [testing](#testing)
  - [deployment](#deployment)
  - [developement](#developement)

# Frontend

### Testing

E2e tests with Playwright:

```bash
npx playwright test [secificFile] [--ui]
```

Run ` npx playwright codegen` to generate tests with codegen.

See [Playwright](https://playwright.dev/docs/intro) for more details.

### Deployment

[This](.github/workflows/build_image_to_registry.yml) GitHub Actions workflow builds the Docker image of the frontend (nginx) and pushes it to ghcr. Railway gets notified (not specified in the pipeline, but in Railway) and starts a new container from the newly pushed image.

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
