<h1>Controller Layer</h1>
<p>Controller layer contains every each of entities controller except for the adoption details <br>
since we're working on adoption transaction more while adoption hierarchy presented as the parent <br> 
and adoption details as child</p>
<br>


<h3>Controller Adoption Example :</h3>
<pre><code>
@RestController
@RequestMapping(Endpoint.ADOPTION)
@RequiredArgsConstructor
public class AdoptionController {<br>
    private final AdoptionService adoptionService;<br>
    @PostMapping
    public ResponseEntity<?> create(@RequestBody AdoptionRequest adoptionRequest) throws IllegalAccessException {
        AdoptionResponse createResponse = adoptionService.create(adoptionRequest);
        return new ResponseEntity<>(
                new CommonResponse<>(
                        HttpStatus.CREATED.value(),
                        "successfully created adoption",
                        createResponse
                ),
                HttpStatus.OK
        );
    }
}
</code></pre>
<p>This is a controller example from adoption controller class, where we use the ResponseEntity and CommonResponse record 
class for the JSON Response</p>

<br>
<h3>Common Response Record Class :</h3>
<pre><code>
package com.mcsoftware.petcare.model.dto.API;
public record CommonResponse<T>(
    Integer statusCode,
    String message,
    T data) {};
</code></pre>
<p>Here we use Record class for our common response as an experiment. <br>
since we refactoring from using regular response class using lombok,
we simplify it by using record class</p>
<br>
<h3>Controller Adoption Body Request Example :</h3>
<pre><code>
- Post Adoption JSON Format-
http://localhost:8080/api/client
{
    "clientId" : "xxxxxxxxx",
    "shelterId" : "xxxxxxxxx",
    "adoptionDetailList" : [
        {
            "petId" : "xxxxxxxxx",
            "message" : "lorem ipsum soldulamet",
        },
        {
            "petId" : "xxxxxxxxx",
            "message" : "lorem ipsum soldulamet",
        },
    ],
}
</code></pre>

<p>we will keep on improving our code for more updates to help the application performs a lot better</p>
<h3>~ API Will be Documented Independently ~</h3>