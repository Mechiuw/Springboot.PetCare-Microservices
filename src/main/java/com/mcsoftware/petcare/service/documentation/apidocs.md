<h1>API Documentations</h1>

<p>Side note* <br>
we will limit the request service for adoption detail, since it already defined and created 
at the same time when creating adoption request</p>

<h3>CRUD Service</h3>
<p>mainly basic CRUD service, requires super admin authorities to execute these requests</p>

| Service                  | Endpoint Application                    | Request                  |
|--------------------------|-----------------------------------------|--------------------------|
| Client Service           | "http://localhost/api/client"           | POST,PUT,DELETE,GET      |
| Pet Service              | "http://localhost/api/pet"              | POST,PUT,DELETE,GET      |
| Shelter Service          | "http://localhost/api/shelter"          | POST,PUT,DELETE,GET      |
| Service Provider Service | "http://localhost/api/service-provider" | POST,PUT,DELETE,GET      |
| Vaccination Service      | "http://localhost/api/vaccination"      | POST,PUT,DELETE,GET      |
| Wild Animal Service      | "http://localhost/api/wild-animal"      | POST,PUT,DELETE,GET      |
| Adoption Service         | "http://localhost/api/adoption"         | POST,PUT,SOFT-DELETE,GET |
| Adoption Detail Service  | NO CONTROLLER - NO ACCESS POINT         | CRUD SERVICE             |



<h3>Business Service</h3>
<p>all about maintainer request, can be controlled by super admin, white list user,and admin. <br>
some of it can also be controlled by regular users</p>

| Service                    | Endpoint Application                                    | Request      |
|----------------------------|---------------------------------------------------------|--------------|
| Get All list adopting      | "http://localhost/api/client/all/adopt/{id}"            | GET          |
| Pet Boarding               | "http://localhost/api/pet/boarding"                     | POST(PARAM)  |
| Get Pet Medical Conditions | "http://localhost/api/pet/medical/conditions/{id}"      | GET          |
| Get All Pet in Shelter     | "http://localhost/api/shelter/pet-shl/{id}"             | GET          |
| Get All Pet in Shelter     | "http://localhost/api/shelter/vax-shl/{id}"             | GET          |
| Get All Assigned Animals   | "http://localhost/api/service-provider/all/assigned"    | GET          |
| Get All Vaccinate Points   | "http://localhost/api/service-provider/all/vaccination" | GET          |
| Get eVaxDose               | "http://localhost/api/service-provider/evax/{id}"       | GET          |
| Vaccination Regulations    | "http://localhost/api/vaccination/regulations"          | GET          |
| Get Wild Animal Vax        | "http://localhost/api/wild-animal/animal/vax/{id}"      | GET          |
| Soft Delete Adoption       | "http://localhost/api/adoption/soft/del/{id}"           | PUT          |
| Adoption Detail Service    | NO CONTROLLER - NO ACCESS POINT                         | CRUD SERVICE |

<h1>Recommended Technologies for API Test and Documentations</h1>

<h4>
    <ul>
        <li>Postman API</li>
        <li>Swagger Spring OpenAPI</li>
        <li>Katalon Studio</li>
        <li>Apache JMeter</li>
    </ul>
</h4>