start:
	docker-compose up

startDetached:
	docker-compose up -d

stop:
	docker-compose down

run:
	docker build .