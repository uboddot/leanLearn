# leanLearn

An app to learn

# frontend

### Deployment

[This](.github/workflows/build_image_to_registry.yml) GitHub Actions workflow builds the Docker image of the frontend (nginx) and pushes it to ghcr. Railway gets notified (not specified in the pipeline, but in Railway) and starts a new container from the newly pushed image.

### start locally directly calling vite

inside ./frontend call

```bash
npm run dev
```

### start in container

in ./frontend:

```bash
docker build -t lean-learn-frontend:latest .

docker run --name lean-learn-frontend-container -d -p 8080:80 lean-learn-frontend:latest
```

or by runing service in docker-compose:

```bash
docker compose -f docker-compose.yml up -d --build
```
