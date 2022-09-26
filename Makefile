# build images
build:
	# get the latest msql image
	docker pull mysql

	# create/run the sql container(name: 'bookshelf-db')
	docker run --name bookshelf-db -e MYSQL_ROOT_PASSWORD=bookshellfish -e MYSQL_DATABASE=bookshelf -e MYSQL_USER=user -e MYSQL_PASSWORD=bookshellfish -d mysql:latest

	# build the spring boot app image('bookshelf-api') based on Dockerfile
	docker build . -t bookshelf-api

	# create/run the bookshelf-api container and link it to the mysql db image(bookshelf-db)
	docker run -p 8086:8086 --name bookshelf-api --link bookshelf-db:mysql -d bookshelf-api

# rebuild/update spring boot application (bookshelf-api) and run it with the db service
update:
	# remove existing docker container
	docker container rm bookshelf-api

	# build the spring boot app image('bookshelf-api') based on Dockerfile
	docker build . -t bookshelf-api

	docker start bookshelf-db

	# create/run the bookshelf-api container and link it to the mysql db image(bookshelf-db)
	docker run -p 8086:8086 --name bookshelf-api --link bookshelf-db:mysql -d bookshelf-api

# start the services
start:
	# start the sql container(name: 'bookshelf-db')
	docker start bookshelf-db

	# start the bookshelf-api
	docker start bookshelf-api

# stop the services
stop:
	# stop the sql container(name: 'bookshelf-db')
	docker stop bookshelf-db

	# stop the bookshelf-api
	docker stop bookshelf-api
