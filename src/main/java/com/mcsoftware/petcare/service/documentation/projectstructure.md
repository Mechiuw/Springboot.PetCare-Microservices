<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <h1>Project Structure </h1>
    <p>Project Structure to get through documentations and each component to dive in quickly. 
    the path can be mistakenly typed but soon will be fixed. <br> <br>let us know more to fix it!</p>
    <h2>src/ <br>
        &nbsp;&nbsp;&nbsp;&nbsp;└── main/ <br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── java/ <br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── com/ <br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── mcsoftware/ <br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── petcare/ <br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── service/ 
    </h2>


<h1>Maven Dependencies and Plugins</h1>
    <h2>Dependencies:</h2>
    <ul class="dependencies">
        <li>org.springframework.boot:spring-boot-starter-data-jpa</li>
        <li>org.springframework.boot:spring-boot-starter-data-rest</li>
        <li>org.springframework.boot:spring-boot-starter-validation</li>
        <li>org.springframework.boot:spring-boot-starter-web</li>
        <li>org.springframework.boot:spring-boot-devtools (runtime)</li>
        <li>org.postgresql:postgresql (runtime)</li>
        <li>org.projectlombok:lombok (optional)</li>
        <li>org.springframework.boot:spring-boot-starter-test (scope: test)</li>
        <li>org.springframework.restdocs:spring-restdocs-mockmvc (scope: test)</li>
    </ul>

<h2>Plugins:</h2>
    <ul class="plugins">
        <li>org.asciidoctor:asciidoctor-maven-plugin (version: 2.2.1)</li>
        <li>org.springframework.boot:spring-boot-maven-plugin</li>
    </ul>

<h1>Project Components</h1>
    <ul>
    <li><h2>Model</h2></li>
    <p>model contains with entity,dto,struct directory.<br> 
    struct contains with abstract classes that extends to specific entities</p>
<h4>
    &nbsp;&nbsp;&nbsp;&nbsp;└── entity/ <br>
    &nbsp;&nbsp;&nbsp;&nbsp;└── dto/ <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── request/ <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── response/ <br>
    &nbsp;&nbsp;&nbsp;&nbsp;└── struct/ <br></h4>
    <li><h2>repository</h2></li>
    <p>repository contains with repo interface extended with JpaRepository</p>
    <li><h2>service</h2></li>
    <p>service contains with interfaces,implementation, and documentation directory, <br>
    that also contains java interface, java class, and dot md files for docs</p>
<h4>
    &nbsp;&nbsp;&nbsp;&nbsp;└── documentation/ <br>
    &nbsp;&nbsp;&nbsp;&nbsp;└── impl/ <br>
    &nbsp;&nbsp;&nbsp;&nbsp;└── interfaces/ <br></h4>
    <li><h2>Utils</h2></li>
    <p>contained with utility and helper class : <br> 
    converter and validator directory</p>
<h4>
    &nbsp;&nbsp;&nbsp;&nbsp;└── converter/ <br>
    &nbsp;&nbsp;&nbsp;&nbsp;└── validator/ <br> </h4>
    <li><h2>Endpoint</h2></li>
    <p>This is the endpoint of this SpringBoot application</p>
<h4>
    &nbsp;&nbsp;&nbsp;&nbsp;└── PetcareApplication/ <br>
</h4>
    PATH : src/main/java/com/mcsoftware/petcare/PetcareApplication.java
</ul>

</body>
</html>
