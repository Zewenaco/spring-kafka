
compose-up:
	docker-compose -f minikube/docker/docker-compose.yaml up --build -d

compose-up-service:
	docker-compose -f minikube/docker/docker-compose.yaml up -d $(SERVICE)

compose-exec-service:
	docker-compose -f minikube/docker/docker-compose.yaml exec $(SERVICE) bash