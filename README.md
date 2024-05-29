# FuelAPI

Esta API fue creada con el objetivo de simplificar la implementación del servicio del gobierno: [Servicio de Precios de Carburantes en Estaciones de Servicio](https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/).

El servicio mencionado devuelve todas las gasolineras españolas en la misma petición con un formato de varios parámetros entre los que se encuentra una lista sobre la que iterar. Esto nos obliga a hacer dos modelos en nuestro proyecto, en el que tendremos que implementar un filtro por distancia en kilómetros para obtener solo las necesarias. Con esta nueva API, podemos obtener directamente la lista con las gasolineras ya filtradas, ahorrándonos una parte de la implementación en nuestro proyecto.

La documentación se encuentra en [FuelAPI Documentation](https://fuelapi.onrender.com/swagger-ui/index.html). (Debemos esperar 1 minuto a que se construya el proyecto ya que está alojada en un host gratuito)
