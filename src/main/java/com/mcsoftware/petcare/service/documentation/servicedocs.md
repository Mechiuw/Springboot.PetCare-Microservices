
<h1>Pet care Services</h1>
<div class="service-desc"> 
    <p>this page is for service documentations, <br> 
    specifically for services in this Pet Care BE application.</p> 
</div>

<div class="service-desc"> 
    <h2>Service Structure</h2>
    <label>Create Service from "VaccinationPointServiceImpl"</label><br>
<pre><code>
@Override
public VaccinatePointResponse create(VaccinatePointRequest vaccinatePointRequest) {
    try {
        //[BUILD] build vaccinate point entity
        VaccinatePoint vaccinatePoint = builderConverter.vaccinatePointBuilderConvert(vaccinatePointRequest);
<br>
        //[FILTER] filter vp entity using validator helper class
        VaccinatePoint validatedVaccinatePoint = vpValidator(vaccinatePoint);
<br>
        //[SAVE] send validated vp entity to repo and save it
        VaccinatePoint savedVp = vaccinationPointRepository.saveAndFlush(validatedVaccinatePoint);
<br>
        //[BUILD] || [RETURN] build the response from the saved vp entity and returns it
        return builderConverter.vaccinatePointResponseBuilderConvert(savedVp);
<br>
        //[CATCHERS] Exception Catchers for Not found,validation,and other Exceptions
    } catch (EntityNotFoundException e) {
        throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
    } catch (ValidationException e) {
        throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
    } catch (Exception e) {
        throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
    }
}
</code></pre>
    <label>Update Service from "VaccinationPointServiceImpl"</label><br>
<pre><code>
@Override
    public VaccinatePointResponse update(String id, VaccinatePointRequest vaccinatePointRequest) {
        try {
            //[FIND] Find the existing vp entity from database
            VaccinatePoint findVp = vpFinder(id);
<br>
            //[UPDATE] Update each property vp entity has
            findVp.setFirstVaccineDate(vaccinatePointRequest.getFirstVaccinateDate());
            findVp.setSecondVaccineDate(vaccinatePointRequest.getSecondVaccinateDate());
            findVp.setServiceProviderId(serviceProviderRepository.findById(vaccinatePointRequest.getServiceProviderId())
                    .orElseThrow(() -> new NoSuchElementException("not found any service provider")));
            findVp.setShelterId(shelterRepository.findById(vaccinatePointRequest.getShelterId())
                    .orElseThrow(() -> new NoSuchElementException("not found any shelter id")));
            findVp.setWildAnimalId(wildAnimalRepository.findById(vaccinatePointRequest.getShelterId())
                    .orElseThrow(() -> new NoSuchElementException("not found any wild animal id")));
<br>
            //[SAVE] save the changes on recent updated entity to send it to database
            VaccinatePoint savedVp = vaccinationPointRepository.saveAndFlush(findVp);
<br>
            //[BUILD] || [RETURN]  build the response from the saved vp entity and returns it
            return builderConverter.vaccinatePointResponseBuilderConvert(savedVp);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }
</code></pre>
    <label>Delete Service from "VaccinationPointServiceImpl"</label><br>
<pre>
<code>
@Override
    public void delete(String id) {
        try {
            //[RETURN] Directly execute delete repo service by getting the entity from id and deletes it
            vaccinationPointRepository.delete(
                    vaccinationPointRepository.findById(id)
                            .orElseThrow(() -> new NoSuchElementException("not found any vaccination point")));
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }
</code>
</pre>
    <label>Get By Id Service from "VaccinationPointServiceImpl"</label><br>
<pre><code>
@Override
    public VaccinatePointResponse getById(String id) {
        try {
            //[RETURN] find and return the entity using finder function (finder -> entity),returns the response convert (entity -> response)
            return builderConverter.vaccinatePointResponseBuilderConvert(vpFinder(id));
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }
</code></pre>
    <label>Get All Service from "VaccinationPointServiceImpl"</label><br>
<pre><code>
@Override
    public List<VaccinatePoint> getAll() {
        try {
            //[FETCH] Fetch All vp data from repo
            List<VaccinatePoint> vps = vaccinationPointRepository.findAll();
            //[CONDITIONS] if it's not empty, return the fetched data
            if (!vps.isEmpty()){
                return vps.stream().toList();
            }
            //[CONDITIONS] if it's empty, return an empty list
            else {
                return Collections.emptyList();
            }
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }
</code></pre>
<div>
<br>
<div>
    <h2>Helper Structure</h2>
    <label>Finder Function Example</label>
<pre><code>
@Override
    public VaccinatePoint vpFinder(String id) {
        try {
            //[RETURN] it returns an entity by checking the repo by id
            return vaccinationPointRepository
                    .findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("not found any vp entity with id : " + id));
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(String.format("Entity not found: %s", e.getMessage()), e);
        }  catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }
</code></pre>
    <label>Validator Function Example</label>
<pre><code>
@Override
    public VaccinatePoint vpValidator(VaccinatePoint vaccinatePoint) {
        try {
            //[CONDITIONS] checks every each vp entity body request or presented vp entity and assert to be not null
            if (vaccinatePoint != null) {
                if (vaccinatePoint.getFirstVaccineDate() == null) {
                    throw new ValidationException("First vaccine date can't be null");
                }
                if (vaccinatePoint.getSecondVaccineDate() == null) {
                    throw new ValidationException("Second vaccine date can't be null");
                }
                if (vaccinatePoint.getWildAnimalId() == null) {
                    throw new ValidationException("Wild animal ID can't be null");
                }
                if (vaccinatePoint.getShelterId() == null) {
                    throw new ValidationException("Shelter ID can't be null");
                }
                if (vaccinatePoint.getServiceProviderId() == null) {
                    throw new ValidationException("Service provider ID can't be null");
                }
            } else {
                throw new ValidationException("Validation exception || VaccinatePoint object is null");
            }
            return vaccinatePoint;
        } catch (ValidationException e) {
            throw new RuntimeException(String.format("Validation failed: %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to execute: %s", e.getMessage()), e);
        }
    }
</code></pre>
</div>

<div >
<h1>That's All!</h1>
<p>I hope you find this documentation well, <br>
    and if there's any possible bugs or errors, lmk!</p>
<h5>My Contact : </h5>
<label>Email : matthewdpk@gmail.com</label><br>
<label>Github : <link urn="https://github.com/Mechiuw">Mechiuw</label><br>
</div>



