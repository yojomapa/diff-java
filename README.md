# diff-java
Simple Rest Implementation of Diff command using Java and Redis DB

##Requirements:
**Redis needs to be installed:** `~$ sudo apt install redis-server` (for ubuntu)
**Maven**
**Java 8**

This app creates 3 Rest Endpoints: 

1- localhost:8080/v1/diff/{id}/left - PUT JSON Array Single element Base64 Payload ["TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5"]

2- localhost:8080/v1/diff/{id}/right - PUT JSON Array Single element Base64 Payload ["TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5"]

3- localhost:8080/v1/diff/{id} - GET Returns if there are differences between the <left> and <right> text

This design implies the need to save the {id} with the text, that is what RedisDB is good for here, the {id} is the key and the 
Decoded Payload is the value.

##Running:

Excecute: mvn spring-boot:run

This will create the 3 Rest Endpoints

##Testing:
It can be done just curling the rest endpoints

1- `~$ curl -H 'Content-Type: application/json' -X PUT -d '["TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5"]' localhost:8080/v1/diff/123/left`

2- `~$ curl -H 'Content-Type: application/json' -X PUT -d '["TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5"]' localhost:8080/v1/diff/123/right`

3- `~$ curl  localhost:8080/v1/diff/123`

Checking data in Redis
`~$ redis-cli`
`127.0.0.1:6379> get 123:right`
`"Man is distinguished, not only"`

*That is all for now!*
