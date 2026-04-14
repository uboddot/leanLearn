# leanLearn

An app to learn

# frontend

### start locally dirctly calling vite

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
