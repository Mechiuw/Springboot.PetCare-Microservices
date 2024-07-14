<h1>Controller Layer</h1>
<p>Controller layer contains every each of entities controller except for the adoption details <br>
since we're working on adoption transaction more while adoption hierarchy presented as the parent <br> 
and adoption details as child</p>

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