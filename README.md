# A simple restful webservice example

 This restful web service will accept HTTP GET requests at:
 http://localhost:8080/echo

 and respond with a JSON representation of a echo:
 ```
 {"id":1,"content":"Hello, World!"}
 ```

 You can customize the echo with an optional name parameter in the query string:
 http://localhost:8080/echo?name=Alexander

 The name parameter value overrides the default value of "User" and is reflected in the response:
 ```
 {"id":1,"content":"Hello, Alexander!"}
 ```

Made by [Alexander Lüdeke](http://apage4u.de) 

