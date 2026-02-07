# Containerization Guide

## Docker

```bash
# Build and run
docker-compose up --build

# Stop
docker-compose down
```

## Kubernetes

```bash
# Deploy
kubectl apply -f k8s/configmap.yaml
kubectl apply -f k8s/deployment.yaml

# Check status
kubectl get pods

# Access locally
kubectl port-forward service/cargo-svc-service 8080:8080
```

## Environment Variables

| Variable | Default |
|----------|---------|
| SPRING_DATASOURCE_URL | jdbc:mysql://localhost:3306/cargo_db |
| SPRING_DATASOURCE_USERNAME | cargo_user |
| SPRING_DATASOURCE_PASSWORD | cargo_password |
| SERVER_PORT | 8080 |
