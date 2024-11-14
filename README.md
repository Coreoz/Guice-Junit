Guice Test
==========
dsqd

Installation
------------
With Maven:
```xml
<dependency>
  <groupId>com.coreoz</groupId>
  <artifactId>http-routes-index</artifactId>
  <version>1.0.0</version>
</dependency>
```

Indexing routes to avoid duplication
------------------------------------
To check for routes duplication and recognize that:
- `/users/{userId}/orders/{orderId}` and `/users/{idUser}/orders/{idOrder}` are the same route
- `/users/{userId}/orders/{orderId}` and `/users/special-user/orders/special-order` are two different routes

The `HttpRoutesIndex` should be used.

Sample usage:
```java
HttpRoutesIndex<String> routesIndex = new HttpRoutesIndex<>();
routesIndex.addRoute("/users/{userId}/orders/{orderId}", "GET", "my custom data");
if (routesIndex.hasRoute("/users/{idUser}/orders/{idOrder}", "GET")) {
    // route already exists
}
```

Indexing multiple routes:
```java
List<CustomRouteType> existingCustomRoutes = // Get custom routes
HttpRoutesIndex<CustomRouteType> routesIndex = existingCustomRoutes
  .stream()
   // Convert custom route to ParsedRoute
  .map(route -> HttpRoutes.parseRoute(route.getPath(), route.getMethod(), route))
  .collect(HttpRoutesValidator.collector());
```
