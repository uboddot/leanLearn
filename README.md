# leanLearn

An app to learn

# frontend

### Deployment

[This](.github/workflows/build_image_to_registry.yml) GitHub Actions workflow builds the Docker image of the frontend (nginx) and pushes it to ghcr. Railway gets notified (not specified in the pipeline, but in Railway) and starts a new container from the newly pushed image.

### start in container

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
