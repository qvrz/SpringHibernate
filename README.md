# SpringMicroserviceApp

# http://localhost:8761 - Microservice running Eureka server

# http://localhost:8098/ - First microservice:

- http://localhost:8098/getListOfWorkers - list of all Workers in repository.
- http://localhost:8098/getListOfErrands - list of all Errands in repository.
- http://localhost:8098/addWorkers - adds some sample Workers to repository.
- http://localhost:8098/addErrands - adds some sample Errands to repository.

# http://localhost:8099/ - Second microservice:

- http://localhost:8099/get/{id} - returns Worker with appropriate ID from database.
- http://localhost:8099/holidays/{id}/{days} - Worker with ID {id} takes {days} days of holidays.

# http://localhost:8099/ - Third microservice:

- http://localhost:8097/getDeskNumber/{id} - returns desk number of Worker with ID {id}
- http://localhost:8097/{uid}/signErrand/{eid} - User with ID {uid} signs Errand with ID {eid}
