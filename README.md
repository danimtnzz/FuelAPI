# FuelAPI
API creada con el objetivo de simplificar la implementación del servicio del gobierno: https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/ 
Este servicio devuelve todas las gasolineras españolas en la misma petición con un formato de varios parámetros entre los que se encuentra una lista sobre la que iterar, esto nos obliga a hacer dos modelos en nuestro proyecto, en el que tendremos que implementar un filtro por distancia en KM para obtener solo las necesarias, con esta nueva API podremos obtener directamente la lista con las gasolineras ya filtradas, ahorrandonos una parte de la implementación en nuestro proyecto.
La documentación se encuentra en https://fuelapi.onrender.com/swagger-ui/index.html
